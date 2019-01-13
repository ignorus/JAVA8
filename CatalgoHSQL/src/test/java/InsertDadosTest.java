import org.hsqldb.lib.Collection;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InsertDadosTest {

    Connection con = new AcessoDB().conectar();
    InsertDados adicionar = new InsertDados(con);
    @Test
    @DisplayName("Adicionar empresa ao DB")
    void addEmpresaTest() throws SQLException {
        con.setAutoCommit(false);
        assertEquals(1,adicionar.empresa("Nintendo"));
        con.rollback();
    }
}
