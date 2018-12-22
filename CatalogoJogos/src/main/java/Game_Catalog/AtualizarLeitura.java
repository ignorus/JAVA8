package Game_Catalog;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class AtualizarLeitura {

    public boolean LeituraAtualizada(String verificador,String path, LerArquivoJSON lerJson)
    {
        if (verificador.equals("Jogo Salvo")) {
            lerJson.AbrirArquivoJSON(path);
            return TRUE;
        }
        else
        {
            return FALSE;
        }
    }
}
