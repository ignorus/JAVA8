package Game_Catalog;

import junit.framework.Assert;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.FileReader;
import java.io.IOException;

public class TestarTest {

    @Test
    @DisplayName("Lê arquivo de teste JSON que cotém uma unica chave e valor")
    void LeUmJSON() throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        JSONObject objetoJ = (JSONObject) parser.parse(new FileReader("C:/Users/RosaMaria/IdeaProjects/CatalogoJogos/src/files/json.json"));
        Assert.assertEquals("Tiago",objetoJ.get("nome"));

    }
}
