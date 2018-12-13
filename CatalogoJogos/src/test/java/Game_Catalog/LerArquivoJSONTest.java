package Game_Catalog;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Rule;
import org.junit.jupiter.api.*;
import org.junit.rules.TemporaryFolder;

import java.io.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LerArquivoJSONTest {

    JSONObject objetoSimples;
    JSONParser parser;
    String verificarRetorno;

    @Rule TemporaryFolder folder;

    @BeforeEach
    void setUp() throws IOException {
        objetoSimples = new JSONObject();
        objetoSimples.put("nome", "Tiago");
        parser = new JSONParser();
        folder = new TemporaryFolder();
        folder.create();
    }

    @Test
    @DisplayName("Dado um arquivo valido e estruturado que cotém uma unica chave e valor, garantir que o objeto guardou esta informação")
    void recuperaUmJSON() {

        LerArquivoJSON lerMockado = mock (new LerArquivoJSON().getClass());
        when(lerMockado.getArquivoEstrturado()).thenReturn(objetoSimples);
        assertEquals("Tiago",lerMockado.getArquivoEstrturado().get("nome"));
    }

    @Test
    @DisplayName("Dado arquivo lido, estruturar e retornar valor relativo a uma chave, passado por string")
    void valorChaveStringReader() throws IOException, ParseException {
        LerArquivoJSON lerMockado = mock(new LerArquivoJSON().getClass());
        StringReader leitor = new StringReader("teste");
        when(lerMockado.SepararDadosDoArquivo(leitor)).thenReturn((JSONObject) parser.parse("{\"nome\":\"Ricardo\"}" ));
        objetoSimples = lerMockado.SepararDadosDoArquivo(leitor);
        assertEquals("Ricardo",objetoSimples.get("nome"));
    }

    @Test
    @DisplayName("Dado um arquivo mock valido, lê-lo")
    void confirmaLeituraMock() {
        LerArquivoJSON lerMockado = mock(new LerArquivoJSON().getClass());
        when(lerMockado.AbrirArquivoJSON(anyString())).thenReturn("Sucesso");
        assertEquals("Sucesso",lerMockado.AbrirArquivoJSON("teste.json"));
    }

    @Test
    @DisplayName("Dado um arquivo real valido, lê-lo")
    void confirmaLeitura(){
        LerArquivoJSON lerArquivo = new LerArquivoJSON();
        assertEquals("Sucesso", lerArquivo.AbrirArquivoJSON("src/files/json.json"));
    }

    @Test
    @DisplayName("Dado um arquivo invalido mock, reportar erro")
    void negaLeituraMock() {
        LerArquivoJSON lerMockado = mock(new LerArquivoJSON().getClass());
        when(lerMockado.AbrirArquivoJSON(anyString())).thenReturn("Arquivo Invalido");
        assertEquals("Arquivo Invalido",lerMockado.AbrirArquivoJSON("teste"));
    }

    @Test
    @DisplayName("Dado um arquivo invalido, reportar erro")
    void negaLeitura() {
        LerArquivoJSON lerArquivo = new LerArquivoJSON();
        assertEquals("Arquivo Invalido",lerArquivo.AbrirArquivoJSON("teste"));
    }

    @Test
    @DisplayName("Dado um arquivo temporario valido, estruturá-lo")
    void estruturaTemporario() throws IOException, ParseException {
        LerArquivoJSON lerArquivoTemp = new LerArquivoJSON();
        File arquivoJsonTest = folder.newFile("JSONTemporario.json");
        FileWriter escritorTest = new FileWriter(arquivoJsonTest);
        escritorTest.write("{\"nome\":\"Sonic\"}");
        escritorTest.close();
        verificarRetorno = lerArquivoTemp.AbrirArquivoJSON((arquivoJsonTest.getAbsolutePath()));
        objetoSimples = lerArquivoTemp.SepararDadosDoArquivo(lerArquivoTemp.getArquivo());
        assertEquals("Sonic", objetoSimples.get("nome"));
    }
}
