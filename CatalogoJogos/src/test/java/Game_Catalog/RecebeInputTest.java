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
    JSONObject objetoTestEmpresa;
    JSONObject objetoTestPlataforma;
    JSONObject objetoParametro;
    JSONParser parser;
    FileWriter escritor;
    File arquivoTemp;
    FileReader leitor;

    @Rule TemporaryFolder folder;

    @BeforeEach
    void iniciar() throws IOException {
        inputMock = mock(new RecebeInput().getClass());
        objetoTestEmpresa = new JSONObject();
        objetoTestEmpresa.put( "Empresa","Nintendo");
        objetoTestPlataforma = new JSONObject();
        objetoTestPlataforma.put("Nintendo","Wii");
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
        when(inputMock.LerEmpresa(objetoParametro)).thenReturn(objetoTestEmpresa);
        assertEquals("Nintendo",objetoTestEmpresa.get("Empresa").toString());
    }

    @Test
    @DisplayName("Ler Empresa existente")
    void LerEmpresaExistente() throws IOException, ParseException {
        objetoParametro = (JSONObject) parser.parse(leitor);
        inputSimulator = new ByteArrayInputStream("Sony".getBytes());
        System.setIn(inputSimulator);
        when(inputMock.LerEmpresa(objetoParametro)).thenCallRealMethod();
        objetoTestEmpresa = inputMock.LerEmpresa(objetoParametro);
        assertTrue(objetoTestEmpresa.containsKey("PS1"));
    }

    @Test
    @DisplayName("Ler Empresa não existente")
    void LerEmpresaNaoExistente() throws IOException, ParseException {
        objetoParametro = (JSONObject) parser.parse(leitor);
        inputSimulator = new ByteArrayInputStream("Seny".getBytes());
        inputMock.invalido = new JSONObject();
        System.setIn(inputSimulator);
        when(inputMock.LerEmpresa(objetoParametro)).thenCallRealMethod();
        objetoTestEmpresa = inputMock.LerEmpresa(objetoParametro);
        assertTrue(objetoTestEmpresa.containsKey("Invalido"));
    }

    @Test
    @DisplayName("Ler mock de plataforma")
    void LerPlataformaMock()
    {
        when(inputMock.LerPlataforma(objetoParametro)).thenReturn(objetoTestPlataforma);
        assertEquals("Wii",objetoTestPlataforma.get("Nintendo").toString());
    }

    @Test
    @DisplayName("Ler plataforma existente")
    void LerPlataformaExistente() throws IOException, ParseException {
        objetoParametro = (JSONObject)parser.parse(leitor);
        objetoParametro = (JSONObject) ((JSONObject)objetoParametro.get("Empresa")).get("Sony");
        inputSimulator = new ByteArrayInputStream("PS1".getBytes());
        System.setIn(inputSimulator);
        when(inputMock.LerPlataforma(objetoParametro)).thenCallRealMethod();
        objetoTestPlataforma = inputMock.LerPlataforma(objetoParametro);
        assertTrue(objetoTestPlataforma.containsKey("Crash Bandicoot"));
    }
}