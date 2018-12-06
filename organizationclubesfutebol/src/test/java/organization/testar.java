package organization;


import org.junit.Assert;
import org.junit.Rule;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

public class testar {

    @Rule
    public TemporaryFolder folder;

    {
        folder = new TemporaryFolder();

        try {
            folder.create();
           File test = folder.newFile("ordenar");
        } catch (IOException e) {
            System.out.println("deu ruim");
        }
    }

    @Test
    @DisplayName("Deve Passar pois o teste é valido")
    public void testePassar(){
        double i =300;
        Assert.assertEquals(300,i,0.001);
    }

    @Test
    @DisplayName("Testar funcionalidade do mock")
    public void testeMock(){
        List<String> att = new ArrayList<String>();
        att.add("t");
        att.add("d");
        AtributosDeArquivo tst = mock(new AtributosDeArquivo(att).getClass());
        System.out.println("Mock nasce sem atributos");
        tst.nome = "teste1";
        assertTrue("teste1".equalsIgnoreCase(tst.nome), "errado");
        assertNull(tst.ordenar, "há algo no paramentro ordenar");

    }

    @Test
    @DisplayName("Determina se um arquivo é vazio")
    public void testeArquivoVazio(){
        List<String> iniciarMock = new ArrayList<String>();
        iniciarMock.add("arquivo");
        iniciarMock.add("ordenar");
        AtributosDeArquivo arquivoMock = mock(new AtributosDeArquivo(iniciarMock).getClass());
        Assert.assertNull(arquivoMock.lista);
        arquivoMock.lista = Arrays.asList(new String[1]);
        assertEquals(1, arquivoMock.lista.size());
        assertTrue(arquivoMock.lista.get(0) == null || arquivoMock.lista.get(0) == "");
        System.out.println("Arquivo Vazio");
    }
}
