package GerenciamentodeHospedes;

public class Estadia {
    private String quarto;
    private String dataCheckIn;
    private String dataCheckOut;
    private int duracao;

    public Estadia(String quarto, String dataCheckIn, String dataCheckOut, int duracao) {
        this.quarto = quarto;
        this.dataCheckIn = dataCheckIn;
        this.dataCheckOut = dataCheckOut;
        this.duracao = duracao;
    }

    @Override
    public String toString() {
        return "Quarto: " + quarto + ", Check-in: " + dataCheckIn + ", Check-out: " + dataCheckOut + ", Duração: " + duracao + " dias";
    }
}

