package desafio;

import java.util.List;

public class Validations {
    
    static String validarNome(String nome) {
        if (nome.isEmpty() || nome.trim().isEmpty() || nome.length() < 3) {
            System.out.println("Nome inválido, o nome deve ter pelo menos 3 caracteres, excluindo espaços e símbolos!");
            Main.nomear();
            return null;
        }
        StringBuilder novoNome = refatorarNome(nome.split(" "));
        return nome = novoNome.toString();
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

    static String validarMeta(String meta) {
        if (meta.isEmpty() || meta.trim().isEmpty()) {
            System.out.println("Meta inválida, a meta deve conter ao menos um caracter.\n");
            return null;
        }
        return meta;
    }

    static List<Cofrinho> verificarListaCofre(List<Cofrinho> listaCofre) {
        if (listaCofre.size() < 1) {
            System.out.println("Nenhum cofre definido ainda! Por favor defina um cofre antes.");
            Mensagem.mostrarOpcao1();
            return null;
        }
        return listaCofre;
    }

}
