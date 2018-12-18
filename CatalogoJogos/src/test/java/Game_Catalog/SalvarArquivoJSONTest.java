package Game_Catalog;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.Rule;
import org.junit.jupiter.api.*;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SalvarArquivoJSONTest {

    JSONObject ler;
    JSONParser parser;
    SalvarArquivoJSON salvarMock;

    @Rule TemporaryFolder folder;

    @BeforeEach
    void iniciar() throws IOException {
        folder = new TemporaryFolder();
        folder.create();
        ler = new JSONObject();
        parser = new JSONParser();
        salvarMock = mock(new SalvarArquivoJSON().getClass());

    }

    @Test
    @DisplayName("Salvar um JSON em mock, dado um objeto e quatro argumentos")
    void SalvarJSONMultiNivelMock(){
        String empresa = "Nintendo";
        String plataforma = "Wii";
        String jogo = "MarioKart";
        String [] personagens = new String[]{"Mario","Luigi","Wario","Daisy","Peach"};
        when(salvarMock.salvarJogoePersonagemJSON(ler,empresa,plataforma,jogo,personagens)).thenReturn("Jogo salvo");
        Assertions.assertEquals("Jogo salvo",salvarMock.salvarJogoePersonagemJSON(ler,empresa,plataforma,jogo,personagens));
    }

    @Test
    @DisplayName("Salvar um JSON em arquivo, dado um objeto e quatro argumentos")
    void SalvarJSONMultiNivelEmArquivo()
    {

    }
}
