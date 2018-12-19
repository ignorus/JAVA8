package Game_Catalog;

import org.json.simple.JSONObject;
import org.junit.jupiter.api.*;

import java.io.IOException;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyObject;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AtualizarLeituraTest {

    AtualizarLeitura atualizador;
    SalvarArquivoJSON salvar;
    String verificador;
    JSONObject objetoParametro;

    @BeforeEach
    void iniciar() throws IOException {
        atualizador = mock(new AtualizarLeitura().getClass());
        salvar = mock(new SalvarArquivoJSON("test").getClass());
        objetoParametro = new JSONObject();
    }

    @Test
    @DisplayName("Atualiza a leitura de um mock, após algo ser escrito nele")
    void AtualizaMock()
    {
        when(atualizador.LeituraAtualizada(verificador)).thenReturn(TRUE);
        assertTrue(atualizador.LeituraAtualizada(verificador));
    }

    @Test
    @DisplayName("Dado um arquivo mock salvo, atualizar")
    void SalvoAtualizarMock() throws IOException {
        String[] mockParametro = new String[]{"oi","alo"};
        when(salvar.salvarJogoePersonagemJSON(objetoParametro,"a","b","c",mockParametro)).thenReturn("Jogo Salvo");
        verificador = salvar.salvarJogoePersonagemJSON(objetoParametro,"a","b","c",mockParametro);
        when(atualizador.LeituraAtualizada(verificador)).thenReturn(TRUE);
        assertTrue(atualizador.LeituraAtualizada(verificador));
    }

    @Test
    @DisplayName("Dado um arquivo mock salvo sem alterações, não atualizar")
    void SalvoNaoAtualizarMock() throws IOException {
        String[] mockParametro = new String[]{"oi","alo"};
        when(salvar.salvarJogoePersonagemJSON(objetoParametro,"a","b","c",mockParametro)).thenReturn("Jogo já existe");
        verificador = salvar.salvarJogoePersonagemJSON(objetoParametro,"a","b","c",mockParametro);
        when(atualizador.LeituraAtualizada(verificador)).thenReturn(FALSE);
        assertFalse(atualizador.LeituraAtualizada(verificador));
    }
}
