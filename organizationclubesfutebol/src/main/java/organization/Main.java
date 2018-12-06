package organization;




public class Main {

    public static void main(@org.jetbrains.annotations.NotNull String[] args) {
        try {
            AtributosDeArquivo arquivo =new AtributosDeArquivo(new AvaliadorDeArgumentos().avaliarArgumentos(args));
            LerArquivo leitor = new LerArquivoTxT();
            OdenaArquivo ordenador = new OrdenaArquivoAlfabetico();
            MostrarArquivo expor = new MostrarArquivo();
            new OrganizarEMostrarArquivo().ordenarEMostrarArquivo(leitor,ordenador ,expor ,arquivo);

        }
        catch (Exception e){
            System.out.println(" ");
        }

    }
}