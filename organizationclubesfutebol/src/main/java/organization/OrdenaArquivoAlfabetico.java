package organization;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class OrdenaArquivoAlfabetico implements OdenaArquivo {

    public void ordenar(List<String> times) {
        System.out.println("Ordenando arquivo");
        Collections.sort(times, new Comparator<String>() {
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
    }
}
