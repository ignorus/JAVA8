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
    String[] verificar;

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

    @Test
    @DisplayName("Recebe input para ler ou salvar determinado jogo")
    void inputJogoTest()
    {
        simulaUsuario = new ByteArrayInputStream("Mario Party\n".getBytes());
        System.setIn(simulaUsuario);
        when(inputMock.Jogo()).thenCallRealMethod();
        assertEquals("Mario Party",inputMock.Jogo());
    }

    @Test
    @DisplayName("Recebe input insignificativo para ler ou salvar determinado jogo")
    void inputTest()
    {
        simulaUsuario = new ByteArrayInputStream(" \n".getBytes());
        System.setIn(simulaUsuario);
        when(inputMock.Jogo()).thenCallRealMethod();
        assertEquals("Invalido", inputMock.Jogo());
    }

    @Test
    @DisplayName("Recebe input de varios personagens para salvar")
    void salvarPersonagensTest()
    {
        simulaUsuario = new ByteArrayInputStream("Mario,Luigi,Boo,Bowser,Toad\n".getBytes());
        System.setIn(simulaUsuario);
        when(inputMock.Personagens()).thenCallRealMethod();
        verificar = inputMock.Personagens();
        assertEquals(5,verificar.length);
    }

    @Test
    @DisplayName("Recebe input null personagens para salvar")
    void salvarPersonagensNullTest()
    {
        simulaUsuario = new ByteArrayInputStream("\n".getBytes());
        System.setIn(simulaUsuario);
        when(inputMock.Personagens()).thenCallRealMethod();
        verificar = inputMock.Personagens();
        assertEquals("Invalido",verificar[0]);
    }

    @Test
    @DisplayName("Usuario deseja continuar")
    void continuar()
    {
        simulaUsuario = new ByteArrayInputStream("sim".getBytes());
        System.setIn(simulaUsuario);
        when(inputMock.continuar()).thenCallRealMethod();
        assertEquals(-1,inputMock.continuar());
    }

    @Test
    @DisplayName("Usuario não deseja continuar")
    void naoContinuar()
    {
        simulaUsuario = new ByteArrayInputStream("nao".getBytes());
        System.setIn(simulaUsuario);
        when(inputMock.continuar()).thenCallRealMethod();
        assertEquals(0,inputMock.continuar());
    }
}
