package Game_Catalog;

import junit.framework.Assert;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LerArquivoJSONTest {

    JSONObject objetoSimples;
    JSONParser parser;


    @BeforeEach
    void setUp() {
        objetoSimples =  new JSONObject();
        objetoSimples.put("nome","Tiago");
        parser = new JSONParser();
    }

    @Test
    @DisplayName("Lê arquivo mockado JSON que cotém uma unica chave e valor")
    void ParticionaUmJSON() {

        LerArquivoJSON lerMockado = mock (new LerArquivoJSON().getClass());
        when(lerMockado.getArquivoEstrturado()).thenReturn(objetoSimples);
        assertEquals("Tiago",lerMockado.getArquivoEstrturado().get("nome"));
    }

    @Test
    @DisplayName("Retorna valor relativo a uma chave, passado por string")
    void ValorChaveStringReader() throws IOException, ParseException {
        LerArquivoJSON lerMockado = mock(new LerArquivoJSON().getClass());
        StringReader leitor = new StringReader("teste");
        when(lerMockado.SepararDadosDoArquivo(leitor)).thenReturn((JSONObject) parser.parse("{\"nome\":\"Ricardo\"}" ));
        objetoSimples = lerMockado.SepararDadosDoArquivo(leitor);
        assertEquals("Ricardo",objetoSimples.get("nome"));
    }
}
