package Game_Catalog;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;

public class LerArquivoJSON {

    private FileReader arquivo;
    private JSONParser estruturador = new JSONParser();

    public String AbrirArquivoJSON(String path) {
        try {
            this.arquivo = new FileReader(path);
            return "Sucesso";
        }
        catch (FileNotFoundException e){
            return "Arquivo Invalido";
        }

    }

    public JSONObject SepararDadosDoArquivo(Reader leitor) throws IOException, ParseException {
        return (JSONObject) this.estruturador.parse(leitor);
    }

    public FileReader getArquivo() {
        return arquivo;
    }

}
