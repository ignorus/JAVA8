package organization;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class IntegracaoOrdenarMostrarArquivoTest {

    @Test
    @DisplayName("Ordenar e Mostrar Lista em ordem crescente")
    void OrdenaMostraCrescente(){
        List<String> listaDesordenada = new ArrayList<String>();
        listaDesordenada.add("Luigi");
        listaDesordenada.add("Mario");
        listaDesordenada.add("Wario");
        listaDesordenada.add("Chainchop");
        listaDesordenada.add("Bowser");
        OrdenaArquivoAlfabetico ordenador = new OrdenaArquivoAlfabetico();
        MostrarArquivo expositor = new MostrarArquivo();
        ordenador.ordenar(listaDesordenada);
        expositor.Mostrar(listaDesordenada,"crescente");
        assertEquals("Bowser",listaDesordenada.get(0));
    }

    @Test
    @DisplayName("Ordenar e Mostrar Lista em ordem decrescente")
    void OrdenaMostraDecrescente(){
        List<String> listaDesordenada = new ArrayList<String>();
        listaDesordenada.add("Luigi");
        listaDesordenada.add("Mario");
        listaDesordenada.add("Wario");
        listaDesordenada.add("Chainchop");
        listaDesordenada.add("Bowser");
        OrdenaArquivoAlfabetico ordenador = new OrdenaArquivoAlfabetico();
        MostrarArquivo expositor = new MostrarArquivo();
        ordenador.ordenar(listaDesordenada);
        expositor.Mostrar(listaDesordenada,"decrescente");
        assertEquals("decrescente",expositor.codigoLocal);
    }

    @Test
    @DisplayName("Retorno Exceção metodo invalido")
    void RetornaExcecao()
    {
        List<String> listaDesordenada = new ArrayList<String>();
        listaDesordenada.add("Luigi");
        listaDesordenada.add("Mario");
        listaDesordenada.add("Wario");
        listaDesordenada.add("Chainchop");
        listaDesordenada.add("Bowser");
        OrdenaArquivoAlfabetico ordenador = new OrdenaArquivoAlfabetico();
        MostrarArquivo expositor = new MostrarArquivo();
        ordenador.ordenar(listaDesordenada);
        assertEquals("Bowser",listaDesordenada.get(0));
        assertThrows(NullPointerException.class,() -> {expositor.Mostrar(listaDesordenada,"ordenar");});
    }

    @Test
    @DisplayName("Lista ordenada com numeros no meio")
    void OrdenaListaComNumerosCrescente()
    {
        List<String> listaDesordenada = new ArrayList<String>();
        listaDesordenada.add("Luigi");
        listaDesordenada.add("Mario");
        listaDesordenada.add("Mar1o");
        listaDesordenada.add("Wario");
        listaDesordenada.add("Chainchop");
        listaDesordenada.add("Bowser");
        listaDesordenada.add("1Bowser");
        OrdenaArquivoAlfabetico ordenador = new OrdenaArquivoAlfabetico();
        MostrarArquivo expositor = new MostrarArquivo();
        ordenador.ordenar(listaDesordenada);
        expositor.Mostrar(listaDesordenada,"crescente");
        assertEquals("1Bowser",listaDesordenada.get(0));
    }



}
