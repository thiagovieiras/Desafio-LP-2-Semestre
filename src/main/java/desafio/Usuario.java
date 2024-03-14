package desafio;
import java.util.ArrayList;
import java.util.List;

public class Usuario {

    public String nome;

    List<Cofrinho> listaCofrinho = new ArrayList<>();
    Cofrinho cofrinho;

    public String definirCofrinho(String meta) {
        cofrinho = new Cofrinho(meta);
        listaCofrinho.add(cofrinho);
        return "Cofrinho definido.";
    }

    public String usarCofrinho(String metaCofrinho) {
        for (Cofrinho cofre : this.listaCofrinho) {
            if (metaCofrinho.equals(cofre.meta)) {
                this.cofrinho = cofre;
            }
        }
        return ("Cofrinho " + cofrinho + " selecionado.");
    }

    void definirMeta(String meta) {
        if (cofrinho.definirMeta(meta).equals(null)) System.out.println("Não é possivel definir meta para um cofre quebrado");
        else System.out.println("Meta %s definida com sucesso.".formatted(meta));
    }

    void depositarValor(Double valor) {
        if (cofrinho.depositar(valor).equals(null)) System.out.println("Não é possivel depositar pois o cofre está quebrado.");
        else System.out.println("Valor de %.2f depositado com sucesso.".formatted(valor));
    }

    void agitar() {
        if (!cofrinho.agitar().equals(null)) System.out.println("O valor recebido foi "+ cofrinho.agitar());
        else System.out.println("Não é possivel agitar o cofrinho pois está quebrado.");
    }

    void quebrar() {
        if (cofrinho.quebrar().equals(null)) System.out.println("Não é possivel quebrar o cofre quebrado.");
        else System.out.println("Cofrinho quebrado com sucesso.");
    }


}
