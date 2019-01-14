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
            resultado = stmt.executeQuery("SELECT * FROM  empresas WHERE nome_empresa = " + Nome_empresa +"");
        } catch (SQLException e) {
            System.out.println("Nenhum resultado encontrado para sua busca");
        }
        return resultado;
    }
}
