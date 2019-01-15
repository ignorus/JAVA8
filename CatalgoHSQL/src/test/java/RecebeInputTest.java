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

    @Test
    @DisplayName("Recebe input salvar")
    void salvarTest()
    {
        simulaUsuario = new ByteArrayInputStream("salvar\n".getBytes());
        System.setIn(simulaUsuario);
        when(inputMock.LerouSalvar()).thenCallRealMethod();
        assertEquals("salvar",inputMock.LerouSalvar());
    }

    @Test
    @DisplayName("Recebe input invalido")
    void inputErrorTest()
    {
        simulaUsuario = new ByteArrayInputStream("adicionar\n".getBytes());
        System.setIn(simulaUsuario);
        when(inputMock.LerouSalvar()).thenCallRealMethod();
        assertEquals("Invalido",inputMock.LerouSalvar());
    }

    @Test
    @DisplayName("Recebe input para ler ou salvar determinada empresa")
    void inputEmpresaTest()
    {
        simulaUsuario = new ByteArrayInputStream("Nintendo\n".getBytes());
        System.setIn(simulaUsuario);
        when(inputMock.Empresa()).thenCallRealMethod();
        assertEquals("Nintendo",inputMock.Empresa());
    }

    @Test
    @DisplayName("Recebe input insignificativo para ler ou salvar determinada empresa")
    void inputNullTest()
    {
        simulaUsuario = new ByteArrayInputStream(" \n".getBytes());
        System.setIn(simulaUsuario);
        when(inputMock.Empresa()).thenCallRealMethod();
        assertEquals("Invalido", inputMock.Empresa());
    }

    @Test
    @DisplayName("Recebe input para ler ou salvar determinada plataforma")
    void inputPlataformaTest()
    {
        simulaUsuario = new ByteArrayInputStream("wii\n".getBytes());
        System.setIn(simulaUsuario);
        when(inputMock.Plataforma()).thenCallRealMethod();
        assertEquals("wii",inputMock.Plataforma());
    }

    @Test
    @DisplayName("Recebe input insignificativo para ler ou salvar determinada plataforma")
    void inputIndiferenteTest()
    {
        simulaUsuario = new ByteArrayInputStream(" \n".getBytes());
        System.setIn(simulaUsuario);
        when(inputMock.Plataforma()).thenCallRealMethod();
        assertEquals("Invalido", inputMock.Plataforma());
    }
}
