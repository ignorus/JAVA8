import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class RecebeInputTest {

    RecebeInput inputMock = mock(new RecebeInput().getClass());
    InputStream simulaUsuario;

    @Test
    @DisplayName("Recebe input Ler mock")
    void lerTestMock()
    {
        when(inputMock.LerouSalvar()).thenReturn("ler");
        assertEquals("ler",inputMock.LerouSalvar());
    }

    @Test
    @DisplayName("Recebe input ler")
    void lerTest()
    {
        simulaUsuario = new ByteArrayInputStream("ler\n".getBytes());
        System.setIn(simulaUsuario);
        when(inputMock.LerouSalvar()).thenCallRealMethod();
        assertEquals("ler",inputMock.LerouSalvar());
    }
}
