package Game_Catalog;

import org.json.simple.JSONObject;

import java.util.Scanner;

public class RecebeInput {
    Scanner scanner;


    String LerOuSalvar()
    {
        scanner = new Scanner(System.in);
        String input = scanner.next();
        if("ler".equalsIgnoreCase(input) || "salvar".equalsIgnoreCase(input))
        {
            return input;
        }
        else
        {
            return "Comando Invalido";
        }

    }

    public JSONObject LerEmpresa(JSONObject objetoParametro) {
        return new JSONObject();
    }
}
