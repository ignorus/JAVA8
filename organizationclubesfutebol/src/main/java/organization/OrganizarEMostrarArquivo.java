package organization;

import java.io.FileNotFoundException;

public class OrganizarEMostrarArquivo {

    public void ordenarEMostrarArquivo(LerArquivo leitor, OdenaArquivo ordenador, MostrarArquivo expositor, AtributosDeArquivo arquivo) {
        try
        {
            leitor.lerArquivo(arquivo.lista, arquivo.nome);
        }
        catch (FileNotFoundException e) {
            System.out.println("O arquivo: " + arquivo.nome + " não foi encontrado!");
        }
        ordenador.ordenar(arquivo.lista);
        try
        {
            expositor.Mostrar(arquivo.lista,arquivo.ordenar);

        } catch (NullPointerException e) {
            System.out.println("O metodo de ordenação nao é valido");
        }
    }
}
