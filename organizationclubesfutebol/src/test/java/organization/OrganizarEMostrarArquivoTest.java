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
import static org.junit.Assert.assertTrue;
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
    void ordenarEMostrarArquivoCrescente() {
        List<String> iniciarMock = new ArrayList<String>();
        iniciarMock.add("ArquivoMock.txt");
        iniciarMock.add("crescente");
        AtributosDeArquivo atributosMock = mock(new AtributosDeArquivo(iniciarMock).getClass());
        try {

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
            assertTrue(arquivoTemp.exists());
            assertEquals("crescente",exibir.codigoLocal);
            assertEquals("Angelo",atributosMock.lista.get(0));
            assertEquals("Bia",atributosMock.lista.get(1));
            assertEquals("Carol",atributosMock.lista.get(2));
            assertEquals("Cesar",atributosMock.lista.get(3));
            assertEquals("Felipe",atributosMock.lista.get(4));
            assertEquals("Honda",atributosMock.lista.get(5));
            assertEquals("Matheus",atributosMock.lista.get(6));
            assertEquals("Rosa",atributosMock.lista.get(7));
            assertEquals("Tiago",atributosMock.lista.get(8));
            assertEquals("Toyota",atributosMock.lista.get(9));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    @DisplayName("Testa arquivo valido ordenado de forma decrescente")
    void ordenarEMostrarArquivoDecrescente() {
        List<String> iniciarMock = new ArrayList<String>();
        iniciarMock.add("ArquivoMock.txt");
        iniciarMock.add("decrescente");
        AtributosDeArquivo atributosMock = mock(new AtributosDeArquivo(iniciarMock).getClass());
        try {

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
            assertTrue(arquivoTemp.exists());
            assertEquals("decrescente", exibir.codigoLocal);
            assertEquals("Angelo",atributosMock.lista.get(0));
            assertEquals("Bia",atributosMock.lista.get(1));
            assertEquals("Carol",atributosMock.lista.get(2));
            assertEquals("Cesar",atributosMock.lista.get(3));
            assertEquals("Felipe",atributosMock.lista.get(4));
            assertEquals("Honda",atributosMock.lista.get(5));
            assertEquals("Matheus",atributosMock.lista.get(6));
            assertEquals("Rosa",atributosMock.lista.get(7));
            assertEquals("Tiago",atributosMock.lista.get(8));
            assertEquals("Toyota",atributosMock.lista.get(9));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}