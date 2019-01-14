import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SelectDBTest {

    Connection con = new AcessoDB().conectar();
    SelectDB select = new SelectDB(con);
    InsertDados inserir = new InsertDados(con);
    ResultSet avaliador;
    @Test
    @DisplayName("Select empresa test")
    void selectTest() throws SQLException {
        con.setAutoCommit(false);
        inserir.empresa("Nintendo");
        avaliador = select.empresa("Nintendo");
        avaliador.next();
        assertEquals("Nintendo",avaliador.getString("nome_empresa"));
        con.rollback();
    }
}
