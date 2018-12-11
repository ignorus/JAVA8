package organization;

import org.junit.Rule;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class IntegracaoAtributosLerArquivoTest {

    @Rule
    public TemporaryFolder folder;

    {
        folder = new TemporaryFolder();
        try {
            folder.create();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("Arquivo temporario com 5 elementos")
    void testaArquivoMock()throws IOException {

        List<String> iniciarMock = new ArrayList<String>();
        File arquivoTemp = folder.newFile("ArquivoMock.txt");
        FileWriter escrever = new FileWriter(arquivoTemp);
        escrever.write("Palmeiras;Corinthias;São Paulo;Santos;Caraguá");
        escrever.close();
        iniciarMock.add("arquivo");
        iniciarMock.add("ordenar");
        AtributosDeArquivo arquivoMock = mock(new AtributosDeArquivo(iniciarMock).getClass());
        arquivoMock.nome = String.valueOf(arquivoTemp.getAbsolutePath());
        arquivoMock.lista = new ArrayList<String>();
        LerArquivoTxT leitorMock = new LerArquivoTxT();
        leitorMock.lerArquivo(arquivoMock.lista, arquivoMock.nome);
        assertEquals(5,arquivoMock.lista.size());
    }

    @Test
    @DisplayName("Arquivo temporario com 5 elementos separados por virgula ou ponto e virgula")
    void testaArquivoSeparadoPorVirgula() throws IOException {

        List<String> iniciarMock = new ArrayList<String>();
        File arquivoTemp = folder.newFile("ArquivoMock1.txt");
        FileWriter escrever = new FileWriter(arquivoTemp);
        escrever.write("Palmeiras,Corinthias;São Paulo,Santos;Caraguá");
        escrever.close();
        iniciarMock.add("arquivo");
        iniciarMock.add("ordenar");
        AtributosDeArquivo arquivoMock = mock(new AtributosDeArquivo(iniciarMock).getClass());
        arquivoMock.nome = String.valueOf(arquivoTemp.getAbsolutePath());
        arquivoMock.lista = new ArrayList<String>();
        LerArquivoTxT leitorMock = new LerArquivoTxT();
        leitorMock.lerArquivo(arquivoMock.lista, arquivoMock.nome);
        assertEquals(5,arquivoMock.lista.size());
    }

    @Test
    @DisplayName("Arquivo temporario com 5 elementos numericos")
    void testaArquivoQueContemNumeros() throws IOException {

        List<String> iniciarMock = new ArrayList<String>();
        File arquivoTemp = folder.newFile("ArquivoMock2.txt");
        FileWriter escrever = new FileWriter(arquivoTemp);
        escrever.write("23;53;5 4;9;19");
        escrever.close();
        iniciarMock.add("arquivo");
        iniciarMock.add("ordenar");
        AtributosDeArquivo arquivoMock = mock(new AtributosDeArquivo(iniciarMock).getClass());
        arquivoMock.nome = String.valueOf(arquivoTemp.getAbsolutePath());
        arquivoMock.lista = new ArrayList<String>();
        LerArquivoTxT leitorMock = new LerArquivoTxT();
        leitorMock.lerArquivo(arquivoMock.lista, arquivoMock.nome);
        assertEquals(5,arquivoMock.lista.size());
    }
}
