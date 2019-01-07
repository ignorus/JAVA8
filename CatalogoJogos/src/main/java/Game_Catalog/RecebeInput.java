package Game_Catalog;

import org.json.simple.JSONObject;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class RecebeInput {
    Scanner scanner;
    JSONObject invalido = new JSONObject();
    OrdenaObjeto ordenador = new OrdenaObjeto();
    List mostrar = new ArrayList();
    List<String> inputList;



    String LerOuSalvar()
    {
        scanner = new Scanner(System.in);
        String input = scanner.next();
        if("ler".equalsIgnoreCase(input) || "salvar".equalsIgnoreCase(input))
        {
            return input.toLowerCase();
        }
        else
        {
            return "Comando Invalido";
        }

    }

    public JSONObject LerEmpresa(JSONObject objetoParametro) {
        objetoParametro = (JSONObject) objetoParametro.get("Empresa");
        mostrar = ordenador.ordenar(objetoParametro);
        for (int i = 0; i <mostrar.size() ; i++) {
            System.out.println(mostrar.get(i));
        }
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
        mostrar = ordenador.ordenar(objetoParametro);
        for (int i = 0; i <mostrar.size() ; i++) {
            System.out.println(mostrar.get(i));
        }
        scanner = new Scanner(System.in).useDelimiter("\n");
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
        mostrar = ordenador.ordenar(objetoParametro);
        for (int i = 0; i <mostrar.size() ; i++) {
            System.out.println(mostrar.get(i));
        }
        scanner = new Scanner(System.in).useDelimiter("\n");
        String input = scanner.next();
        if (objetoParametro.get(input) != null) {
            return objetoParametro.get(input).toString();
        }
        else {
            return "Invalido";
        }
    }

    public String SalvarEmpresa() {
        scanner = new Scanner(System.in).useDelimiter("\n");
        String input = scanner.next();
        return input;
    }

    public String SalvarPlataforma() {
        scanner = new Scanner(System.in).useDelimiter("\n");
        String input = scanner.next();
        return input;
    }

    public String SalvarJogo() {
        scanner = new Scanner(System.in).useDelimiter("\n");
        String input = scanner.next();
        return input;
    }

    public String[] SalvarPersonagens() {
        scanner = new Scanner(System.in).useDelimiter("\n");
        String[] inputArray;
        inputList = new ArrayList<>();
        inputArray=(scanner.next().split(","));
        inputList.addAll(Arrays.asList(inputArray));
        Collections.sort(inputList);
        inputList.toArray(inputArray);
        return inputArray;
    }
}
