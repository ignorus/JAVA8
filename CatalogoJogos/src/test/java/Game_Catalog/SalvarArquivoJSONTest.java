package Game_Catalog;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Rule;
import org.junit.jupiter.api.*;
import org.junit.rules.TemporaryFolder;

import java.io.*;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SalvarArquivoJSONTest {

    JSONObject lido;
    JSONParser parser;
    SalvarArquivoJSON salvarMock;
    LerArquivoJSON arquivoMock;
    JSONObject verificador;

    @Rule TemporaryFolder folder;

    @BeforeEach
    void iniciar() throws IOException {
        folder = new TemporaryFolder();
        folder.create();
        lido = new JSONObject();
        verificador = new JSONObject();
        parser = new JSONParser();
        salvarMock = mock(new SalvarArquivoJSON("src/files/CatalogoJogos.Json").getClass());
        arquivoMock = mock(new LerArquivoJSON().getClass());

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
    @DisplayName("Salvar um Jogo e seus Personagens, dado uma Empresa e Plataforma existentes")
    void SalvarPersonagensEJogo() throws IOException, ParseException {
        String empresa = "Sony";
        String plataforma = "PS2";
        String jogo = "Kingdom Hearts II";
        String [] personagens = new String[]{"Sora","Roxas","Axel","Donald","Goofy",
                "Riku","Kairi","Xemnas","Mickey","Mulan"};
        when(arquivoMock.SepararDadosDoArquivo(arquivoMock.getArquivo())).
                thenReturn((JSONObject) parser.parse(new FileReader("src/files/CatalogoJogos.Json")));
        lido = arquivoMock.SepararDadosDoArquivo(arquivoMock.getArquivo());
        SalvarArquivoJSON salvar = new SalvarArquivoJSON("src/files/CatalogoJogos.Json");
        salvar.salvarJogoePersonagemJSON(lido,empresa,plataforma,jogo,personagens);
        lido = arquivoMock.SepararDadosDoArquivo(arquivoMock.getArquivo());
        verificador = (JSONObject)((JSONObject)((JSONObject)lido.get(empresa)).get(plataforma)).get(jogo);
        assertEquals("[\"Sora\",\"Roxas\",\"Axel\",\"Donald\",\"Goofy\"," +
                " \"Riku\",\"Kairi\",\"Xemnas\",\"Mickey\",\"Mulan\"]",verificador.toString());
    }
}
