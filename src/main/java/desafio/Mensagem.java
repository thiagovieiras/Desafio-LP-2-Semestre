package desafio;
public class Mensagem {

    static void quebrado() {
        System.out.println("Não é possível realizar essa operação pois o cofre está quebrado.");
    }

    static void mostrarOpcao1() {
        System.out.println("""
            \nOpção 0 - Voltar.
            Opção 1 - Definir cofrinho.""");
    }

    static void mostrarOpcoes() {
        System.out.println("""
            \nOpção 0 - Voltar.
            Opção 1 - Definir cofrinho. 
            Opção 2 - Selecionar cofrinho.
            Opção 3 - Definir meta para o cofrinho.
            Opção 4 - Depositar valor ao cofrinho.
            Opção 5 - Agitar cofrinho.
            Opção 6 - Quebrar cofrinho.
            Opção para nome - Renomear.""");
    }
}
