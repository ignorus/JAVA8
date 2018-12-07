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
            String verificarVirgula = "";
            while (scan.hasNext()) {

                times.add(scan.next());
                verificarVirgula = (String) times.get(times.size()-1);
                String[] reorganizarLista = verificarVirgula.split(",");
                times.set((times.size()-1),reorganizarLista[0]);
                for (int z = 1; z<reorganizarLista.length;z++)
                {
                        times.add(reorganizarLista[z]);

                }
                i++;
            }

            System.out.println("Arquivo encontrado!");
            scan.close();

        }
    }

