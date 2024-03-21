package desafio;

import java.util.concurrent.ThreadLocalRandom;

public class Mensagem {

    static void quebrado(String metaCofre) {
        System.out.println("Não é possível realizar essa operação pois o cofre '%s' está quebrado.".formatted(metaCofre));
    }

    static void mostrarOpcoes() {
        System.out.println("""
            \n[0] - Voltar.
            [1] - Definir cofre. 
            [2] - Selecionar cofre.
            [3] - Definir meta para o cofre.
            [4] - Depositar valor ao cofre.
            [5] - Agitar cofre.
            [6] - Quebrar cofre.
            [7] - Quebrar todos cofres.
            [8] - Ver saldo do cofre.
            [9] - Ver saldo total.
            [S] - Sacar.
            [R] - Renomear.
            [H] - Histórico.""");
    }

    static void elogiosAleatorios() {
        int n = ThreadLocalRandom.current().nextInt(1, 9);

        switch (n) {
            case 1:
                System.out.println("Certo!");
                break;
            case 2:
                System.out.println("Muito bem!");
                break;
            case 3:
                System.out.println("Perfeito!");
                break;
            case 4:
                System.out.println("Excelente!");
                break;
            case 5:
                System.out.println("Ótimo!");
                break;
            case 6:
                System.out.println("Legal!");
                break;
            case 7:
                System.out.println("Maravilha!");
                break;
            case 8:
                System.out.println("Bem!");
                break;
        }
    }

    void easterEgg() {
        int tema = ThreadLocalRandom.current().nextInt(0, 5);
        int opções = ThreadLocalRandom.current().nextInt(0, 21);

        switch (tema) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
        
            default:
                break;
        }
    }
}
