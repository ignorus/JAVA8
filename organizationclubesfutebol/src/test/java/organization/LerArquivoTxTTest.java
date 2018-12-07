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

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
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
    @DisplayName("Arquivo temporario com 5 elementos")
    void testaArquivoMock() {

        List<String> iniciarMock = new ArrayList<String>();
        try {
            File arquivoTemp = folder.newFile("ArquivoMock.txt");
            FileWriter escrever = new FileWriter(arquivoTemp);
            escrever.write("Palmeiras;Corinthias;São Paulo;Santos;Caraguá");
            escrever.close();
            iniciarMock.add("arquivo");
            iniciarMock.add("ordenar");
            AtributosDeArquivo arquivoMock = mock(new AtributosDeArquivo(iniciarMock).getClass());
            arquivoMock.nome = String.valueOf(arquivoTemp.getAbsolutePath().replaceAll(".txt",""));
            arquivoMock.lista = new ArrayList<String>();
            LerArquivoTxT leitorMock = new LerArquivoTxT();
            try
            {
                leitorMock.lerArquivo(arquivoMock.lista, arquivoMock.nome);
                assertEquals(5,arquivoMock.lista.size());
                assertEquals("Palmeiras", arquivoMock.lista.get(0));
                assertEquals("Corinthias", arquivoMock.lista.get(1));
                assertEquals("São Paulo", arquivoMock.lista.get(2));
                assertEquals("Santos", arquivoMock.lista.get(3));
                assertEquals("Caraguá", arquivoMock.lista.get(4));
                assertTrue(arquivoTemp.exists());
                System.out.println("O arquivo temporario existe");
            }
            catch (FileNotFoundException e){
                System.out.println("Arquivo não existe");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @Test
    @DisplayName("Arquivo temporario com 5 elementos separados por virgula ou ponto e virgula")
    void testaArquivoSeparadoPorVirgula() {

        List<String> iniciarMock = new ArrayList<String>();
        try {
            File arquivoTemp = folder.newFile("ArquivoMock1.txt");
            FileWriter escrever = new FileWriter(arquivoTemp);
            escrever.write("Palmeiras,Corinthias;São Paulo,Santos;Caraguá");
            escrever.close();
            iniciarMock.add("arquivo");
            iniciarMock.add("ordenar");
            AtributosDeArquivo arquivoMock = mock(new AtributosDeArquivo(iniciarMock).getClass());
            arquivoMock.nome = String.valueOf(arquivoTemp.getAbsolutePath().replaceAll(".txt",""));
            arquivoMock.lista = new ArrayList<String>();
            LerArquivoTxT leitorMock = new LerArquivoTxT();
            try
            {
                leitorMock.lerArquivo(arquivoMock.lista, arquivoMock.nome);
                assertEquals(5,arquivoMock.lista.size());
                assertEquals("Palmeiras", arquivoMock.lista.get(0));
                assertEquals("Corinthias", arquivoMock.lista.get(1));
                assertEquals("São Paulo", arquivoMock.lista.get(2));
                assertEquals("Santos", arquivoMock.lista.get(3));
                assertEquals("Caraguá", arquivoMock.lista.get(4));
                assertTrue(arquivoTemp.exists());
                System.out.println("O arquivo temporario existe, e pode estar separado por ',' ou ';'");
            }
            catch (FileNotFoundException e){
                System.out.println("Arquivo não existe");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @Test
    @DisplayName("Arquivo temporario com 5 elementos numericos")
    void testaArquivoQueContemNumeros() {

        List<String> iniciarMock = new ArrayList<String>();
        try {
            File arquivoTemp = folder.newFile("ArquivoMock2.txt");
            FileWriter escrever = new FileWriter(arquivoTemp);
            escrever.write("23;53;5 4;9;19");
            escrever.close();
            iniciarMock.add("arquivo");
            iniciarMock.add("ordenar");
            AtributosDeArquivo arquivoMock = mock(new AtributosDeArquivo(iniciarMock).getClass());
            arquivoMock.nome = String.valueOf(arquivoTemp.getAbsolutePath().replaceAll(".txt",""));
            arquivoMock.lista = new ArrayList<String>();
            LerArquivoTxT leitorMock = new LerArquivoTxT();
            try
            {
                leitorMock.lerArquivo(arquivoMock.lista, arquivoMock.nome);
                assertEquals(5,arquivoMock.lista.size());
                assertEquals("23", arquivoMock.lista.get(0));
                assertEquals("53", arquivoMock.lista.get(1));
                assertEquals("5 4", arquivoMock.lista.get(2));
                assertEquals("9", arquivoMock.lista.get(3));
                assertEquals("19", arquivoMock.lista.get(4));
                assertTrue(arquivoTemp.exists());
                System.out.println("O arquivo temporario existe, e contem elementos numericos");
            }
            catch (FileNotFoundException e){
                System.out.println("Arquivo não existe");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @Test
    @DisplayName("Arquivo que não é TXT")
    public void testaArquivoQueNaoEtxt(){
        List arquivoMock = new ArrayList<String>();

        try {
            File arquivoTemp = folder.newFile("test.json");
            FileWriter escritor = new FileWriter(arquivoTemp);
            escritor.write("{time1:Palmeiras;time2:Corinthias;time3:São Paulo;time4:Santos;time5:Caraguá}");
            escritor.close();
            arquivoMock.add("arquivo");
            arquivoMock.add("ordenar");
            AtributosDeArquivo arquivoMockado = mock(new AtributosDeArquivo(arquivoMock).getClass());
            arquivoMockado.nome = String.valueOf(arquivoTemp.getAbsolutePath().replaceAll(".txt",""));
            arquivoMockado.lista = new ArrayList<String>();
            LerArquivoTxT leitor = new LerArquivoTxT();
            try {
                leitor.lerArquivo(arquivoMockado.lista,arquivoMockado.nome);
            }
            catch (FileNotFoundException e){
                System.out.println("Arquivo de não existe, ou contém outra extensão");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}