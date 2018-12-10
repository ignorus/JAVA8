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

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

class OrganizarEMostrarArquivoTest {

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
    @DisplayName("Testa arquivo valido ordenado de forma crescente")
    void ordenarEMostrarArquivoCrescente() throws IOException {
        List<String> iniciarMock = new ArrayList<String>();
        iniciarMock.add("ArquivoMock.txt");
        iniciarMock.add("crescente");
        AtributosDeArquivo atributosMock = mock(new AtributosDeArquivo(iniciarMock).getClass());
        File arquivoTemp = folder.newFile("ArquivoMock.txt");
        FileWriter escritor = new FileWriter(arquivoTemp);
        escritor.write("Matheus,Carol;Tiago,Rosa;Toyota;Angelo;Bia,Cesar,Honda,Felipe");
        escritor.close();
        atributosMock.nome = arquivoTemp.getAbsolutePath().replaceAll(".txt","");
        atributosMock.ordenar = "crescente";
        atributosMock.lista = new ArrayList<String>();
        OrganizarEMostrarArquivo testeE2E = new OrganizarEMostrarArquivo();
        MostrarArquivo exibir = new MostrarArquivo();
        testeE2E.ordenarEMostrarArquivo(new LerArquivoTxT(),new OrdenaArquivoAlfabetico(),exibir,atributosMock);
        assertEquals("crescente",exibir.codigoLocal);
    }

    @Test
    @DisplayName("Testa arquivo valido ordenado de forma decrescente")
    void ordenarEMostrarArquivoDecrescente() throws IOException {
        List<String> iniciarMock = new ArrayList<String>();
        iniciarMock.add("ArquivoMock.txt");
        iniciarMock.add("decrescente");
        AtributosDeArquivo atributosMock = mock(new AtributosDeArquivo(iniciarMock).getClass());
        File arquivoTemp = folder.newFile("ArquivoMock.txt");
        FileWriter escritor = new FileWriter(arquivoTemp);
        escritor.write("Matheus,Carol;Tiago,Rosa;Toyota;Angelo;Bia,Cesar,Honda,Felipe");
        escritor.close();
        atributosMock.nome = arquivoTemp.getAbsolutePath().replaceAll(".txt","");
        atributosMock.ordenar = "decrescente";
        atributosMock.lista = new ArrayList<String>();
        OrganizarEMostrarArquivo testeE2E = new OrganizarEMostrarArquivo();
        MostrarArquivo exibir = new MostrarArquivo();
        testeE2E.ordenarEMostrarArquivo(new LerArquivoTxT(),new OrdenaArquivoAlfabetico(),exibir,atributosMock);
        assertEquals("decrescente", exibir.codigoLocal);
    }


}