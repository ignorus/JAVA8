package Game_Catalog;

import java.nio.Buffer;
import java.util.Scanner;

public class RecebeInput {
    Scanner scanner;


    String LerOuSalvar()
    {
        scanner = new Scanner(System.in);
        return scanner.next();

    }
}
