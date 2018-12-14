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
import java.util.List;

public class TestarTest {

    @Test
    @DisplayName("Lê arquivo de teste JSON que cotém duas chaves e um valor")
    void LeUmJSON() throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        FileReader leitor = new FileReader("C:/Users/RosaMaria/IdeaProjects/CatalogoJogos/src/files/json.json");
        JSONObject objetoJ = (JSONObject) parser.parse(leitor);
        Assertions.assertEquals("Tiago",objetoJ.get("nome"));

    }

    @Test
    @DisplayName("Lê arquivo de teste JSON que cotém duas chaves e um valor para cada chave")
    void LeUmJSONComDuasChaves() throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        FileReader leitor = new FileReader("C:/Users/RosaMaria/IdeaProjects/CatalogoJogos/src/files/json.json");
        JSONObject objetoJ = (JSONObject) parser.parse(leitor);
        Assertions.assertEquals("23",objetoJ.get("idade"));

    }

    @Test
    @DisplayName("Lê arquivo JSON com varios objetos JSON")
    void LeUMJSONComVariosObjetos() throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        FileReader leitor = new FileReader("C:/Users/RosaMaria/IdeaProjects/CatalogoJogos/src/files/multiJson.json");
        JSONObject arquivo = (JSONObject) parser.parse(leitor);
        JSONObject pessoas = (JSONObject) arquivo.get("pessoa");
        JSONObject nomes = (JSONObject) pessoas.get("nome");
        System.out.println(arquivo.get("pessoa"));
        System.out.println(pessoas.get("nome"));
        System.out.println(pessoas.get("hobbies"));
        System.out.println(nomes.get("primeironome") + " " + nomes.get("segundonome") + " "+ nomes.get("sobrenome"));

    }
}
