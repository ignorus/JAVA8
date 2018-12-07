package organization;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

class AvaliadorDeArgumentosTest {

    @Test
    @DisplayName("Deve Retornar Excessão caso o argumento seja invalido")
    void avaliarArgumentosInvalidos()
    {
        AvaliadorDeArgumentos avaliar = new AvaliadorDeArgumentos();
        try {
            avaliar.avaliarArgumentos(new String[]{"-d"});
        }
        catch (RuntimeException e){
            System.out.println(e.getMessage());
        }

    }

    @Test
    @DisplayName("Deve verificar se 2 argumentos foram passados")
    void avaliarDoisArgumentos()
    {
        AvaliadorDeArgumentos avaliar = new AvaliadorDeArgumentos();
        List<String> lista;
        try {
            lista = avaliar.avaliarArgumentos(new String[]{"-f=alo", "-o=crescente"});
            assertEquals(2,lista.size());
            assertEquals("alo",lista.get(0));
            assertEquals("crescente",lista.get(1));
            System.out.println("2 argumentos foram passados");


        }
        catch (RuntimeException e)
        {
            System.out.println(e.getMessage());
        }
    }

    @Test
    @DisplayName("Deve verificar se nenhum argumento foi passado")
    void avaliarSemArgumentos()
    {
        AvaliadorDeArgumentos avaliar = new AvaliadorDeArgumentos();
        List<String> lista;
        try {
            lista = avaliar.avaliarArgumentos(new String[]{});
            assertEquals(0,lista.size());
            System.out.println("nenhum argumento foi passados");

        }
        catch (RuntimeException e)
        {
            System.out.println(e.getMessage());
        }
    }

    @Test
    @DisplayName("Deve verificar que o argumento -h foi passado")
    void avaliarArgumentoH()
    {
        AvaliadorDeArgumentos avaliar = new AvaliadorDeArgumentos();
        List<String> lista;
        try {
            lista = avaliar.avaliarArgumentos(new String[]{"-h"});
            assertEquals(1,lista.size());
            assertEquals("help",lista.get(0));
            System.out.println("o argumento -h foi passado");

        }
        catch (RuntimeException e)
        {
            System.out.println(e.getMessage());
        }
    }

    @Test
    @DisplayName("Deve verificar se o argumento -o foi passado")
    void avaliarArgumentoO()
    {
        AvaliadorDeArgumentos avaliar = new AvaliadorDeArgumentos();
        List<String> lista;
        try {
            lista = avaliar.avaliarArgumentos(new String[]{"-o=dec"});
            assertEquals(2,lista.size());
            assertEquals("dec",lista.get(1));
            assertEquals("teste1",lista.get(0));
            System.out.println("o argumento -o foi passado");

        }
        catch (RuntimeException e)
        {
            System.out.println(e.getMessage());
        }
    }

    @Test
    @DisplayName("Deve verificar se o argumento -f foi passado")
    void avaliarArgumentoF()
    {
        AvaliadorDeArgumentos avaliar = new AvaliadorDeArgumentos();
        List<String> lista;
        try {
            lista = avaliar.avaliarArgumentos(new String[]{"-f=file"});
            assertEquals(2,lista.size());
            assertEquals("file",lista.get(0));
            assertEquals("crescente",lista.get(1));
            System.out.println("o argumento -f foi passado");

        }
        catch (RuntimeException e)
        {
            System.out.println(e.getMessage());
        }
    }

}