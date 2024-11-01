package GerenciamentosdeReserva;

public class Hospede {
    private String nome;
    private String contato;

    public Hospede(String nome, String contato) {
        this.nome = nome;
        this.contato = contato;
    }

    public String getNome() {
        return nome;
    }

    public String getContato() {
        return contato;
    }
}

