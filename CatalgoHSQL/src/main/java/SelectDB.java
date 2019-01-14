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

    public ResultSet empresa(String Nome_empresa) {
        ResultSet resultado = null;
        try {
            Statement stmt = this.link.createStatement();
            resultado = stmt.executeQuery("SELECT * FROM  empresas WHERE NOME_EMPRESA = '" + Nome_empresa +"'");
        } catch (SQLException e) {
            System.out.println("Nenhum resultado encontrado para sua busca");
        }
        return resultado;
    }

    public ResultSet plataforma(String Nome_plataforma) {
        ResultSet resultado = null;
        try {
            Statement stmt = this.link.createStatement();
            resultado = stmt.executeQuery("SELECT * FROM  plataformas WHERE NOME_PLATAFORMA = '" + Nome_plataforma +"'");
        } catch (SQLException e) {
            System.out.println("Nenhum resultado encontrado para sua busca");
        }
        return resultado;
    }

    public ResultSet jogo(String Nome_jogo) {
        ResultSet resultado = null;
        try {
            Statement stmt = this.link.createStatement();
            resultado = stmt.executeQuery("SELECT * FROM  plataformas WHERE NOME_PLATAFORMA = '" + Nome_jogo +"'");
        } catch (SQLException e) {
            System.out.println("Nenhum resultado encontrado para sua busca");
        }
        return resultado;
    }
}
