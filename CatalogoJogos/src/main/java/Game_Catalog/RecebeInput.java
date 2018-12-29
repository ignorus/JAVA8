package Game_Catalog;

import org.json.simple.JSONObject;

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

    public Object LerJogo(JSONObject objetoParametro) {
        return objetoParametro;
    }
}
