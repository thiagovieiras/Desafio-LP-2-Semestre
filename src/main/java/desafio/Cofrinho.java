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
            Thread investThread = new Thread(() -> {while (!quebrado) {investir();}});
            investThread.start();
            return true;
        }
        return null;
    }

    public Boolean definirMeta(String meta) {
        if (!quebrado)  {
            this.meta = meta;
            return true;
        }
        return null;
    }

    public Double agitar() {
        if (!quebrado) return ThreadLocalRandom.current().nextDouble(0, poupado+1);
        return null;
    }

    public Double quebrar() {
        if (!quebrado) {
            this.quebrado = true;
            return poupado;
        }
        return null;
    }

    void investir() {
        try {
            poupado += poupado * 0.01; 
            Thread.sleep(4200);
        } catch (InterruptedException e) {
            System.out.println("Investimento interrompido.");
            e.printStackTrace();
        }
    }

}
