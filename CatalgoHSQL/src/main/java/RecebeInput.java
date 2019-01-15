import java.util.Scanner;

public class RecebeInput {

    String resultado;

    public String LerouSalvar()
    {
        Scanner input = new Scanner(System.in).useDelimiter("\n");
        resultado = input.next();
        if (resultado.equalsIgnoreCase("ler") || resultado.equalsIgnoreCase("salvar"))
        {
            return resultado;
        }
        return "Invalido";
    }

    public String  Empresa() {
        Scanner input = new Scanner(System.in).useDelimiter("\n");
        resultado = input.next();
        if (!resultado.equals(null) && !resultado.equals(" "))
        {
            return resultado;
        }
        return "Invalido";
    }

    public String Plataforma() {
        Scanner input = new Scanner(System.in).useDelimiter("\n");
        resultado = input.next();
        if (!resultado.equals(null) && !resultado.equals(" "))
        {
            return resultado;
        }
        return "Invalido";
    }
}
