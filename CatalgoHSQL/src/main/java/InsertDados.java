import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertDados {
    private Connection DB;
    InsertDados(Connection connect)
    {
        this.DB = connect;
    }

    public int empresa(String nomeEmpresa)
    {
        int resultado = 0;
        try {
            Statement stm =  this.DB.createStatement();
            resultado = stm.executeUpdate("INSERT INTO empresas (NOME_EMPRESA) VALUES('"+ nomeEmpresa +"')");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultado;
    }
}
