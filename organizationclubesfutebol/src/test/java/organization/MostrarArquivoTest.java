package organization;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

class MostrarArquivoTest {

    @Test
    @DisplayName("Testa mostrar arquivo em ordem crescente")
    void mostrarCrescente() {
        List<String> listaOrdenada = new ArrayList<String>();
        listaOrdenada.add("Ana");
        listaOrdenada.add("Bruno");
        listaOrdenada.add("Deise");
        listaOrdenada.add("Eduardo");
        listaOrdenada.add("Tiago");
        String metodoOrdenar = "CRESCENTE";
        MostrarArquivo exibir = new MostrarArquivo();
        try {
            exibir.Mostrar(listaOrdenada, metodoOrdenar);
            assertEquals("crescente",exibir.codigoLocal);
            System.out.println("Teste crescente");

        }
        catch (NullPointerException e)
        {
            System.out.println("Metodo de ordenação invalido");
        }
    }

    @Test
    @DisplayName("Testa mostrar arquivo em ordem decrescente")
    void mostrarDecrescente() {
        List<String> listaOrdenada = new ArrayList<String>();
        listaOrdenada.add("Ana");
        listaOrdenada.add("Bruno");
        listaOrdenada.add("Deise");
        listaOrdenada.add("Eduardo");
        listaOrdenada.add("Tiago");
        String metodoOrdenar = "deCRESCENTE";
        MostrarArquivo exibir = new MostrarArquivo();
        try {
            exibir.Mostrar(listaOrdenada, metodoOrdenar);
            assertEquals("decrescente",exibir.codigoLocal);
            System.out.println("Teste decrescente");
        }
        catch (NullPointerException e)
        {
            System.out.println("Metodo de ordenação invalido");
        }
    }

    @Test
    @DisplayName("Testa não mostrar arquivo em ordem crescente")
    void mostrarInvalido() {
        List<String> listaOrdenada = new ArrayList<String>();
        listaOrdenada.add("Ana");
        listaOrdenada.add("Bruno");
        listaOrdenada.add("Deise");
        listaOrdenada.add("Eduardo");
        listaOrdenada.add("Tiago");
        String metodoOrdenar = "deCRESCE";
        MostrarArquivo exibir = new MostrarArquivo();
        try {
            exibir.Mostrar(listaOrdenada, metodoOrdenar);
        }
        catch (NullPointerException e)
        {
            System.out.println("Metodo de ordenação invalido");
        }
    }

}


