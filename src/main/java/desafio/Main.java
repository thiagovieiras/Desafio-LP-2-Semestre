package desafio;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;



public class Main {

    static Scanner scanner = new Scanner(System.in);

    static List<String> historicoComandos = new ArrayList<>();

    static Usuario usuario;
    public static void main(String[] args) {

        Limpar.terminal();

        usuario = new Usuario();

        System.out.println("Olá, tudo bem?");    
        
        usuario.nomear(usuario);

        Limpar.terminal();
         
        while (true) {
            String desejado = desejar();
            historicoComandos.add(desejado);
            if (desejado == "0") break;
        }
        System.out.println("Certo! Até mais, tchau tchau!!");

    }

    static String desejar() {
        System.out.println("O que você deseja agora, Sr.%s?".formatted(usuario.nome));
        Mensagem.mostrarOpcoes();
        String selecionarOpcao = scanner.nextLine();
        return realizarOpcoes(selecionarOpcao);
    }

    static String[] mostrarCofrinho() {
        if (Validations.verificarListaCofre(usuario.listaCofrinho) == null) return new String[]{"2"};

        String[] numerosCofre = new String[usuario.listaCofrinho.size()];
        System.out.println("Cofre --- Metas");
        for (int i = 0; i < usuario.listaCofrinho.size(); i++) {
            numerosCofre[i] = "%d".formatted(i+1);
            System.out.println("  %d°   -  %s.".formatted(i+1, usuario.listaCofrinho.get(i).meta));
        }
        System.out.println("  0    -  Voltar.");
        return numerosCofre;
    }

    static String selecionarCofrinho(String[] numerosCofre) {
        System.out.println("\nSelecione um cofre.");
        String selecao = scanner.nextLine();
        
        if (selecao.equals("0")) return "2";
        else {
            for (int i = 0; i < usuario.listaCofrinho.size(); i++) {
                if (selecao.trim().toLowerCase().equals(usuario.listaCofrinho.get(i).meta.trim().toLowerCase()) || 
                numerosCofre[i].contains(selecao) || 
                numerosCofre[i].contains(selecao+"°")) {
                    usuario.usarCofrinho(usuario.listaCofrinho.get(i).meta);
                    return "2";
                }
            }
        }

        System.out.println("Seleção inválida, escreva o número do cofre ou a meta desejada.");
        return selecionarCofrinho(numerosCofre);
    }

    static void depositarCofrinho() {
        if (usuario.cofrinho.quebrado) {
            Mensagem.quebrado(usuario.cofrinho.meta);
            return;
        }
        while (true) {
            System.out.println("-- Valor do cofre atual :: R$ %.2f --\n".formatted(usuario.cofrinho.poupado == null ? 0.0 : usuario.cofrinho.poupado));
            System.out.println("Digíte o valor que deseja depositar: ");
            System.out.print("R$ ");
            try {
                Double valorDeposito = scanner.nextDouble();
                scanner.nextLine(); // limpa o enter deixado pelo nextDouble();
                usuario.depositarValor(valorDeposito);
                break;
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("Valor inválido, digite somente números.\n");            
                e.printStackTrace();
                Limpar.terminal();
            }
        }
        return;
    }

    static void saldoAtual() {
        while (true) {
            Limpar.terminal();
            usuario.saldoAtualCofre();
            System.out.println("[0] Voltar");
            String resposta = scanner.nextLine();
            if (resposta.equals("0")) return;
        }
    }

    static void sacarValor() {
        while (true) {
            if (usuario.cofrinho.quebrado) {
                Mensagem.quebrado(usuario.cofrinho.meta);
                return;
            }
            System.out.print("Digite a quatidade desejada: ");
            try {
                Double valorSaque = scanner.nextDouble();
                scanner.nextLine(); // limpa o enter deixado pelo nextDouble();
                usuario.sacarValor(valorSaque);
                break;
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("Valor inválido, digite somente números.\n");            
                e.printStackTrace();
                Limpar.terminal();
            }
        }
        return;
    }


    static String realizarOpcoes(String selecionarOpcao) {
        if (selecionarOpcao.trim().equals("0") || selecionarOpcao.trim().equals("[0]") || selecionarOpcao.toLowerCase().trim().equals("opção0") || selecionarOpcao.toLowerCase().trim().equals("sair")) {
            return "0";
        } else if (selecionarOpcao.trim().equals("1") || selecionarOpcao.trim().equals("[1]") || selecionarOpcao.toLowerCase().trim().equals("opção1") || selecionarOpcao.toLowerCase().trim().equals("definircofre")) {
            Limpar.terminal();
            Mensagem.elogiosAleatorios();
            usuario.definirCofrinho();
            return "1";
        } else if (selecionarOpcao.trim().equals("2") || selecionarOpcao.trim().equals("[2]") || selecionarOpcao.toLowerCase().trim().equals("opção2") || selecionarOpcao.toLowerCase().trim().equals("selecionarcofre")) {
            Limpar.terminal();
            String[] numerosCofre = mostrarCofrinho();
            if (numerosCofre[0].equals("2")) return "2";
            return selecionarCofrinho(numerosCofre);
        }
        else if (selecionarOpcao.trim().equals("3") || selecionarOpcao.trim().equals("[3]") || selecionarOpcao.toLowerCase().trim().equals("opção3") || selecionarOpcao.toLowerCase().trim().equals("definirmetaparaocofre")) {
            Limpar.terminal();
            Mensagem.elogiosAleatorios();
            if (Validations.validarCofre(usuario.cofrinho)) usuario.definirMeta();
            return "3";
        }
        else if (selecionarOpcao.trim().equals("4") || selecionarOpcao.trim().equals("[4]") || selecionarOpcao.toLowerCase().trim().equals("opção4") || selecionarOpcao.toLowerCase().trim().equals("depositarvaloraocofre")) {
            Limpar.terminal();
            Mensagem.elogiosAleatorios();
            if (Validations.validarCofre(usuario.cofrinho)) depositarCofrinho();
            return "4";
        }
        else if (selecionarOpcao.trim().equals("5") || selecionarOpcao.trim().equals("[5]") || selecionarOpcao.toLowerCase().trim().equals("opção5") || selecionarOpcao.toLowerCase().trim().equals("agitarcofre")) {
            Limpar.terminal();
            Mensagem.elogiosAleatorios();
            if (Validations.validarCofre(usuario.cofrinho)) usuario.agitar();            
            return "5";
        }
        else if (selecionarOpcao.trim().equals("6") || selecionarOpcao.trim().equals("[6]") || selecionarOpcao.toLowerCase().equals("opção6") || selecionarOpcao.toLowerCase().equals("quebrarcofre")) {
            Limpar.terminal();
            Mensagem.elogiosAleatorios();
            if (Validations.validarCofre(usuario.cofrinho)) usuario.quebrar();
            return "6";
        }
        else if (selecionarOpcao.trim().equals("7") || selecionarOpcao.trim().equals("[7]") || selecionarOpcao.toLowerCase().equals("opção7") || selecionarOpcao.toLowerCase().equals("quebrartodoscofres")) {
            Limpar.terminal();
            Mensagem.elogiosAleatorios();
            if (Validations.validarCofre(usuario.cofrinho)) usuario.quebrarTodos();
            return "7";
        }
        else if (selecionarOpcao.trim().equals("8") || selecionarOpcao.trim().equals("[8]") || selecionarOpcao.toLowerCase().equals("opção8") || selecionarOpcao.toLowerCase().equals("versaldodocofre")) {
            Limpar.terminal();
            Mensagem.elogiosAleatorios();
            if (Validations.validarCofre(usuario.cofrinho)) saldoAtual();
            return "8";
        }
        else if (selecionarOpcao.trim().equals("9") || selecionarOpcao.trim().equals("[9]") || selecionarOpcao.toLowerCase().equals("opção9") || selecionarOpcao.toLowerCase().equals("versaldototal")) {
            Limpar.terminal();
            Mensagem.elogiosAleatorios();
            if (Validations.validarCofre(usuario.cofrinho)) usuario.saldoTotal();
            return "9";
        }
        else if (selecionarOpcao.trim().toLowerCase().equals("r") || selecionarOpcao.trim().toLowerCase().equals("[r]") || selecionarOpcao.toLowerCase().equals("opçãor") || selecionarOpcao.toLowerCase().equals("renomear")) {
            Limpar.terminal();
            Mensagem.elogiosAleatorios();
            usuario.nomear(usuario);
            return "R";
        }
        else if (selecionarOpcao.trim().toLowerCase().equals("s") || selecionarOpcao.trim().toLowerCase().equals("[s]") || selecionarOpcao.toLowerCase().equals("opçãos") || selecionarOpcao.toLowerCase().equals("sacar")) {
            Limpar.terminal();
            Mensagem.elogiosAleatorios();
            if (Validations.validarCofre(usuario.cofrinho)) sacarValor();
            return "S";
        }
        else if (selecionarOpcao.trim().toLowerCase().equals("h") || selecionarOpcao.trim().toLowerCase().equals("[h]") || selecionarOpcao.toLowerCase().equals("opçãoh") || selecionarOpcao.toLowerCase().equals("histórico") || selecionarOpcao.toLowerCase().equals("historico")) {
            Limpar.terminal();
            Mensagem.elogiosAleatorios();
            mostrarHistorico();
            return "H";
        }
        Limpar.terminal();
        System.out.println("Valor '%s' incorreto".formatted(selecionarOpcao));
        System.out.println("Escolha uma opção válida.\n");
        return null; 
    }

    static void mostrarHistorico() {
        for (int i = 0; i < historicoComandos.size(); i++) {
            System.out.println("%d° Comando = %s". formatted(i+1, historicoComandos.get(i)));
        }
        System.out.print("\n");
    }

}
