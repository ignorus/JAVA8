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
        inserir.plataforma("Nintendo","GC");
        avaliador = select.empresa("Nintendo");
        avaliador.next();
        assertEquals("GC",avaliador.getString("nome_plataforma"));
        con.rollback();
    }

    @Test
    @DisplayName("Select plataforma test")
    void selectplataformaTest() throws SQLException {
        con.setAutoCommit(false);
        inserir.jogo("wii","MARIO PARTY 8");
        inserir.jogo("wii","zz");
        avaliador = select.plataforma("wii");
        avaliador.next();
        assertEquals("MARIO PARTY 8",avaliador.getString("nome_jogo"));
        con.rollback();
    }

    @Test
    @DisplayName("Select jogo test")
    void selectJogoTest() throws SQLException {
        int personagens = 0;
        con.setAutoCommit(false);
        inserir.personagem("Mario Party 8","MARIO");
        inserir.personagem("Mario Party 8","LUIGI");
        inserir.personagem("Mario Party 9","BOO");
        avaliador = select.jogo("Mario Party 8");
        while (avaliador.next())
        {
            personagens++;
        }
        assertEquals(2, personagens);
        con.rollback();
    }
}
