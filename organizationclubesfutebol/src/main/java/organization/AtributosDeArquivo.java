package organization;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class AtributosDeArquivo {


        String nome;
        String ordenar;
        List<String> lista = new ArrayList<String>();

        private void setNome(String nome) {
            this.nome = nome;
        }

        private void setOrdenar(String ordenar) {
            this.ordenar = ordenar;
        }

        public void incrementaLista(String texto){
            this.lista.add(texto);
        }


        public AtributosDeArquivo(@NotNull List<String> instrucion) {
            setNome(instrucion.get(0));
            setOrdenar(instrucion.get(1));
        }
    }
