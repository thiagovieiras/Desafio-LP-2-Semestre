package desafio;

import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {

    static Scanner scanner = new Scanner(System.in);

    static Usuario usuario;
    public static void main(String[] args) {

        Limpar.terminal();

        System.out.println("Olá, tudo bem Usuário?");    
        
        usuario = new Usuario();
        nomear();

        Limpar.terminal();

        while (true) {
            if (desejar() == null) desejar();
            else if (desejar().equals(0)) break;
            else desejar();
        }
        System.out.println("Certo! Até mais, tchau tchau!!");

        

    }

    static void nomear() {
        System.out.println("Qual o seu nome: ");
        String nomeUsuario = scanner.nextLine();
        Validations.validarNome(nomeUsuario);
        usuario.nome = nomeUsuario;
        return;
    }

    static Integer desejar() {
        System.out.println("""
            Certo!
            O que você deseja agora, Sr.%s?""".formatted(usuario.nome));
        Mensagem.mostrarOpcoes();
        String selecionarOpcao = scanner.nextLine();
        Limpar.terminal();
        Integer valor = realizarOpcoes(selecionarOpcao);
        return valor;
    }


    static void definirCofrinho() {
        System.out.println("Qual a meta você deseja atingir com esse cofrinho?");
        String meta = scanner.nextLine();
        if (Validations.validarMeta(meta) == null) definirCofrinho();
        usuario.definirCofrinho(meta);

        System.out.println("\nMuito bem Sr.%s".formatted(usuario.nome));
        System.out.println("Cofre criado com sucesso.");
        System.out.println("O que você deseja fazer agora?");
        return;
    }

    static String[] mostrarCofrinho() {
        Validations.verificarListaCofre(usuario.listaCofrinho);

        String[] numerosCofre = new String[usuario.listaCofrinho.size()];
        System.out.println("Cofre --- Metas");
        for (int i = 0; i < usuario.listaCofrinho.size(); i++) {
            numerosCofre[i] = "%d".formatted(i+1);
            System.out.println("  %d°   -  %s.".formatted(i+1, usuario.listaCofrinho.get(i).meta));
        }
        System.out.println("  0   -  Voltar.");
        return numerosCofre;
    }

    static Integer selecionarCofrinho(String[] numerosCofre) {
        System.out.println("\nSelecione um cofre.\n");
        String selecao = scanner.nextLine();
        
        if (selecao.equals("0")) {
            return 0;
        } else {
            for (int i = 0; i < usuario.listaCofrinho.size(); i++) {
                if (selecao.trim().toLowerCase().equals(usuario.listaCofrinho.get(i).meta.trim().toLowerCase()) || 
                numerosCofre[i].contains(selecao) || 
                numerosCofre[i].contains(selecao+"°")) {
                    usuario.usarCofrinho(usuario.listaCofrinho.get(i).meta);
                    System.out.println("Cofre %d selecionado!".formatted(i+1));
                    return 2;
                }
            }
        }

        System.out.println("Seleção inválida, escreva o número do cofre ou a meta desejada.");
        return realizarOpcoes("2");
    }

    static void definirMetaCofrinho() {
        System.out.println("Qual meta você quer dar ao cofre '%s'!".formatted(usuario.cofrinho.meta));
        String meta = scanner.nextLine();

        if (Validations.validarMeta(meta) == null) definirMetaCofrinho();
        usuario.definirMeta(meta);

        System.out.println("Meta definida com sucesso ao cofre '%s'!".formatted(usuario.cofrinho.meta));
        return;
    }

    static void depositarCofrinho() {
        System.out.println("Digíte o valor que deseja depositar: ");
        System.out.print("R$");
        Double valorDeposito = scanner.nextDouble();
        scanner.nextLine(); // limpa o enter deixado pelo nextDouble();
        usuario.depositarValor(valorDeposito);
        return;
    }

    static Integer realizarOpcoes(String selecionarOpcao) {
        if (selecionarOpcao.trim().equals("0") || selecionarOpcao.toLowerCase().trim().equals("opção0") || selecionarOpcao.toLowerCase().trim().equals("sair")) {
            return 0;
        } else if (selecionarOpcao.trim().equals("1") || selecionarOpcao.toLowerCase().trim().equals("opção1") || selecionarOpcao.toLowerCase().trim().equals("definircofrinho")) {
            System.out.println("\nBem Sr.%s".formatted(usuario.nome));
            definirCofrinho();
            return 1;
        } else if (selecionarOpcao.trim().equals("2") || selecionarOpcao.toLowerCase().trim().equals("opção2") || selecionarOpcao.toLowerCase().trim().equals("selecionarcofrinho")) {
            String[] numerosCofre = mostrarCofrinho();
            return selecionarCofrinho(numerosCofre);
        }
        else if (selecionarOpcao.trim().equals("3") || selecionarOpcao.toLowerCase().trim().equals("opção3") || selecionarOpcao.toLowerCase().trim().equals("definirmetaparaocofrinho")) {
            Limpar.terminal();
            return 3;
        }
        else if (selecionarOpcao.trim().equals("4") || selecionarOpcao.toLowerCase().trim().equals("opção4") || selecionarOpcao.toLowerCase().trim().equals("depositarvaloraocofrinho")) {
            Limpar.terminal();
            depositarCofrinho();
            return 4;
        }
        else if (selecionarOpcao.trim().equals("5") || selecionarOpcao.toLowerCase().trim().equals("opção5") || selecionarOpcao.toLowerCase().trim().equals("agitarcofrinho")) {
            return 5;
        }
        else if (selecionarOpcao.equals("6") || selecionarOpcao.toLowerCase().equals("opção6") || selecionarOpcao.toLowerCase().equals("quebrarcofrinho")) {
            return 6;
        }
        System.out.println("Valor %s incorreto".formatted(selecionarOpcao));
        System.out.println("Escolha uma opção válida.");
        return null; 
    }

}
