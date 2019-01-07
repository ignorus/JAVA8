package Game_Catalog;

import org.json.simple.JSONObject;

public class Main {
    public static String caminho;
    public static String resposta;
    public static JSONObject objetoCatalgo;
    public static RecebeInput inputUsuario = new RecebeInput();
    public static String Empresa;
    public  static String Plataforma;
    public  static String Jogo;


    static void  main(String[] args)
    {
        objetoCatalgo = new JSONObject();
        do {
            System.out.println("Olá, seja bem vindo!!\n Este é um catalogo de jogos, você gostaria de LER ou SALVAR jogos?");
            resposta = inputUsuario.LerOuSalvar();
        }
        while (resposta == "comando invalido");

    }
}
