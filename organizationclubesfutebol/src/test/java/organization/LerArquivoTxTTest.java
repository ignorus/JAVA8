package organization;

import org.junit.Rule;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;

class LerArquivoTxTTest {


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
    @DisplayName("Arquivo de teste mock com 5 elementos")
    void testaArquivoMock() {

        List<String> iniciarMock = new ArrayList<String>();
        try {
            File arquivoTemp = folder.newFile("ArquivoMock.txt");
            iniciarMock.add("arquivo");
            iniciarMock.add("ordenar");
            AtributosDeArquivo arquivoMock = mock(new AtributosDeArquivo(iniciarMock).getClass());
            arquivoMock.nome = String.valueOf(arquivoTemp.getAbsolutePath().replaceAll(".txt",""));
            //arquivoMock.lista = Arrays.asList(new String[5]);
            LerArquivoTxT leitorMock = new LerArquivoTxT();
            try
            {
                leitorMock.lerArquivo(arquivoMock.lista, arquivoMock.nome);
            }
            catch (FileNotFoundException e){
                System.out.println("Arquivo não existe");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}