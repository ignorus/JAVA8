import org.hsqldb.jdbc.JDBCDriver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AcessoDBTest {

    @Test
    @DisplayName("Estabelecer conexão DB")
    void connectDB() throws ClassNotFoundException, SQLException {
        AcessoDB acessar = new AcessoDB();
        Assertions.assertNotNull(acessar.conectar());
    }
}
