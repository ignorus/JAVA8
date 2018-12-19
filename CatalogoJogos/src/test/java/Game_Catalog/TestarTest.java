package Game_Catalog;

import org.json.JSONArray;
import org.json.JSONString;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


import static java.util.Collections.singletonMap;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestarTest {

    JSONObject objetoSalvar = new JSONObject();
    JSONParser parser = new JSONParser();
    JSONObject objetoComparar = new JSONObject();
    JSONObject objecttest = new JSONObject();

/*    @Test
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
    @DisplayName("Lê arquivo JSON com varios objetos JSON e retorna o valor de um filho")
    void LeUMJSONComVariosObjetos() throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        FileReader leitor = new FileReader("C:/Users/RosaMaria/IdeaProjects/CatalogoJogos/src/files/multiJson.json");
        JSONObject arquivo = (JSONObject) parser.parse(leitor);
        assertEquals("Tiago",((JSONObject) ((JSONObject) arquivo.get("pessoa")).get("nome")).get("primeironome"));
    }*/



    @Test
    @DisplayName("Salvar Objetos em arquivo")
    void SalvarObjetoemJSONCamadas() throws IOException, ParseException {
        FileWriter escritor = new FileWriter("src/files/EscreverJson.json");
        objetoSalvar.putAll(singletonMap("Teste", singletonMap("TesteCamada","Salvar")));
        escritor.write(objetoSalvar.toJSONString());
        escritor.close();
        FileReader leitor = new FileReader("src/files/EscreverJson.json");
        objetoComparar = (JSONObject) parser.parse(leitor);
        objetoComparar = ((JSONObject) objetoComparar.get("Teste"));
        Assertions.assertEquals("Salvar",objetoComparar.get("TesteCamada").toString());
    }

    @Test
    @DisplayName("Salvar Objetos ja existentes em arquivo")
    void SalvarObjetoemJSONCamadasExistente() throws IOException, ParseException {
        FileReader leitor = new FileReader("src/files/EscreverJson.json");
        objetoSalvar = (JSONObject) parser.parse(leitor);
        leitor.close();
        objecttest = ((JSONObject) objetoSalvar.get("Teste"));
        objecttest.putIfAbsent("TesteEscreverCamada","Ler");
        FileWriter escrever = new FileWriter("src/files/EscreverJson.json");
        escrever.write(objetoSalvar.toJSONString());
        escrever.close();
        FileReader leitor2 = new FileReader("src/files/EscreverJson.json");
        objetoComparar = (JSONObject) parser.parse(leitor2);
        leitor2.close();
        objetoComparar = ((JSONObject) objetoComparar.get("Teste"));
        Assertions.assertEquals(2,objetoComparar.size());

    }

    @Test
    @DisplayName("Escreve um JSON MultiCamadas")
    void escreverMultiCamadas() throws IOException {
        FileWriter escritor = new FileWriter("src/files/multiJson.json");
        objetoSalvar.putAll(singletonMap("Pessoa", singletonMap("Nome",singletonMap("Sobrenome","Debs"))));
        escritor.write(objetoSalvar.toJSONString());
        escritor.close();
    }

    @Test
    @DisplayName("Testar PutIfAbscent")
    void PutIfAbscenteTest() throws IOException, ParseException {
        FileReader leitor = new FileReader("src/files/multiJson.json");
        objetoSalvar = (JSONObject) parser.parse(leitor);
        leitor.close();
        objecttest = ((JSONObject)((JSONObject) objetoSalvar.get("Pessoa")).get("Nome"));
        objecttest.putIfAbsent("PrimeiroNome","Tiago");
        FileWriter escritor = new FileWriter("src/files/multiJson.json");
        escritor.write(objetoSalvar.toJSONString());
        escritor.close();
        leitor = new FileReader("src/files/multiJson.json");
        objetoSalvar = (JSONObject) parser.parse(leitor);
        leitor.close();
        objecttest = ((JSONObject) objetoSalvar.get("Pessoa"));
        objecttest.putIfAbsent("Hobbies",singletonMap("Esporte","Corrida"));
        escritor = new FileWriter("src/files/multiJson.json");
        escritor.write(objetoSalvar.toJSONString());
        escritor.close();
        leitor = new FileReader("src/files/multiJson.json");
        objetoSalvar = (JSONObject) parser.parse(leitor);
        leitor.close();
        objecttest = ((JSONObject)((JSONObject) objetoSalvar.get("Pessoa")).get("Hobbies"));
        objecttest.putIfAbsent("Dança","Tango");
        escritor = new FileWriter("src/files/multiJson.json");
        escritor.write(objetoSalvar.toJSONString());
        escritor.close();
        assertTrue(objecttest.containsKey("Dança"));
    }

    @Test
    @DisplayName("Salvar Array em arquivo JSON")
    void SalvarArray() throws IOException, ParseException {
        String[] conjunto = new String[] {"Tiago","Bugan","Debs"};
        JSONArray teste = new JSONArray();
        teste.put(conjunto[0]);
        teste.put(conjunto[1]);
        teste.put(conjunto[2]);
        Assertions.assertEquals("Tiago",teste.get(0).toString());
        JSONObject objetoTest = new JSONObject();
        objetoTest.put("nome",teste);
        FileWriter escritor = new FileWriter("src/files/json.json");
        escritor.write(objetoTest.toJSONString());
        escritor.close();
        FileReader leitor = new FileReader("src/files/json.json");
        objetoComparar = (JSONObject) parser.parse(leitor);
        leitor.close();
        assertEquals("[\"Tiago\",\"Bugan\",\"Debs\"]",objetoComparar.get("nome").toString());
    }

}
