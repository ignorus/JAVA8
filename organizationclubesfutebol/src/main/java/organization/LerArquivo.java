package organization;

import java.io.FileNotFoundException;
import java.util.List;

public interface LerArquivo {

    void lerArquivo(List times, String nomeArquivo) throws FileNotFoundException;
}
