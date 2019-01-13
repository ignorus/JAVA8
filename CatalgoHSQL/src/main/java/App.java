import java.sql.Connection;

public class App {

    public static void main(String[] args)
    {
        AcessoDB entrar = new AcessoDB();
        Connection conexao = entrar.conectar();
    }
}
