package Game_Catalog;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;

public class LerArquivoJSON {

    private FileReader arquivo;
    private JSONObject arquivoEstrturado;
    private JSONParser estruturador;

    public void AbrirArquivoJSON(String path) throws FileNotFoundException {
        this.arquivo = new FileReader(path);
    }

    public void SepararDadosDoArquivo(Reader leitor) throws IOException, ParseException {
        this.arquivoEstrturado = (JSONObject) this.estruturador.parse(leitor);
    }

    public JSONObject getArquivoEstrturado() {
        return arquivoEstrturado;
    }

    public FileReader getArquivo() {
        return arquivo;
    }
}
