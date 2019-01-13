import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InsertDadosTest {

    InsertDados adicionar = new InsertDados();
    @Test
    @DisplayName("Adicionar empresa ao DB")
    void addEmpresaTest()
    {
        assertEquals(1,adicionar.empresa("Nintendo"));
    }
}
