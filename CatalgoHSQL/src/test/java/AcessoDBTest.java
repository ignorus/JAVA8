import org.hsqldb.jdbc.JDBCDriver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AcessoDBTest {

    @Test
    @DisplayName(" estabelecer conexão DB")
    void connectDB() throws ClassNotFoundException, SQLException {
        Connection con = null;
        Class.forName("org.hsqldb.jdbc.JDBCDriver");
        con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/catalogojogos;ifexists = true", "ignorus", "maketime");
        Assertions.assertNotNull(con);
    }
}
