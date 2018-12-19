package Game_Catalog;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;

import static java.util.Collections.singletonMap;


public class SalvarArquivoJSON {

    private JSONObject adicionar = new JSONObject();
    private FileWriter salvar;
    private JSONArray personagem = new JSONArray();

    public String salvarJogoePersonagemJSON(JSONObject catalogo,String empresa, String plataforma, String jogo, String[] personagens) throws IOException {
        this.personagem.addAll(Arrays.asList(personagens));
        this.adicionar = (JSONObject) catalogo.get("Empresa");
        if (this.adicionar.containsKey(empresa))
        {
            this.adicionar = (JSONObject) adicionar.get(empresa);
            if(this.adicionar.containsKey(plataforma))
            {
                this.adicionar = (JSONObject) this.adicionar.get(plataforma);
                if (this.adicionar.containsKey(jogo))
                {
                    this.salvar.write(catalogo.toJSONString());
                    this.salvar.close();
                    return "Jogo já existe";
                }
                else
                {
                    this.adicionar.put(jogo,this.personagem);
                    this.salvar.write(catalogo.toJSONString());
                    this.salvar.close();
                    return "Jogo Salvo";
                }
            }
            else
            {
                this.adicionar.put(plataforma, singletonMap(jogo, this.personagem));
                this.salvar.write(catalogo.toJSONString());
                this.salvar.close();
                return "Jogo Salvo";
            }
        }
        else
        {
            this.adicionar.put(empresa, singletonMap(plataforma, singletonMap(jogo, this.personagem)));
            this.salvar.write(catalogo.toJSONString());
            this.salvar.close();
            return "Jogo Salvo";
        }
    }

    public SalvarArquivoJSON(String path) throws IOException {
        this.salvar = new FileWriter(path);
    }
}
