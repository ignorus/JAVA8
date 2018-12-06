package organization;

import java.io.FileNotFoundException;

public class OrganizarEMostrarArquivo {

    public void ordenarEMostrarArquivo(LerArquivo leitor, OdenaArquivo ordenador, MostrarArquivo expositor, AtributosDeArquivo arquivo) {
        try {
            leitor.lerArquivo(arquivo.lista,arquivo.nome);
            ordenador.ordenar(arquivo.lista);
            expositor.Mostrar(arquivo.lista,arquivo.ordenar);
        } catch (FileNotFoundException e) {
            System.out.println("O arquivo: " + arquivo.nome + " não foi encontrado!");
        } catch (NullPointerException e) {
            System.out.println("O metodo de ordenação nao é valido");
        }
    }
}
