package GerenciamentodeHospedes;

import java.util.ArrayList;
import java.util.List;

public class Hospede {
    private String nome;
    private String cpf;
    private String dataNascimento;
    private String endereco;
    private String numTelefone;
    private List<Estadia> historicoEstadias;

    public Hospede(String nome, String cpf, String dataNascimento, String endereco, String numTelefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
        this.numTelefone = numTelefone;
        this.historicoEstadias = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void adicionarEstadia(Estadia estadia) {
        this.historicoEstadias.add(estadia);
    }

    public void visualizarHistorico() {
        System.out.println("Histórico de estadias de " + nome + ":");
        if (historicoEstadias.isEmpty()) {
            System.out.println("Nenhuma estadia registrada.");
        } else {
            for (Estadia estadia : historicoEstadias) {
                System.out.println(estadia);
            }
        }
    }

    public void editarDados(String nome, String cpf, String dataNascimento, String endereco, String numTelefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
        this.numTelefone = numTelefone;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", CPF: " + cpf + ", Data de Nascimento: " + dataNascimento + ", Endereço: " + endereco + ", Telefone: " + numTelefone;
    }
}

