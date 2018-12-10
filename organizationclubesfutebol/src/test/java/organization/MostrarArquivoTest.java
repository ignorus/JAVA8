package organization;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MostrarArquivoTest {

    @Test
    @DisplayName("Testa Exceção NullPointer")
    void NPEteste(){
        assertThrows(NullPointerException.class, () -> {new MostrarArquivo().Mostrar(new ArrayList<>(),"Dec");});
    }

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
        exibir.Mostrar(listaOrdenada, metodoOrdenar);
        assertEquals("crescente",exibir.codigoLocal);
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
        exibir.Mostrar(listaOrdenada, metodoOrdenar);
        assertEquals("decrescente",exibir.codigoLocal);
    }



}


