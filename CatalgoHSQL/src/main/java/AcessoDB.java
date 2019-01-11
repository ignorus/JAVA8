import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AcessoDB {

    public Connection conectar(){
        Connection con = null;
        try {
            Class.forName("org.hsqldb.jdbc.JDBCDriver");
        } catch (ClassNotFoundException e) {
            System.out.println("Classe não existe");
        }
        try {
            con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/catalogojogos;ifexists = true", "ignorus", "maketime");
        } catch (SQLException e) {
            System.out.println("Falha na conexão");
        }
        return con;
    }
}
