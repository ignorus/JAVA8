package Game_Catalog;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class Main {
    public static String caminho = "src/files/CatalogoJogos.Json";
    public static String resposta;
    public static JSONObject objetoCatalgo;
    public static JSONObject objetoNavegacion = new JSONObject();
    public static RecebeInput inputUsuario = new RecebeInput();
    public static String Empresa;
    public  static String Plataforma;
    public  static String Jogo;
    public static String Personagem;
    public static String[] Personagens = new String[]{};


    public static void  main(String[] args) throws IOException, ParseException {
        objetoCatalgo = new JSONObject();
        do {
            System.out.println("Olá, seja bem vindo!!\nEste é um catalogo de jogos, você gostaria de LER ou SALVAR jogos?");
            resposta = inputUsuario.LerOuSalvar();
        }while (resposta.equals("Comando Invalido"));
        LerArquivoJSON arquivoJSON = new LerArquivoJSON();
        arquivoJSON.AbrirArquivoJSON(caminho);
        objetoCatalgo = arquivoJSON.SepararDadosDoArquivo(arquivoJSON.getArquivo());
        if(resposta.equals("ler"))
        {
            do {
                System.out.println("Por favor selecione uma das empresas listadas a seguir:");
                objetoNavegacion = inputUsuario.LerEmpresa(objetoCatalgo);
            }while (objetoNavegacion.containsKey("Invalido"));
            objetoCatalgo = objetoNavegacion;
            do {
                System.out.println("Por favor selecione uma das plataformas a seguir");
                objetoNavegacion = inputUsuario.LerPlataforma(objetoCatalgo);
            }while (objetoNavegacion.containsKey("Invalido"));
            objetoCatalgo = objetoNavegacion;
            do {
                System.out.println("Qual destes jogos você gostaria de consultar?");
                Personagem = inputUsuario.LerJogo(objetoCatalgo);
            }while (Personagem.equals("Invalido"));
            System.out.println(Personagem);
        }
        if (resposta.equals("salvar"))
        {
            Empresa = inputUsuario.SalvarEmpresa();
            Plataforma = inputUsuario.SalvarPlataforma();
            Jogo = inputUsuario.SalvarJogo();
            Personagens = inputUsuario.SalvarPersonagens();
            SalvarArquivoJSON sobreEscrever = new SalvarArquivoJSON(caminho);
            sobreEscrever.salvarJogoePersonagemJSON(objetoCatalgo,Empresa,Plataforma,Jogo,Personagens);
        }
    }
}
