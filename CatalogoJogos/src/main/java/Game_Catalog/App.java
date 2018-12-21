package Game_Catalog;

import org.json.simple.JSONObject;

public class App {


    public static String caminho;
    public static JSONObject objetoCatalgo;

    static void  main(String[] args)
    {

        if (args[0].equalsIgnoreCase("ler"))
        {
             objetoCatalgo = new JSONObject();

        }

    }
}
