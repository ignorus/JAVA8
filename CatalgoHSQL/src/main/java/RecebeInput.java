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
}