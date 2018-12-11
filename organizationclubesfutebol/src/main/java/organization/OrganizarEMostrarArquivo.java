package organization;

import java.io.FileNotFoundException;

public class OrganizarEMostrarArquivo {

    public void ordenarEMostrarArquivo(LerArquivo leitor, OdenaArquivo ordenador, MostrarArquivo expositor, AtributosDeArquivo arquivo) throws FileNotFoundException {

        leitor.lerArquivo(arquivo.lista, arquivo.nome);
        ordenador.ordenar(arquivo.lista);
        expositor.Mostrar(arquivo.lista,arquivo.ordenar);
        System.out.println("O metodo de ordenação nao é valido");
    }
}
