package Game_Catalog;

import java.nio.Buffer;
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
}
