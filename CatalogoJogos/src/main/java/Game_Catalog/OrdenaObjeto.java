package Game_Catalog;

import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrdenaObjeto {

    private List listaOrdenada;

    public List ordenar(JSONObject objeto) {
        this.listaOrdenada = new ArrayList();
        this.listaOrdenada.addAll(objeto.keySet());
        Collections.sort(this.listaOrdenada);
        return this.listaOrdenada;
    }
}
