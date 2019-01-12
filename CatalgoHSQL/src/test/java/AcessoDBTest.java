import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AcessoDBTest {

    @Test
    @DisplayName("Estabelecer conexão DB")
    void connectDB() {
        AcessoDB acessar = new AcessoDB();
        assertNotNull(acessar.conectar());
    }
}
