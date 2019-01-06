package Game_Catalog;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
        reader = new FileReader("src/files/multiJson.json");
        objetoParametro = (JSONObject) parser.parse(reader);
        ordenaObjetoMock = mock(new OrdenaObjeto().getClass());
        listaMock = new ArrayList();
        listaVerificar = new ArrayList();
    }

    @Test
    @DisplayName("Ordena Empresas")
    void testeOrdenarEmpresaMock()
    {
        objetoParametro = (JSONObject) objetoParametro.get("Empresa");
        listaMock.add("Sony");
        listaMock.add("Microsoft");
        listaMock.add("Nintendo");
        listaMock.add("Sega");
        when(ordenaObjetoMock.ordenar(objetoParametro)).thenReturn(listaMock);

    }
}
