package Game_Catalog;

import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;

import static java.util.Collections.singletonMap;


public class SalvarArquivoJSON {

    private JSONObject adicionar = new JSONObject();
    private FileWriter salvar;

    public String salvarJogoePersonagemJSON(JSONObject catalogo,String empresa, String plataforma, String jogo, String[] personagens) throws IOException {
        this.adicionar = (JSONObject) catalogo.get("Empresa");
        if (this.adicionar.containsKey(empresa))
        {
            this.adicionar = (JSONObject) adicionar.get(empresa);
            if(this.adicionar.containsKey(plataforma))
            {
                this.adicionar = (JSONObject) this.adicionar.get(plataforma);
                if (this.adicionar.containsKey(jogo))
                {
                    return "Jogo já existe";
                }
                else
                {
                    this.adicionar.put(jogo,personagens);
                    this.salvar.write(catalogo.toJSONString());
                    return "Jogo Salvo";
                }
            }
            else
            {
                this.adicionar.put(plataforma, singletonMap(jogo,personagens));
                this.salvar.write(catalogo.toJSONString());
                return "Jogo Salvo";
            }
        }
        else
        {
            this.adicionar.put(empresa, singletonMap(plataforma, singletonMap(jogo,personagens)));
            this.salvar.write(catalogo.toJSONString());
            return "Jogo Salvo";
        }
    }

    public SalvarArquivoJSON(String path) throws IOException {
        this.salvar = new FileWriter(path);
    }
}
