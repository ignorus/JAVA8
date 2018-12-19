package Game_Catalog;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class AtualizarLeitura {

    public boolean LeituraAtualizada(String verificador)
    {
        if (verificador.equals("Jogo Salvo")) {
            return TRUE;
        }
        else
        {
            return FALSE;
        }
    }
}
