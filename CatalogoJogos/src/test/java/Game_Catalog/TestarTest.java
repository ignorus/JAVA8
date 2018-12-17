package Game_Catalog;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestarTest {

    @Test
    @DisplayName("Lê arquivo de teste JSON que cotém duas chaves e um valor")
    void LeUmJSON() throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        FileReader leitor = new FileReader("C:/Users/RosaMaria/IdeaProjects/CatalogoJogos/src/files/json.json");
        JSONObject objetoJ = (JSONObject) parser.parse(leitor);
        assertEquals("Tiago",objetoJ.get("nome"));

    }

    @Test
    @DisplayName("Lê arquivo de teste JSON que cotém duas chaves e um valor para cada chave")
    void LeUmJSONComDuasChaves() throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        FileReader leitor = new FileReader("C:/Users/RosaMaria/IdeaProjects/CatalogoJogos/src/files/json.json");
        JSONObject objetoJ = (JSONObject) parser.parse(leitor);
        assertEquals("23",objetoJ.get("idade"));

    }

    @Test
    @DisplayName("Lê arquivo JSON com varios objetos JSON")
    void LeUMJSONComVariosObjetos() throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        FileReader leitor = new FileReader("C:/Users/RosaMaria/IdeaProjects/CatalogoJogos/src/files/multiJson.json");
        JSONObject arquivo = (JSONObject) parser.parse(leitor);
        assertEquals("Tiago",((JSONObject) ((JSONObject) arquivo.get("pessoa")).get("nome")).get("primeironome"));
    }

    @Test
    @DisplayName("Lê arquivo JSON com varios objetos JSON e recupera o valor de uma das chaves filho")
    void LeUMJSONComVariosObjetosGaranteTamanho() throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        FileReader leitor = new FileReader("C:/Users/RosaMaria/IdeaProjects/CatalogoJogos/src/files/multiJson.json");
        JSONObject arquivo = (JSONObject) parser.parse(leitor);
        Collection ordenada = ((JSONObject) ((JSONObject) arquivo.get("pessoa")).get("nome")).values();
        assertEquals(6,ordenada.size());
    }
}
