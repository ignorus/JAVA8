package Game_Catalog;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class AtualizarLeitura {

    public boolean LeituraAtualizada(String verificador,String path, LerArquivoJSON lerJsonMock)
    {
        if (verificador.equals("Jogo Salvo")) {
            lerJsonMock.AbrirArquivoJSON(path);
            return TRUE;
        }
        else
        {
            return FALSE;
        }
    }
}
