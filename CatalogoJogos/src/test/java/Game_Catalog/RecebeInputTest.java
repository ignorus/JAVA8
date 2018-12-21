package Game_Catalog;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class RecebeInputTest {

    RecebeInput inputMock;
    InputStream inputSimulator;

    @BeforeEach
    void iniciar()
    {
        inputMock = mock(new RecebeInput().getClass());
    }

    @Test
    @DisplayName("Recebe o mock do comando para ler Arquivo")
    void ComandoLerMock()
    {
        when(inputMock.LerOuSalvar()).thenReturn("ler");
        assertTrue("Ler".equalsIgnoreCase(inputMock.LerOuSalvar()));
    }

    @Test
    @DisplayName("Recebe o mock do comando para salvar Arquivo")
    void ComandoSalvarMock()
    {
        when(inputMock.LerOuSalvar()).thenReturn("salvar");
        assertTrue("Salvar".equalsIgnoreCase(inputMock.LerOuSalvar()));
    }

    @Test
    @DisplayName("Recebe o comando para ler Arquivo")
    void ComandoLer()
    {
        when(inputMock.LerOuSalvar()).thenCallRealMethod();
        inputSimulator = new ByteArrayInputStream("ler\r\n".getBytes());
        System.setIn(inputSimulator);
        assertTrue("ler".equalsIgnoreCase(inputMock.LerOuSalvar()));
    }

    @Test
    @DisplayName("Recebe o comando para salvar Arquivo")
    void ComandoSalvar()
    {
        when(inputMock.LerOuSalvar()).thenCallRealMethod();
        inputSimulator = new ByteArrayInputStream("salvar\r\n".getBytes());
        System.setIn(inputSimulator);
        assertTrue("salvar".equalsIgnoreCase(inputMock.LerOuSalvar()));
    }
}
