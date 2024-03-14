package desafio;

import java.util.concurrent.ThreadLocalRandom;

public class Cofrinho {

    public String meta;
    public Double poupado;
    public Boolean quebrado = false;

    public Cofrinho(String meta) {
        this.meta = meta;
    }

    public Boolean depositar(Double valor) {
        if (!quebrado) {
            this.poupado = valor;
            return true;
        }
        Mensagem.quebrado();
        return null;
    }

    public Boolean definirMeta(String meta) {
        if (!quebrado)  {
            this.meta = meta;
            return true;
        }
        Mensagem.quebrado();
        return null;
    }

    public Double agitar() {
        if (!quebrado) return ThreadLocalRandom.current().nextDouble(0, poupado+1);
        Mensagem.quebrado();
        return null;
    }

    public Double quebrar() {
        if (!quebrado) {
            this.quebrado = true;
            return poupado;
        }
        Mensagem.quebrado();
        return null;
    }

}
