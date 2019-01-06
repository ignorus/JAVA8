package Game_Catalog;

import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RecebeInput {
    Scanner scanner;
    JSONObject invalido = new JSONObject();


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
        objetoParametro = (JSONObject) objetoParametro.get("Empresa");
        scanner = new Scanner(System.in);
        String input = scanner.next();
        if (objetoParametro.get(input) != null) {
            return (JSONObject) objetoParametro.get(input);
        }
        else {
            invalido.put("Invalido","invalido");
            return invalido;
        }
    }

    public JSONObject LerPlataforma(JSONObject objetoParametro)
    {
        scanner = new Scanner(System.in);
        String input = scanner.next();
        if (objetoParametro.get(input) != null) {
            return (JSONObject) objetoParametro.get(input);
        }
        else {
            invalido.put("Invalido","invalido");
            return invalido;
        }
    }

    public String LerJogo(JSONObject objetoParametro) {
        scanner = new Scanner(System.in).useDelimiter(",");
        String input = scanner.next();
        if (objetoParametro.get(input) != null) {
            return objetoParametro.get(input).toString();
        }
        else {
            return "Invalido";
        }
    }

    public String SalvarEmpresa() {
        scanner = new Scanner(System.in).useDelimiter(",");
        String input = scanner.next();
        return input;
    }

    public String SalvarPlataforma() {
        scanner = new Scanner(System.in).useDelimiter(",");
        String input = scanner.next();
        return input;
    }

    public String SalvarJogo() {
        scanner = new Scanner(System.in).useDelimiter(",");
        String input = scanner.next();
        return input;
    }

    public String[] SalvarPersonagens() {
        scanner = new Scanner(System.in).useDelimiter(",");
        List<String> inputList = new ArrayList<>();
        while (scanner.hasNext())
        {
            inputList.add(scanner.next());
        }
        String[] inputArray = new String[inputList.size()];
        for (int i = 0; i <inputList.size() ; i++) {
            inputArray[i] = inputList.get(i);
        }
        return inputArray;
    }
}
