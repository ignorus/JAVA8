package Game_Catalog;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Rule;
import org.junit.jupiter.api.*;
import org.junit.rules.TemporaryFolder;

import java.io.*;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SalvarArquivoJSONTest {

    JSONObject lido;
    JSONParser parser;
    SalvarArquivoJSON salvarMock;
    LerArquivoJSON arquivoMock;
    JSONObject verificador;
    FileReader ler;
    JSONArray testArray;
    FileWriter iniciar;
    String retorno;

    @Rule TemporaryFolder folder;

    @BeforeEach
    void iniciar() throws IOException {
        folder = new TemporaryFolder();
        folder.create();
        lido = new JSONObject();
        verificador = new JSONObject();
        parser = new JSONParser();
        salvarMock = mock(new SalvarArquivoJSON("src/files/multiJson.json").getClass());
        arquivoMock = mock(new LerArquivoJSON().getClass());
        testArray = new JSONArray();
        iniciar = new FileWriter("src/files/multiJson.json");
        iniciar.write("{\"Empresa\":{\"Sony\":{\"PS4\":{},\"PS3\":{},\"PS2\":{},\"PS1\":{\"Crash Bandicoot\":[\"Crash\",\"Cortex\",\"Coco\",\"Pura\"]}},\"Nintendo\":{},\"Microsoft\":{}}}");
        iniciar.close();

    }

    @Test
    @DisplayName("Salvar um JSON em mock, dado um objeto e quatro argumentos")
    void SalvarJSONMultiNivelMock() throws IOException {
        String empresa = "Nintendo";
        String plataforma = "Wii";
        String jogo = "MarioKart";
        String [] personagens = new String[]{"Mario","Luigi","Wario","Daisy","Peach"};
        when(salvarMock.salvarJogoePersonagemJSON(lido,empresa,plataforma,jogo,personagens)).thenReturn("Jogo Salvo");
        assertEquals("Jogo Salvo",salvarMock.salvarJogoePersonagemJSON(lido,empresa,plataforma,jogo,personagens));
    }

    @Test
    @DisplayName("Salvar um Jogo ja existente")
    void SalvarJogoExistente() throws IOException, ParseException {
        ler = new FileReader("src/files/multiJson.json");
        String empresa = "Sony";
        String plataforma = "PS1";
        String jogo = "Crash Bandicoot";
        String [] personagens = new String[]{};
        lido = ((JSONObject) parser.parse(ler));
        ler.close();
        SalvarArquivoJSON salvar = new SalvarArquivoJSON("src/files/multiJson.json");
        retorno = salvar.salvarJogoePersonagemJSON(lido,empresa,plataforma,jogo,personagens);
        assertEquals("Jogo já existe",retorno);
    }

    @Test
    @DisplayName("Salvar um Jogo e seus Personagens, dado uma Empresa e Plataforma existentes")
    void SalvarPersonagensEJogo() throws IOException, ParseException {
        ler = new FileReader("src/files/multiJson.json");
        String empresa = "Sony";
        String plataforma = "PS2";
        String jogo = "Kingdom Hearts II";
        String [] personagens = new String[]{"Sora","Roxas","Axel","Donald","Goofy",
                "Riku","Kairi","Xemnas","Mickey","Mulan"};
        lido = ((JSONObject) parser.parse(ler));
        ler.close();
        SalvarArquivoJSON salvar = new SalvarArquivoJSON("src/files/multiJson.json");
        salvar.salvarJogoePersonagemJSON(lido,empresa,plataforma,jogo,personagens);
        ler = new FileReader("src/files/multiJson.json");
        lido = ((JSONObject) parser.parse(ler));
        ler.close();
        verificador = (JSONObject) ((JSONObject) ((JSONObject)lido.get("Empresa")).get(empresa)).get(plataforma);
        assertEquals("[\"Sora\",\"Roxas\",\"Axel\",\"Donald\",\"Goofy\"," +
                "\"Riku\",\"Kairi\",\"Xemnas\",\"Mickey\",\"Mulan\"]",verificador.get(jogo).toString());
    }

    @Test
    @DisplayName("Adiciona Jogo com Personagens, plataforma ainda não registrada")
    void AdicionaPlataforma() throws IOException, ParseException {
        ler = new FileReader("src/files/multiJson.json");
        String empresa = "Nintendo";
        String plataforma = "Wii";
        String jogo = "Super Mario Galaxy";
        String [] personagens = new String[]{"Mario","Bowser","Peach","Rosalina","Luigi",
                "Lumas","Toads"};
        lido = ((JSONObject) parser.parse(ler));
        ler.close();
        SalvarArquivoJSON salvar = new SalvarArquivoJSON("src/files/multiJson.json");
        salvar.salvarJogoePersonagemJSON(lido,empresa,plataforma,jogo,personagens);
        ler = new FileReader("src/files/multiJson.json");
        lido = ((JSONObject) parser.parse(ler));
        ler.close();
        verificador = (JSONObject) ((JSONObject)lido.get("Empresa")).get(empresa);
        assertTrue(verificador.containsKey("Wii"));
    }

    @Test
    @DisplayName("Adiciona Jogo com Personagens, Empresa ainda não registrada")
    void AdicionaEmpresa() throws IOException, ParseException {
        ler = new FileReader("src/files/multiJson.json");
        String empresa = "Sega";
        String plataforma = "Mega Drive";
        String jogo = "Sonic the Hedgehog";
        String [] personagens = new String[]{"Sonic","Dr. Robotnik","Badniks"};
        lido = ((JSONObject) parser.parse(ler));
        ler.close();
        SalvarArquivoJSON salvar = new SalvarArquivoJSON("src/files/multiJson.json");
        salvar.salvarJogoePersonagemJSON(lido,empresa,plataforma,jogo,personagens);
        ler = new FileReader("src/files/multiJson.json");
        lido = ((JSONObject) parser.parse(ler));
        ler.close();
        verificador = (JSONObject)lido.get("Empresa");
        assertTrue(verificador.containsKey("Sega"));
    }
}
