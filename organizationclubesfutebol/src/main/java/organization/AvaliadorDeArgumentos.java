package organization;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class AvaliadorDeArgumentos {
    List <String> instrucion = new ArrayList<String>();

    public List<String> avaliarArgumentos(@NotNull String[] argumentos){
        String file = null;
        String order = null;
        if(argumentos.length >= 1)
            file = argumentos[0];
        if(argumentos.length >= 2)
            order = argumentos[1];

        if(file != null && order != null) {
            //meuprograma -f=text.txt -o=crescente
            String[] splitFile = file.split("=");
            String[] splitOrder = order.split("=");
            String fileFlag = splitFile[0];
            String orderFlag = splitOrder[0];
            String orderValue = "";

            if(!"".equals(fileFlag) && fileFlag.equalsIgnoreCase("-f")) {
                // BUSCAR ARQUIVO E LER
                String fileName = splitFile[1];
                if(!"".equals(orderFlag) && orderFlag.equalsIgnoreCase("-o")) {
                    // ORDENAR
                    orderValue = splitOrder[1];
                }
                instrucion.add(fileName);
                instrucion.add(orderValue);
                return instrucion;
            }
        }

        if(file != null && order == null) {
            //meuprograma -f=text.txt -o=crescente
            String[] splitFile = file.split("=");
            String fileFlag = splitFile[0];


            if(!"".equals(fileFlag) && fileFlag.equalsIgnoreCase("-f")) {
                // BUSCAR ARQUIVO E LER
                String fileName = splitFile[1];
                instrucion.add(fileName);
                instrucion.add("crescente");
                return instrucion;
            }
            if(!"".equals(fileFlag) && fileFlag.equalsIgnoreCase("-o")) {
                // ORDENAR
                String orderValue = splitFile[1];
                instrucion.add("teste1");
                instrucion.add(orderValue);
                return instrucion;
            }
            if (!"".equals(fileFlag) && file.equalsIgnoreCase("-h")){
                System.out.println("[-f=Nome do Arquivo]");
                System.out.println("Utilizando este parametro é possivel passar o nome do arquivo" +
                        "à ser ordenado");
                System.out.println("[-o=Metodo de ordenação]");
                System.out.println("Com este parametro é possivel determinar se o arquivo será ordenado de forma " +
                        "Crescente ou Decrescente Por padrão o arquivo é ordenado de forma Crescente");

            }

        }

        if(file == null)
        {

            instrucion.add("teste1");
            instrucion.add("crescente");
            return instrucion;

        }

        return instrucion;

    }

}
