import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectDB {

    private Connection link;
    SelectDB(Connection DB)
    {
        this.link = DB;

    }
    public ResultSet iniciar() {
        ResultSet resultado = null;
        try {
            Statement stmt = this.link.createStatement();
            resultado = stmt.executeQuery("SELECT * FROM empresas ORDER BY nome_empresa");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultado;
    }

    public ResultSet empresa(String Nome_empresa) {
        ResultSet resultado = null;
        try {
            Statement stmt = this.link.createStatement();
            resultado = stmt.executeQuery("SELECT * FROM  plataformas WHERE EMPRESA = '" + Nome_empresa +"' ORDER BY nome_plataforma");
        } catch (SQLException e) {
            System.out.println("Nenhum resultado encontrado para sua busca");
        }
        return resultado;
    }

    public ResultSet plataforma(String Nome_plataforma) {
        ResultSet resultado = null;
        try {
            Statement stmt = this.link.createStatement();
            resultado = stmt.executeQuery("SELECT * FROM  jogos WHERE PLATAFORMA = '" + Nome_plataforma +"' ORDER BY nome_jogo");
        } catch (SQLException e) {
            System.out.println("Nenhum resultado encontrado para sua busca");
        }
        return resultado;
    }

    public ResultSet jogo(String Nome_jogo) {
        ResultSet resultado = null;
        try {
            Statement stmt = this.link.createStatement();
            resultado = stmt.executeQuery("SELECT * FROM  personagens  WHERE Jogo = '" + Nome_jogo +"' ORDER BY nome_personagem");
        } catch (SQLException e) {
            System.out.println("Nenhum resultado encontrado para sua busca");
        }
        return resultado;
    }
}
