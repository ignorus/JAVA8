import java.util.Scanner;

public class RecebeInput {

    String resultado;
    String[] personagens;

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

    public String Jogo() {
        Scanner input = new Scanner(System.in).useDelimiter("\n");
        resultado = input.next();
        if (!resultado.equals(null) && !resultado.equals(" "))
        {
            return resultado;
        }
        return "Invalido";
    }

    public String[] Personagens() {
        Scanner input = new Scanner(System.in).useDelimiter("\n");
        resultado = input.next();
        personagens = resultado.split(",");
        if(personagens.length > 0)
        {
            return personagens;
        }
        personagens = new String[]{"Invalido"};
        return personagens;
    }
}
