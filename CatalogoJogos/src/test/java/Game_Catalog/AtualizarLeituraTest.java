package Game_Catalog;

import org.json.simple.JSONObject;
import org.junit.Rule;
import org.junit.jupiter.api.*;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AtualizarLeituraTest {

    AtualizarLeitura atualizadorMock;
    AtualizarLeitura atualizador;
    SalvarArquivoJSON salvar;
    String verificador;
    JSONObject objetoParametro;
    String[] mockParametro;
    File arquivoTemp;
    FileWriter escrver;

    @Rule TemporaryFolder folder;

    @BeforeEach
    void iniciar() throws IOException {
        atualizadorMock = mock(new AtualizarLeitura().getClass());
        salvar = mock(new SalvarArquivoJSON("test").getClass());
        objetoParametro = new JSONObject();
        mockParametro = new String[]{"oi","alo"};
        atualizador = new AtualizarLeitura();
        folder = new TemporaryFolder();
        folder.create();
        arquivoTemp = folder.newFile("Temporario.Json");
        escrver = new FileWriter(arquivoTemp);
        escrver.write("{\"Nome\":\"Tiago\"}");
        escrver.close();

    }

    @Test
    @DisplayName("Atualiza a leitura de um mock, após algo ser escrito nele")
    void AtualizaMock()
    {
        when(atualizadorMock.LeituraAtualizada(verificador)).thenReturn(TRUE);
        assertTrue(atualizadorMock.LeituraAtualizada(verificador));
    }

    @Test
    @DisplayName("Dado um arquivo mock salvo, atualizar")
    void SalvoAtualizarMock() throws IOException {

        when(salvar.salvarJogoePersonagemJSON(objetoParametro,"a","b","c",mockParametro)).thenReturn("Jogo Salvo");
        verificador = salvar.salvarJogoePersonagemJSON(objetoParametro,"a","b","c",mockParametro);
        when(atualizadorMock.LeituraAtualizada(verificador)).thenReturn(TRUE);
        assertTrue(atualizadorMock.LeituraAtualizada(verificador));
    }

    @Test
    @DisplayName("Dado um arquivo mock salvo sem alterações, não atualizar")
    void SalvoNaoAtualizarMock() throws IOException {
        when(salvar.salvarJogoePersonagemJSON(objetoParametro,"a","b","c",mockParametro)).thenReturn("Jogo já existe");
        verificador = salvar.salvarJogoePersonagemJSON(objetoParametro,"a","b","c",mockParametro);
        when(atualizadorMock.LeituraAtualizada(verificador)).thenReturn(FALSE);
        assertFalse(atualizadorMock.LeituraAtualizada(verificador));
    }

    @Test
    @DisplayName("Dada um arquivo mock, testar funcionalidade de atualizar")
    void  SalvoAtualizar() throws IOException {
        when(salvar.salvarJogoePersonagemJSON(objetoParametro,"a","b","c",mockParametro)).thenReturn("Jogo Salvo");
        verificador = salvar.salvarJogoePersonagemJSON(objetoParametro,"a","b","c",mockParametro);
        assertTrue(atualizador.LeituraAtualizada(verificador));
    }

    @Test
    @DisplayName("Dada um arquivo mock, testar funcionalidade de não atualizar")
    void  SalvoNaoAtualizar() throws IOException {
        when(salvar.salvarJogoePersonagemJSON(objetoParametro,"a","b","c",mockParametro)).thenReturn("Jogo já existe");
        verificador = salvar.salvarJogoePersonagemJSON(objetoParametro,"a","b","c",mockParametro);
        assertFalse(atualizador.LeituraAtualizada(verificador));
    }

    @Test
    @DisplayName("Dado um arquivo temporario alterado, atualizar o Reader")
    void ArquivoTemporarioAtualizar()
    {

    }
}
