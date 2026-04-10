package cadastroDePessoas;

import java.util.ArrayList;

public class CadastroPessoas {
    private ArrayList<Pessoa> pessoas = new ArrayList<>();

    public void adicionarPessoa(Pessoa pessoa) {
        this.pessoas.add(pessoa);
    }

    public void listarPessoas() {
        if (pessoas.isEmpty()) {
            System.out.println("\nNenhuma pessoa cadastrada no sistema.");
        } else {
            System.out.println("\n----------- PESSOAS CADASTRADAS -----------");
            for (Pessoa p : pessoas) {
                System.out.println(p);
            }
            System.out.println("-------------------------------------------");
        }
    }

    public Pessoa buscarPorNome(String nome) {
        for (Pessoa p : pessoas) {
            if (p.getNome().equalsIgnoreCase(nome)) {
                return p;
            }
        }
        return null;
    }

    public boolean removerPorNome(String nome) {
        for (int i = 0; i < pessoas.size(); i++) {
            if (pessoas.get(i).getNome().equalsIgnoreCase(nome)) {
                pessoas.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean estaVazio() {
        return pessoas.isEmpty();
    }

    public boolean atualizarPessoa(String nomeAtual, String novoNome, int novaIdade, String novoEmail) {
        for (Pessoa p : pessoas) {
            if (p.getNome().equalsIgnoreCase(nomeAtual)) {
                p.setNome(novoNome);
                p.setIdade(novaIdade);
                p.setEmail(novoEmail);
                return true;
            }
        }
        return false;
    }
}