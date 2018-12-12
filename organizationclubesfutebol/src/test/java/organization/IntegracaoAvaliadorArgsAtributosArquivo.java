package organization;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class IntegracaoAvaliadorArgsAtributosArquivo {

    @Test
    @DisplayName("Argumentos -f e -o passados") //separar teste de argumentos
    void ArgumentoFOInformado()
    {

        AtributosDeArquivo arquivo = new AtributosDeArquivo(new AvaliadorDeArgumentos().avaliarArgumentos(new String[]{"-f=teste","-o=crescente"}));
        assertEquals("teste",arquivo.nome);
        assertEquals("crescente",arquivo.ordenar);

    }

    @Test
    @DisplayName("Argumento -f passado")
    void ArgumentoFInformado()
    {

        AtributosDeArquivo arquivo = new AtributosDeArquivo(new AvaliadorDeArgumentos().avaliarArgumentos(new String[]{"-f=teste"}));
        assertEquals("teste",arquivo.nome);

    }

    @Test
    @DisplayName("Argumento -o passado")
    void ArgumentoOInformado()
    {

        AtributosDeArquivo arquivo = new AtributosDeArquivo(new AvaliadorDeArgumentos().avaliarArgumentos(new String[]{"-o=decrescente"}));
        assertEquals("decrescente",arquivo.ordenar);

    }

    @Test
    @DisplayName("argumento -h passado, exceção")
    void ArgumentoHInformado()
    {
        assertThrows(IndexOutOfBoundsException.class,() ->{
            new AtributosDeArquivo(new AvaliadorDeArgumentos().avaliarArgumentos(new String[]{"-h"}));
        });
    }

    @Test
    @DisplayName("Nenhum argumento passado")
    void NenhumArgumentoInformado()
    {
        assertThrows(RuntimeException.class,() ->{
            new AtributosDeArquivo(new AvaliadorDeArgumentos().avaliarArgumentos(new String[]{""}));
        });
    }

    @Test
    @DisplayName("Nenhum argumento valido passado")
    void NenhumArgumentoInvalidoInformado()
    {
        assertThrows(RuntimeException.class,() ->{
            new AtributosDeArquivo(new AvaliadorDeArgumentos().avaliarArgumentos(new String[]{"-g"}));
        });
    }

}
