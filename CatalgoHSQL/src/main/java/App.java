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
                leitura = ler.iniciar();
                while (leitura.next())
                {
                    System.out.println(leitura.getString("nome_empresa"));
                }
                empresa = usuario.Empresa();
                leitura = ler.empresa(empresa);
                while (leitura.next())
                {
                    System.out.println(leitura.getString("nome_plataforma"));
                }
                plataforma = usuario.Plataforma();
                leitura = ler.plataforma(plataforma);
                while (leitura.next())
                {
                    System.out.println(leitura.getString("nome_jogo"));
                }
                jogo = usuario.Jogo();
                leitura = ler.jogo(jogo);
                while (leitura.next())
                {
                    System.out.println(leitura.getString("nome_personagem"));
                }
            }
            if (resultado.equalsIgnoreCase("salvar"))
            {

            }
            continuar = usuario.continuar();
        }while (continuar != 0);


    }
}
