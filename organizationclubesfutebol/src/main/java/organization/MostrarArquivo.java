package organization;

import java.util.List;


public  class MostrarArquivo {

        String codigoLocal = "";

    public void Mostrar(List<String> times, String codigo) throws NullPointerException
    {
        System.out.println(" ");
        if(codigo.equalsIgnoreCase("crescente"))
        {
            for (int i = 0; i<times.size();i++)
            {
                System.out.println(times.get(i));
            }
            System.out.println();
            System.out.println("Arquivo ordenado de forma " + codigo.toLowerCase() +"!");
            codigoLocal = codigo.toLowerCase();
        }
        if (codigo.equalsIgnoreCase("decrescente"))
        {
            for (int i = (times.size() -1); i >= 0; i--)
            {
                System.out.println(times.get(i));
            }
            System.out.println();
            System.out.println("Arquivo ordenado de forma " + codigo.toLowerCase() +"!");
            codigoLocal = codigo.toLowerCase();
        }

        if (!"crescente".equalsIgnoreCase(codigo) && !"decrescente".equalsIgnoreCase(codigo))
        {
            throw new NullPointerException("Metodo Invalido");
        }
    }
}
