package desafio;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import desafio.Validations;

public class Usuario {

    public String nome;
    Scanner scanner = new Scanner(System.in);

    List<Cofrinho> listaCofrinho = new ArrayList<>();
    Cofrinho cofrinho;

    Validations validations = new Validations();

    void nomear(Usuario usuario) {
        while (true) {
            System.out.println("Qual nome você deseja cadastrar?");
            String nomeUsuario = scanner.nextLine();
            String nomeValidado = validations.validarNome(nomeUsuario);
            if (nomeValidado != null) {
                usuario.nome = nomeValidado;
                System.out.print("\n");
                Mensagem.elogiosAleatorios();
                break;
            }
        }
        return;
    }

    void definirCofrinho() {
        while (true) {
            System.out.println("Qual meta você deseja atingir?");
            String meta = scanner.nextLine();
            if (validations.validarMeta(meta)) {
                cofrinho = new Cofrinho(meta);
                listaCofrinho.add(cofrinho);
                System.out.println("Cofrinho criado com sucesso.\n");
                break;            
            }
        }
        return;
    }

    void definirMeta() {
        while (true) {
            System.out.println("Qual meta você quer dar ao cofre '%s'!".formatted(cofrinho.meta));
            String meta = scanner.nextLine();
            if (validations.validarMeta(meta)) {
                cofrinho.definirMeta(meta);
                System.out.println("Meta definida com sucessa.");
                break;
            }   
        }
        return;
    }

    void usarCofrinho(String metaCofrinho) {
        for (Cofrinho cofre : this.listaCofrinho) {
            if (metaCofrinho.equals(cofre.meta)) {
                this.cofrinho = cofre;
            }
        }
        System.out.println("Cofrinho " + cofrinho.meta + " selecionado.\n");
    }


    void definirMeta(String meta) {
        if (!cofrinho.definirMeta(meta)) Mensagem.quebrado(meta);
        else System.out.println("Meta %s definida com sucesso.\n".formatted(meta));
    }

    void depositarValor(Double valor) {
        if (!cofrinho.depositar(valor)) Mensagem.quebrado(cofrinho.meta);
        else System.out.println("Valor de %.2f depositado com sucesso.\n".formatted(valor));
    }

    void sacarValor(Double valor) {
        if (valor > cofrinho.poupado || valor < 0) System.out.println("Não é possivel sacar esse valor!");
        else if (!cofrinho.sacar(valor)) Mensagem.quebrado(cofrinho.meta);
        else System.out.println("Valor de %.2f sacado com sucesso.".formatted(valor));
    }

    void agitar() {
        if (cofrinho.agitar() != null) System.out.println("O valor recebido foi %.2f.\n".formatted(cofrinho.agitar()));
        else Mensagem.quebrado(cofrinho.meta);
    }
    
    void quebrar() {
        if (cofrinho.quebrar() == null) Mensagem.quebrado(cofrinho.meta);
        else System.out.println("Cofrinho quebrado com sucesso.\n");
    }

    void quebrarTodos() {
        for (Cofrinho cofrinho : listaCofrinho) {
            if (cofrinho.quebrar() == null) Mensagem.quebrado(cofrinho.meta);
            else System.out.println("Cofrinho '%s' quebrado com sucesso.\n".formatted(cofrinho.meta));
        }
    }

    void saldoAtualCofre() {
        System.out.println("""
            Saldo do atual cofre é: R$ %.2f.
            O seu saldo rende 1%% do total poupado a cada 4.20 segundos.\n""".formatted(cofrinho.poupado));
    }

    void saldoTotal() {
        Double saldo = 0.0;
        for (Cofrinho cofrinho : listaCofrinho) {
            saldo += cofrinho.poupado;
        }
        System.out.println("Valor total de seus cofrinhos é: R$ %.2f.\n".formatted(saldo));
    }


}
