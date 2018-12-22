package Game_Catalog;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Rule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.rules.TemporaryFolder;

import java.io.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class RecebeInputTest {

    RecebeInput inputMock;
    InputStream inputSimulator;
    JSONObject objetoTest;
    JSONObject objetoParametro;
    JSONParser parser;
    FileWriter escritor;
    File arquivoTemp;
    FileReader leitor;
    String empresa;

    @Rule TemporaryFolder folder;

    @BeforeEach
    void iniciar() throws IOException {
        inputMock = mock(new RecebeInput().getClass());
        objetoTest = new JSONObject();
        objetoTest.put( "Empresa","Nintendo");
        parser = new JSONParser();
        folder = new TemporaryFolder();
        folder.create();
        arquivoTemp = folder.newFile("CatalogoTemporario");
        escritor = new FileWriter(arquivoTemp);
        escritor.write("{\"Empresa\":{\"Sony\":{\"PS4\":{},\"PS3\":{},\"PS2\":{},\"PS1\":{\"Crash Bandicoot\":[\"Crash\",\"Cortex\",\"Coco\",\"Pura\"]}},\"Nintendo\":{},\"Microsoft\":{}}}");
        escritor.close();
        leitor = new FileReader(arquivoTemp);
    }

    @Test
    @DisplayName("Recebe o mock do comando para ler Arquivo")
    void ComandoLerMock()
    {
        when(inputMock.LerOuSalvar()).thenReturn("ler");
        assertTrue("Ler".equalsIgnoreCase(inputMock.LerOuSalvar()));
    }

    @Test
    @DisplayName("Recebe o mock do comando para salvar Arquivo")
    void ComandoSalvarMock()
    {
        when(inputMock.LerOuSalvar()).thenReturn("salvar");
        assertTrue("Salvar".equalsIgnoreCase(inputMock.LerOuSalvar()));
    }

    @Test
    @DisplayName("Recebe o comando para ler Arquivo")
    void ComandoLer()
    {
        when(inputMock.LerOuSalvar()).thenCallRealMethod();
        inputSimulator = new ByteArrayInputStream("ler".getBytes());
        System.setIn(inputSimulator);
        assertTrue("ler".equalsIgnoreCase(inputMock.LerOuSalvar()));
    }

    @Test
    @DisplayName("Recebe o comando para salvar Arquivo")
    void ComandoSalvar()
    {
        when(inputMock.LerOuSalvar()).thenCallRealMethod();
        inputSimulator = new ByteArrayInputStream("salvar".getBytes());
        System.setIn(inputSimulator);
        assertTrue("salvar".equalsIgnoreCase(inputMock.LerOuSalvar()));
    }

    @Test
    @DisplayName("Recebe um comando invalido")
    void ComandoInvalido()
    {
        when(inputMock.LerOuSalvar()).thenCallRealMethod();
        inputSimulator = new ByteArrayInputStream("Editar".getBytes());
        System.setIn(inputSimulator);
        assertEquals("Comando Invalido",inputMock.LerOuSalvar());
    }

    @Test
    @DisplayName("Ler Empresa mock")
    void LerEmpresaMock()
    {
        when(inputMock.LerEmpresa(objetoParametro)).thenReturn(objetoTest);
        assertEquals("Nintendo",objetoTest.get("Empresa").toString());
    }

    @Test
    @DisplayName("Ler Empresa existente")
    void LerEmpresaExistente() throws IOException, ParseException {
        when(inputMock.LerEmpresa(objetoParametro)).thenCallRealMethod();
        objetoParametro = (JSONObject) parser.parse(leitor);
        objetoTest = inputMock.LerEmpresa(objetoParametro);
        assertTrue(objetoTest.containsKey("PS1"));
    }
}
