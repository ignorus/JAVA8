import org.hsqldb.jdbc.JDBCDriver;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.*;

public class testarTest {

    @Test
    @DisplayName("Aprendendo HSQL")
    void HSQLTest()
    {
        Connection con = null;

        try {
            //Registering the HSQLDB JDBC driver
            Class.forName("org.hsqldb.jdbc.JDBCDriver");
            //Creating the connection with HSQLDB
            con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/testdb", "SA", "");
            if (con!= null){
                System.out.println("Connection created successfully");

            }else{
                System.out.println("Problem with creating connection");
            }

        }  catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

    @Test
    @DisplayName("Criar tabela X no DB")
    void criarTabelaemHSQL()
    {
        Connection con = null;
        Statement stmt = null;
        int result = 0;

        try {
            Class.forName("org.hsqldb.jdbc.JDBCDriver");
            con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/testdb", "SA", "");
            stmt = con.createStatement();

            result = stmt.executeUpdate("CREATE TABLE tutorials_tbl ("+
                    "id INT NOT NULL, title VARCHAR(50) NOT NULL,"+
                    "author VARCHAR(20) NOT NULL, submission_date DATE,"+
                    "PRIMARY KEY (id));"
            );

        }  catch (Exception e) {
            e.printStackTrace(System.out);
        }
        System.out.println("Table created successfully");
    }

    @Test
    @DisplayName("Insert em tabela")
    void insertTest()
    { Connection con = null;
        Statement stmt = null;
        int result = 0;
        try {
            Class.forName("org.hsqldb.jdbc.JDBCDriver");
            con = DriverManager.getConnection( "jdbc:hsqldb:hsql://localhost/testdb", "SA", "");
            stmt = con.createStatement();
            result = stmt.executeUpdate("INSERT INTO plataformas"+
                    "( NOME_EMPRESA, NOME )"+
                    "VALUES ('Sega','Master System')");
                    con.commit();
        }catch (Exception e) {
            e.printStackTrace(System.out);
        }
        System.out.println(result+" rows effected");
        System.out.println("Rows inserted successfully");
    }

    @Test
    @DisplayName("Recuperar Informacion do DB")
    void selectHSQL()
    {
        Connection con = null;
        Statement stmt = null;
        ResultSet result = null;

        try {
            Class.forName("org.hsqldb.jdbc.JDBCDriver");
            con = DriverManager.getConnection(
                    "jdbc:hsqldb:hsql://localhost/testdb", "SA", "");
            stmt = con.createStatement();
            result = stmt.executeQuery(
                    "SELECT nome_empresa, nome FROM plataformas");

            while(result.next()){
                System.out.println(result.getString("nome_empresa")+" | "+
                        result.getString("nome"));
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

    @Test
    @DisplayName("Recuperar informacion especifica de HSQL")
    void whereTest()
    {Connection con = null;
        Statement stmt = null;
        ResultSet result = null;
        try {
            Class.forName("org.hsqldb.jdbc.JDBCDriver");
            con = DriverManager.getConnection(
                    "jdbc:hsqldb:hsql://localhost/testdb", "SA", "");
            stmt = con.createStatement();
            result = stmt.executeQuery(
                    "SELECT id, title, author FROM tutorials_tbl "+
                    "WHERE title = 'Learn C++'");

            while(result.next()){
                System.out.println(result.getInt("id")+" |"
                        + result.getString("title")+" |"
                                +result.getString("author"));
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

    @Test
    @DisplayName("Criando mais uma tabela")
    void outraTabelaTest()
    {
        Connection connection = null;
        Statement statement = null;
        try {
            Class.forName("org.hsqldb.jdbc.JDBCDriver");
            connection = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/testdb","SA","");
            statement = connection.createStatement();
            statement.executeQuery("CREATE TABLE plataformas(nome_empresa VARCHAR(30) NOT NULL, nome VARCHAR(50) NOT NULL, PRIMARY KEY(nome));");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("Join Test")
    void joinTest()
    {
        Connection connection = null;
        Statement statement = null;
        ResultSet result = null;
        try {
            Class.forName("org.hsqldb.jdbc.JDBCDriver");
            connection = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/testdb","SA","");
            statement = connection.createStatement();
            result = statement.executeQuery("SELECT NOME, plataforma FROM EMPRESAS INNER JOIN PLATAFORMAS "+
                    "ON EMPRESAS.NOME = PLATAFORMAS.NOME_EMPRESA WHERE Nome  = 'Nintendo'");
            while(result.next()){
                System.out.println(result.getString("nome")+" | "+
                        result.getString("plataforma"));
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("Alter Test")
    void alterTest()
    {
        Connection connection = null;
        Statement statement = null;
        try {
            Class.forName("org.hsqldb.jdbc.JDBCDriver");
            connection = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/testdb","SA","");
            statement = connection.createStatement();
            statement.executeQuery("ALTER TABLE plataformas ALTER COLUMN nome RENAME TO plataforma" );
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
