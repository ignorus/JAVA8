package organization;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;


class OrdenaArquivoAlfabeticoTest {

    @Test
    @DisplayName("Ordena Alfabeticamente uma lista")
    void testaOrdenarAlfabetico() {
        List<String> lista = new ArrayList<String>();
        lista.add("Tiago");
        lista.add("André");
        lista.add("Rosa");
        lista.add("Ricardo");
        lista.add("Bruna");
        OrdenaArquivoAlfabetico ordenador = new OrdenaArquivoAlfabetico();
        ordenador.ordenar(lista);
        assertEquals(5,lista.size());
        assertEquals("André",lista.get(0));
        assertEquals("Bruna",lista.get(1));
        assertEquals("Ricardo",lista.get(2));
        assertEquals("Rosa",lista.get(3));
        assertEquals("Tiago",lista.get(4));
        System.out.println("Lista ordenada Alfabeticamente");

    }

    @Test
    @DisplayName("Ordena Alfanumericamente uma lista")
    void testaOrdenarAlfanumerico() {
        List<String> lista = new ArrayList<String>();
        lista.add("1Tiago");
        lista.add("2André");
        lista.add("3Rosa");
        lista.add("4Ricardo");
        lista.add("5Bruna");
        OrdenaArquivoAlfabetico ordenador = new OrdenaArquivoAlfabetico();
        ordenador.ordenar(lista);
        assertEquals(5,lista.size());
        assertEquals("1Tiago",lista.get(0));
        assertEquals("2André",lista.get(1));
        assertEquals("3Rosa",lista.get(2));
        assertEquals("4Ricardo",lista.get(3));
        assertEquals("5Bruna",lista.get(4));

        System.out.println("Lista ordenada numericamente");

    }
}