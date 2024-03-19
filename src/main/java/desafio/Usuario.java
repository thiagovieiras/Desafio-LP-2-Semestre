package desafio;
import java.util.ArrayList;
import java.util.List;

public class Usuario {

    public String nome;

    List<Cofrinho> listaCofrinho = new ArrayList<>();
    Cofrinho cofrinho;

    void definirCofrinho(String meta) {
        cofrinho = new Cofrinho(meta);
        listaCofrinho.add(cofrinho);
        System.out.println("Cofrinho definido.");
    }

    void usarCofrinho(String metaCofrinho) {
        for (Cofrinho cofre : this.listaCofrinho) {
            if (metaCofrinho.equals(cofre.meta)) {
                this.cofrinho = cofre;
            }
        }
        System.out.println("Cofrinho " + cofrinho + " selecionado.");
    }

    
    void definirMeta(String meta) {
        if (cofrinho.definirMeta(meta).equals(null)) Mensagem.quebrado(meta);
        else System.out.println("Meta %s definida com sucesso.".formatted(meta));
    }

    void depositarValor(Double valor) {
        if (cofrinho.depositar(valor).equals(null)) Mensagem.quebrado(cofrinho.meta);
        else System.out.println("Valor de %.2f depositado com sucesso.".formatted(valor));
    }

    void agitar() {
        if (!cofrinho.agitar().equals(null)) System.out.println("O valor recebido foi "+ cofrinho.agitar());
        else Mensagem.quebrado(cofrinho.meta);
    }
    
    void quebrar() {
        if (cofrinho.quebrar().equals(null)) System.out.println("Não é possivel quebrar o cofre quebrado.");
        else System.out.println("Cofrinho quebrado com sucesso.");
    }

    void quebrarTodos() {
        for (Cofrinho cofrinho : listaCofrinho) {
            if (cofrinho.quebrar().equals(null)) Mensagem.quebrado(cofrinho.meta);
            else System.out.println("Cofrinho '%s' quebrado com sucesso.".formatted(cofrinho.meta));
        }
    }

    void saldoAtualCofre() {
        try {
            System.out.println("Saldo do atual cofre é: R$ %.2f".formatted(cofrinho.poupado));
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    void saldoTotal() {
        Double saldo = 0.0;
        for (Cofrinho cofrinho : listaCofrinho) {
            saldo += cofrinho.poupado;
        }
        System.out.println("Valor total de seus cofrinhos é: R$ %.2f".formatted(saldo));
    }


}
