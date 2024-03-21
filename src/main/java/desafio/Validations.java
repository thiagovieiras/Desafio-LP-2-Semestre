package desafio;

import java.util.List;

public class Validations {
    
    public String validarNome(String nome) {
        if (nome.isEmpty() || nome.trim().isEmpty() || nome.length() < 2) {
            System.out.println("\nNome inválido, o nome deve ter pelo menos 2 caracteres, excluindo espaços e símbolos!\n");
            return null;
        }
        StringBuilder novoNome = refatorarNome(nome.split(" "));
        return novoNome.toString().toUpperCase();
    }

    static StringBuilder refatorarNome(String[] nomes) {
        StringBuilder novoNome = new StringBuilder();
        for (int i = 0; i < nomes.length; i++) {
            if (nomes[i].equals("")) continue;
            else if (i+1 == nomes.length) novoNome.append(nomes[i]); 
            else novoNome.append(nomes[i].trim() + " ");
        }
        return novoNome;
    }
    
    public Boolean validarMeta(String meta) {
        if (meta.isEmpty() || meta.trim().isEmpty()) {
            System.out.println("Meta inválida, a meta deve conter ao menos um caracter.\n");
            return false;
        }
        return true;
    }

    static Boolean validarCofre(Cofrinho cofreUsuario) {
        if (cofreUsuario == null) {
            Limpar.terminal();
            System.out.println("Não é possivel realizar essa tarefa pois não existe cofre definido!\n");
            return false;
        }
        return true;
    }

    static Boolean validarPoupanca(Cofrinho cofre) {
        if (cofre.poupado == null) {
            Limpar.terminal();
            System.out.println("Não é possivel realizar essa tarefa pois não existe valor poupado!\n");
            return false;
        }
        return true;
    }

    static List<Cofrinho> verificarListaCofre(List<Cofrinho> listaCofre) {
        if (listaCofre.size() < 1) {
            System.out.println("Nenhum cofre definido ainda! Por favor defina um cofre antes.\n");
            return null;
        }
        return listaCofre;
    }
}
