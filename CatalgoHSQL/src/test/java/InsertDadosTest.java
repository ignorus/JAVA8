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
        assertEquals(1,adicionar.empresa("Inexistente"));
        con.rollback();
    }

    @Test
    @DisplayName("Adicionar plataforma ao DB")
    void addPlataformaTest() throws SQLException {
        con.setAutoCommit(false);
        assertEquals(1,adicionar.plataforma("Nintendo","wii"));
        con.rollback();
    }

    @Test
    @DisplayName("Adicionar jogo ao DB")
    void addJogoTest() throws SQLException {
        con.setAutoCommit(false);
        assertEquals(1,adicionar.jogo("wii","Mario Kart 7"));
        con.rollback();
    }

    @Test
    @DisplayName("Adicionar peronagens ao DB")
    void addPersonagemTest() throws SQLException {
        int total = 0;
        con.setAutoCommit(false);
        total += adicionar.personagem("Mario Kart 7", "mario");
        total += adicionar.personagem("Mario Kart 7", "luigi");
        total += adicionar.personagem("Mario Kart 7", "bowser");
        total += adicionar.personagem("Mario Kart 7", "wario");
        total += adicionar.personagem("Mario Kart 7", "boo");
        assertEquals(5,total);
        con.rollback();
    }

    @Test
    @DisplayName("adicionar empresa já existente")
    void empresaExiste() throws SQLException {
        con.setAutoCommit(false);
        assertEquals(0,adicionar.empresa("Nintendo"));
        con.rollback();
    }

    @Test
    @DisplayName("adicionar plataforma já existente")
    void plataformaExiste() throws SQLException {
        con.setAutoCommit(false);
        assertEquals(0,adicionar.plataforma("Nintendo","Wii"));
        con.rollback();
    }

    @Test
    @DisplayName("adicionar jogo já existente")
    void jogoExiste() throws SQLException {
        con.setAutoCommit(false);
        assertEquals(0,adicionar.jogo("Wii","Mario Kart Wii"));
        con.rollback();
    }

    @Test
    @DisplayName("adicionar personagem já existente")
    void personagemExiste() throws SQLException {
        con.setAutoCommit(false);
        assertEquals(0,adicionar.personagem("Mario Kart 7","Mario"));
        con.rollback();
    }
}
