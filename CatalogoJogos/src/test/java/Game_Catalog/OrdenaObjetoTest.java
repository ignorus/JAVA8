package Game_Catalog;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class OrdenaObjetoTest {

    JSONObject objetoParametro;
    FileReader reader;
    JSONParser parser;
    OrdenaObjeto ordenaObjetoMock;
    List listaMock;
    List listaVerificar;

    @BeforeEach
    void iniciar() throws IOException, ParseException {
        objetoParametro = new JSONObject();
        parser = new JSONParser();
        reader = new FileReader("src/files/multiJson.json");
        objetoParametro = (JSONObject) parser.parse(reader);
        ordenaObjetoMock = mock(new OrdenaObjeto().getClass());
        listaMock = new ArrayList();
        listaVerificar = new ArrayList();
    }

    @Test
    @DisplayName("Teste de retorno do metodo")
    void testeRetornoMetodoMock()
    {
        listaMock.add("Sony");
        listaMock.add("Microsoft");
        listaMock.add("Nintendo");
        listaMock.add("Sega");
        when(ordenaObjetoMock.ordenar(objetoParametro)).thenReturn(listaMock);
        assertEquals(4,ordenaObjetoMock.ordenar(objetoParametro).size());
    }

    @Test
    @DisplayName("Teste Ordenar Empresas")
    void testeOrdenarEmpresas()
    {
        objetoParametro = (JSONObject) objetoParametro.get("Empresa");
        when(ordenaObjetoMock.ordenar(objetoParametro)).thenCallRealMethod();
        assertEquals("Sony",ordenaObjetoMock.ordenar(objetoParametro).get(2));
    }

    @Test
    @DisplayName("Teste Ordenar Plataformas")
    void testeOrdenarPlataforma()
    {
        objetoParametro = (JSONObject)((JSONObject)objetoParametro.get("Empresa")).get("Sony");
        when(ordenaObjetoMock.ordenar(objetoParametro)).thenCallRealMethod();
        assertEquals("PS4",ordenaObjetoMock.ordenar(objetoParametro).get(3));
    }

    @Test
    @DisplayName("Teste Ordenar Jogos")
    void testeOrdenarJogos()
    {
        objetoParametro = (JSONObject)((JSONObject)((JSONObject)objetoParametro.get("Empresa")).get("Sony")).get("PS1");
        when(ordenaObjetoMock.ordenar(objetoParametro)).thenCallRealMethod();
        assertEquals("Crash Bandicoot",ordenaObjetoMock.ordenar(objetoParametro).get(0));
    }
}
