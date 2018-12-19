package Game_Catalog;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Rule;
import org.junit.jupiter.api.*;
import org.junit.rules.TemporaryFolder;

import java.io.*;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
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

    @Test
    @DisplayName("Dado um arquivo valido, retornar os nomes das empresas fabricantes")
    void RetornaFabricantes() throws IOException, ParseException {
        LerArquivoJSON lerArquivo = new LerArquivoJSON();
        lerArquivo.AbrirArquivoJSON("src/files/CatalogoJogos.Json");
        objetoSimples = lerArquivo.SepararDadosDoArquivo(lerArquivo.getArquivo());
        assertTrue(((JSONObject) objetoSimples.get("Empresa")).keySet().contains("Sony"));
    }

    @Test
    @DisplayName("Dado um arquivo valido, retornar os nomes das plataformas da empresa Sony")
    void RetornaPlataformasSony() throws IOException, ParseException {
        LerArquivoJSON lerArquivo = new LerArquivoJSON();
        lerArquivo.AbrirArquivoJSON("src/files/CatalogoJogos.Json");
        objetoSimples = lerArquivo.SepararDadosDoArquivo(lerArquivo.getArquivo());
        objetoSimples = ((JSONObject)((JSONObject) objetoSimples.get("Empresa")).get("Sony"));
        assertEquals("[PS4, PS3, PS2, PS1]",objetoSimples.keySet().toString());
    }

    @Test
    @DisplayName("Retornar jogos de PS1")
    void RetornaJogos() throws IOException, ParseException {
        LerArquivoJSON lerArquivo = new LerArquivoJSON();
        lerArquivo.AbrirArquivoJSON("src/files/CatalogoJogos.Json");
        objetoSimples = lerArquivo.SepararDadosDoArquivo(lerArquivo.getArquivo());
        objetoSimples = ((JSONObject)((JSONObject)((JSONObject) objetoSimples.get("Empresa")).get("Sony")).get("PS1"));
        assertTrue(objetoSimples.keySet().contains("Crash Bandicoot"));
    }

    @Test
    @DisplayName("Retornar personagens de um jogo")
    void RetornaPersonagens() throws IOException, ParseException {
        LerArquivoJSON lerArquivo = new LerArquivoJSON();
        lerArquivo.AbrirArquivoJSON("src/files/CatalogoJogos.Json");
        objetoSimples = lerArquivo.SepararDadosDoArquivo(lerArquivo.getArquivo());
        objetoSimples = (((JSONObject)((JSONObject)((JSONObject) objetoSimples.get("Empresa")).get("Sony")
        ).get("PS1")));
        assertEquals("[\"Crash\",\"Cortex\",\"Coco\",\"Pura\"]",objetoSimples.get("Crash Bandicoot").toString());
    }
}
