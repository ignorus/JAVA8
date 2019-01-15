import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertDados {
    private Connection DB;
    InsertDados(Connection connect)
    {
        this.DB = connect;
    }

    public int empresa(String nomeEmpresa)
    {
        int resultado = 0;
        try {
            Statement stm =  this.DB.createStatement();
            resultado = stm.executeUpdate("INSERT INTO empresas (NOME_EMPRESA) VALUES('"+ nomeEmpresa +"')");
        } catch (SQLException e) {
            System.out.println("Instrução invalida ou registro já existe");
        }
        return resultado;
    }

    public int plataforma(String empresa, String nomePlataforma) {

        int resultado = 0;
        try {
            Statement stm =  this.DB.createStatement();
            resultado = stm.executeUpdate("INSERT INTO plataformas (EMPRESA,NOME_PLATAFORMA) VALUES('"+ empresa +"','"+ nomePlataforma +"')");
        } catch (SQLException e) {
            System.out.println("Instrução invalida ou registro já existe");
        }
        return resultado;
    }

    public int jogo(String plataforma, String nomeJogo) {

        int resultado = 0;
        try {
            Statement stm =  this.DB.createStatement();
            resultado = stm.executeUpdate("INSERT INTO jogos (PLATAFORMA,NOME_JOGO) VALUES('"+ plataforma +"','"+ nomeJogo +"')");
        } catch (SQLException e) {
            System.out.println("Instrução invalida ou registro já existe");
        }
        return resultado;
    }

    public int personagem(String jogo, String nomePersonagem) {
        int resultado = 0;
        try {
            Statement stm =  this.DB.createStatement();
            resultado = stm.executeUpdate("INSERT INTO personagens (JOGO,NOME_PERSONAGEM) VALUES('"+ jogo +"','"+ nomePersonagem +"')");
        } catch (SQLException e) {
            System.out.println("Instrução invalida ou registro já existe");
        }
        return resultado;
    }
}
