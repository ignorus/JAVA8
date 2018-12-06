package organization;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class LerArquivoTxT implements LerArquivo {


        public  void lerArquivo(List times, String nomeArquivo) throws FileNotFoundException {
            File arquivo = new File(nomeArquivo + ".txt");
            System.out.println("Procurando o arquivo: " + arquivo);
            Scanner scan = new Scanner(arquivo);
            scan.useDelimiter(";");
            int i = 0;
            while (scan.hasNext()) {
                times.add(scan.next());
            }
            System.out.println("Arquivo encontrado!");
            scan.close();

        }
    }

