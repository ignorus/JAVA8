package Game_Catalog;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Rule;
import org.junit.jupiter.api.*;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AtualizarLeituraTest {

    AtualizarLeitura atualizadorMock;
    AtualizarLeitura atualizador;
    SalvarArquivoJSON salvarMock;
    String verificador;
    String caminhoArquivo;
    JSONObject objetoParametro;
    JSONObject objetoAuxiliar;
    String[] mockParametro;
    File arquivoTemp;
    FileWriter escrver;
    FileReader leitor;
    LerArquivoJSON lerJsonMock;
    JSONParser parser;

    @Rule TemporaryFolder folder;

    @BeforeEach
    void iniciar() throws IOException {
        atualizadorMock = mock(new AtualizarLeitura().getClass());
        salvarMock = mock(new SalvarArquivoJSON("test").getClass());
        objetoParametro = new JSONObject();
        objetoAuxiliar = new JSONObject();
        mockParametro = new String[]{"oi","alo"};
        atualizador = new AtualizarLeitura();
        folder = new TemporaryFolder();
        folder.create();
        parser = new JSONParser();
        lerJsonMock = mock(new LerArquivoJSON().getClass());
        arquivoTemp = folder.newFile("Temporario.Json");
        escrver = new FileWriter(arquivoTemp);
        escrver.write("{\"Nome\":\"Tiago\"}");
        escrver.close();
        leitor = new FileReader(arquivoTemp);
        caminhoArquivo = arquivoTemp.getAbsolutePath();

    }

    @Test
    @DisplayName("Atualiza a leitura de um mock, após algo ser escrito nele")
    void AtualizaMock()
    {
        when(atualizadorMock.LeituraAtualizada(verificador,caminhoArquivo, lerJsonMock)).thenReturn(TRUE);
        assertTrue(atualizadorMock.LeituraAtualizada(verificador,caminhoArquivo, lerJsonMock));
    }

    @Test
    @DisplayName("Dado um arquivo mock salvo, atualizar")
    void SalvoAtualizarMock() throws IOException {

        when(salvarMock.salvarJogoePersonagemJSON(objetoParametro,"a","b","c",mockParametro)).thenReturn("Jogo Salvo");
        verificador = salvarMock.salvarJogoePersonagemJSON(objetoParametro,"a","b","c",mockParametro);
        when(atualizadorMock.LeituraAtualizada(verificador,caminhoArquivo, lerJsonMock)).thenReturn(TRUE);
        assertTrue(atualizadorMock.LeituraAtualizada(verificador,caminhoArquivo, lerJsonMock));
    }

    @Test
    @DisplayName("Dado um arquivo mock salvo sem alterações, não atualizar")
    void SalvoNaoAtualizarMock() throws IOException {
        when(salvarMock.salvarJogoePersonagemJSON(objetoParametro,"a","b","c",mockParametro)).thenReturn("Jogo já existe");
        verificador = salvarMock.salvarJogoePersonagemJSON(objetoParametro,"a","b","c",mockParametro);
        when(atualizadorMock.LeituraAtualizada(verificador,caminhoArquivo, lerJsonMock)).thenReturn(FALSE);
        assertFalse(atualizadorMock.LeituraAtualizada(verificador,caminhoArquivo, lerJsonMock));
    }

    @Test
    @DisplayName("Dada um arquivo mock, testar funcionalidade de atualizar")
    void  SalvoAtualizar() throws IOException {
        when(salvarMock.salvarJogoePersonagemJSON(objetoParametro,"a","b","c",mockParametro)).thenReturn("Jogo Salvo");
        verificador = salvarMock.salvarJogoePersonagemJSON(objetoParametro,"a","b","c",mockParametro);
        assertTrue(atualizador.LeituraAtualizada(verificador,caminhoArquivo, lerJsonMock));
    }

    @Test
    @DisplayName("Dada um arquivo mock, testar funcionalidade de não atualizar")
    void  SalvoNaoAtualizar() throws IOException {
        when(salvarMock.salvarJogoePersonagemJSON(objetoParametro,"a","b","c",mockParametro)).thenReturn("Jogo já existe");
        verificador = salvarMock.salvarJogoePersonagemJSON(objetoParametro,"a","b","c",mockParametro);
        assertFalse(atualizador.LeituraAtualizada(verificador,caminhoArquivo, lerJsonMock));
    }

    @Test
    @DisplayName("Dado um arquivo temporario alterado, atualizar o Reader")
    void ArquivoTemporarioAtualizar() throws IOException, ParseException {
        when(salvarMock.salvarJogoePersonagemJSON(objetoParametro,"a","b","c",mockParametro)).thenReturn("Jogo Salvo");
        verificador = salvarMock.salvarJogoePersonagemJSON(objetoParametro,"a","b","c",mockParametro);
        objetoParametro = (JSONObject) parser.parse(leitor);
        leitor.close();
        objetoAuxiliar =  objetoParametro;
        objetoAuxiliar.put("Sobrenome","Bugan");
        escrver = new FileWriter(arquivoTemp);
        escrver.write(objetoParametro.toJSONString());
        escrver.close();
        when(lerJsonMock.AbrirArquivoJSON(anyString())).thenCallRealMethod();
        atualizador.LeituraAtualizada(verificador,caminhoArquivo, lerJsonMock);
        when(lerJsonMock.getArquivo()).thenCallRealMethod();
        assertNotNull(lerJsonMock.getArquivo());
    }

    @Test
    @DisplayName("Dado um arquivo temporario nao alterado, nao atualizar o Reader")
    void ArquivoTemporarioNaoAtualizar() throws IOException, ParseException {
        when(salvarMock.salvarJogoePersonagemJSON(objetoParametro,"a","b","c",mockParametro)).thenReturn("Jogo já existe");
        verificador = salvarMock.salvarJogoePersonagemJSON(objetoParametro,"a","b","c",mockParametro);
        objetoParametro = (JSONObject) parser.parse(leitor);
        leitor.close();
        objetoAuxiliar =  objetoParametro;
        objetoAuxiliar.putIfAbsent("Nome","Tiago");
        escrver = new FileWriter(arquivoTemp);
        escrver.write(objetoParametro.toJSONString());
        escrver.close();
        when(lerJsonMock.AbrirArquivoJSON(anyString())).thenCallRealMethod();
        atualizador.LeituraAtualizada(verificador,caminhoArquivo, lerJsonMock);
        when(lerJsonMock.getArquivo()).thenCallRealMethod();
        assertNull(lerJsonMock.getArquivo());
    }

    @Test
    @DisplayName("Dado um arquivo temporario nao alterado, nao atualizar o Reader, verificar retorno")
    void ArquivoTemporarioNaoAtualizarVerifica() throws IOException, ParseException {
        boolean retorno;
        when(salvarMock.salvarJogoePersonagemJSON(objetoParametro,"a","b","c",mockParametro)).thenReturn("Jogo já existe");
        verificador = salvarMock.salvarJogoePersonagemJSON(objetoParametro,"a","b","c",mockParametro);
        objetoParametro = (JSONObject) parser.parse(leitor);
        leitor.close();
        objetoAuxiliar =  objetoParametro;
        objetoAuxiliar.putIfAbsent("Nome","Tiago");
        escrver = new FileWriter(arquivoTemp);
        escrver.write(objetoParametro.toJSONString());
        escrver.close();
        when(lerJsonMock.AbrirArquivoJSON(anyString())).thenCallRealMethod();
        retorno = atualizador.LeituraAtualizada(verificador,caminhoArquivo, lerJsonMock);
        assertFalse(retorno);
    }
}
