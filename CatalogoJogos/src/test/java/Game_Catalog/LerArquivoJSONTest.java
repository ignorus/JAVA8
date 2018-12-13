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
import java.io.StringReader;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LerArquivoJSONTest {

    JSONObject objetoSimples;


    @BeforeEach
    void setUp() {
        objetoSimples =  new JSONObject();
        objetoSimples.put("nome","Tiago");
    }

    @Test
    @DisplayName("Lê arquivo mockado JSON que cotém uma unica chave e valor")
    void ParticionaUmJSON() {

        LerArquivoJSON lerMockado = mock (new LerArquivoJSON().getClass());
        when(lerMockado.getArquivoEstrturado()).thenReturn(objetoSimples);
        Assert.assertEquals("Tiago",lerMockado.getArquivoEstrturado().get("nome"));
    }
}
