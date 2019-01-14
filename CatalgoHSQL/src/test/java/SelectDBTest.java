import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class SelectDBTest {

    Connection con = new AcessoDB().conectar();
    SelectDB select = new SelectDB(con);
    InsertDados inserir = new InsertDados(con);
    @Test
    @DisplayName("Select empresa test")
    void selectTest() throws SQLException {
        con.setAutoCommit(false);
        inserir.empresa("Nintendo");
        Assertions.assertEquals(1,select.empresa("Nintendo"));
    }
}
