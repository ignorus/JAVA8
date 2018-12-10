package organization;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AvaliadorDeArgumentosTest {


    @Test
    @DisplayName("Deve Retornar Exceção caso o argumento seja invalido")
    void avaliarArgumentosInvalidos(){

        assertThrows(RuntimeException.class, () -> {
            new AvaliadorDeArgumentos().avaliarArgumentos(new String[]{"-d"});
        });

    }

    @Test
    @DisplayName("Deve verificar se 2 argumentos foram passados")
    void avaliarDoisArgumentos()
    {
        AvaliadorDeArgumentos avaliar = new AvaliadorDeArgumentos();
        List<String> lista;
        lista = avaliar.avaliarArgumentos(new String[]{"-f=alo", "-o=crescente"});
        assertEquals(2,lista.size());
    }

    @Test
    @DisplayName("Deve verificar se nenhum argumento foi passado")
    void avaliarSemArgumentos()
    {
        AvaliadorDeArgumentos avaliar = new AvaliadorDeArgumentos();
        List<String> lista;
        lista = avaliar.avaliarArgumentos(new String[]{});
        assertEquals(0,lista.size());
    }

    @Test
    @DisplayName("Deve verificar que o argumento -h foi passado")
    void avaliarArgumentoH()
    {
        AvaliadorDeArgumentos avaliar = new AvaliadorDeArgumentos();
        List<String> lista;
        lista = avaliar.avaliarArgumentos(new String[]{"-h"});
        assertEquals(1,lista.size());
        assertEquals("help",lista.get(0));
    }

    @Test
    @DisplayName("Deve verificar se o argumento -o foi passado")
    void avaliarArgumentoO()
    {
        AvaliadorDeArgumentos avaliar = new AvaliadorDeArgumentos();
        List<String> lista;
        lista = avaliar.avaliarArgumentos(new String[]{"-o=dec"});
        assertEquals("dec",lista.get(1));
    }

    @Test
    @DisplayName("Deve verificar se o argumento -f foi passado")
    void avaliarArgumentoF()
    {
        AvaliadorDeArgumentos avaliar = new AvaliadorDeArgumentos();
        List<String> lista;
        lista = avaliar.avaliarArgumentos(new String[]{"-f=file"});
        assertEquals("file",lista.get(0));
    }
}