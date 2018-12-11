package organization;

import org.junit.Rule;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
    @DisplayName("Testa arquivo passado sem extensão")
    void testaArquivoSemExtensao() throws IOException {
        File arquivoTemp = folder.newFile("ArquivoTemporario.txt");
        FileWriter escrever = new FileWriter(arquivoTemp);
        escrever.write("alo;ola;asus;samsung");
        escrever.close();
        List<String> times = new ArrayList();
        LerArquivoTxT leitorTemp = new LerArquivoTxT();
        leitorTemp.lerArquivo(times,arquivoTemp.getAbsolutePath().replaceAll(".txt",""));
        assertEquals(4,times.size());
    }

    @Test
    @DisplayName("testa Exceção de Arquivo que não existe")
    public void testaArquivoInexistente()  {
        assertThrows(FileNotFoundException.class, () ->{
            new LerArquivoTxT().lerArquivo(new ArrayList<String>(),"Ar");}
        );

    }


    @Test
    @DisplayName("Testa arquivo passado com a extensão TXT")
    void testaArquivoTXT() throws IOException {
        File arquivoTemp = folder.newFile("ArquivoTemporario.txt");
        FileWriter escrever = new FileWriter(arquivoTemp);
        escrever.write("alo;ola");
        escrever.close();
        List<String> times = new ArrayList();
        LerArquivoTxT leitorTemp = new LerArquivoTxT();
        leitorTemp.lerArquivo(times,arquivoTemp.getAbsolutePath());
        assertEquals(2,times.size());
    }

    @Test
    @DisplayName("Testa arquivo passado com a extensão JSON")
    void testaArquivoNaoTXT() throws IOException {
        File arquivoTemp = folder.newFile("ArquivoTemporario.json");
        FileWriter escrever = new FileWriter(arquivoTemp);
        escrever.write("alo;ola");
        escrever.close();
        List<String> times = new ArrayList();
        LerArquivoTxT leitorTemp = new LerArquivoTxT();
        assertThrows(FileNotFoundException.class,() ->{leitorTemp.lerArquivo(times,arquivoTemp.getAbsolutePath());});
    }


}