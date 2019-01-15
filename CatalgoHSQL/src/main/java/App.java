import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class App {

    public static void main(String[] args) throws SQLException {
        AcessoDB entrar = new AcessoDB();
        ResultSet leitura;
        InsertDados salvar;
        SelectDB ler;
        RecebeInput usuario = new RecebeInput();
        Connection conexao = entrar.conectar();
        salvar = new InsertDados(conexao);
        ler = new SelectDB(conexao);
        int continuar = -1;
        String empresa,plataforma,jogo,resultado;
        String[] personagem;
        do {
            empresa = "";
            plataforma = "";
            jogo = "";
            resultado = "";
            resultado = usuario.LerouSalvar();
            if(resultado.equalsIgnoreCase("ler"))
            {
                System.out.println("Escolha uma das empresas abaixo para consultar");
                leitura = ler.iniciar();
                while (leitura.next())
                {
                    System.out.println(leitura.getString("nome_empresa"));
                }
                empresa = usuario.Empresa();
                leitura = ler.empresa(empresa);
                System.out.println("Escolha uma das plataformas abaixo para consultar");
                while (leitura.next())
                {
                    System.out.println(leitura.getString("nome_plataforma"));
                }
                plataforma = usuario.Plataforma();
                leitura = ler.plataforma(plataforma);
                System.out.println("Escolha um dos jogos abaixo para consultar");
                while (leitura.next())
                {
                    System.out.println(leitura.getString("nome_jogo"));
                }
                jogo = usuario.Jogo();
                leitura = ler.jogo(jogo);
                System.out.println("Esses são os personagens do jogo escolhido");
                while (leitura.next())
                {
                    System.out.println(leitura.getString("nome_personagem"));
                }
            }
            if (resultado.equalsIgnoreCase("salvar"))
            {
                System.out.println("Qual o nome da empresa você gostaria de adicionar?");
                empresa = usuario.Empresa();
                System.out.println("Qual o nome da plataforma que você gostaria de adicionar?");
                plataforma = usuario.Plataforma();
                System.out.println("Qual o nome do jogo que você gostaria de adicionar?");
                jogo = usuario.Jogo();
                System.out.println("Quais os personagens deste jogo, por favor informe-os separando por ','");
                personagem = usuario.personagens;

            }
            System.out.println("Deseja continuar a utilizar a plataforma? [Sim/Nao]");
            continuar = usuario.continuar();
        }while (continuar != 0);

    }
}
