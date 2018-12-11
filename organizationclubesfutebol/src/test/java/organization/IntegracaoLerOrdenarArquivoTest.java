package organization;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class IntegracaoLerOrdenarArquivoTest {

    @Rule TemporaryFolder folder;
    {
        folder = new TemporaryFolder();
        try {
            folder.create();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("Ler arquivo existente e ordenar de forma crescente")
    void LerArquivoeOrdenarCrescente() throws IOException {

        List<String> listaParaOrdenar = new ArrayList<>();
        File arquivo = folder.newFile("ArquivoTemp.txt");
        FileWriter escrever = new FileWriter(arquivo);
        escrever.write("Fm;BT;Wi-Fi;Am;Som");
        escrever.close();
        LerArquivoTxT leitor = new LerArquivoTxT();
        OrdenaArquivoAlfabetico ordenador = new OrdenaArquivoAlfabetico();
        leitor.lerArquivo(listaParaOrdenar,arquivo.getAbsolutePath());
        ordenador.ordenar(listaParaOrdenar);
        Assert.assertEquals("Am",listaParaOrdenar.get(0));
    }

    @Test
    @DisplayName("Ler arquivo separado somente por ',' e ordenar")
    void LerArquivoSeaparadoVirgula() throws IOException {
        List<String> listaParaOrdenar = new ArrayList<>();
        File arquivo = folder.newFile("ArquivoTemp.txt");
        FileWriter escrever = new FileWriter(arquivo);
        escrever.write("Fm,BT,Wi-Fi,Am,Som");
        escrever.close();
        LerArquivoTxT leitor = new LerArquivoTxT();
        OrdenaArquivoAlfabetico ordenador = new OrdenaArquivoAlfabetico();
        leitor.lerArquivo(listaParaOrdenar,arquivo.getAbsolutePath());
        ordenador.ordenar(listaParaOrdenar);
        Assert.assertEquals("Am",listaParaOrdenar.get(0));
    }
}
