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

    @Test
    @DisplayName("Select plataforma test")
    void selectplataformaTest() throws SQLException {
        con.setAutoCommit(false);
        inserir.plataforma("Nintendo","switch");
        inserir.plataforma("Nintendo","wii");
        avaliador = select.plataforma("wii");
        avaliador.next();
        assertEquals("wii",avaliador.getString("nome_plataforma"));
        con.rollback();
    }

    @Test
    @DisplayName("Select jogo test")
    void selectJogoTest() throws SQLException {
        con.setAutoCommit(false);
        inserir.jogo("wii","Mario Party 8");
        inserir.jogo("wii","Rayman");
        avaliador = select.jogo("Mario Party 8");
        avaliador.next();
        assertEquals("Mario Party 8",avaliador.getString("nome_plataforma"));
        con.rollback();
    }
}
