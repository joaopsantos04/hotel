package GerenciamentosdeReserva;

import java.util.ArrayList;
import java.util.List;

public class Quarto {
    private int numero;
    private String tipo; 
    private boolean disponivel;
    private List<Reserva> reservas;

    public Quarto(int numero, String tipo) {
        this.numero = numero;
        this.tipo = tipo;
        this.disponivel = true;
        this.reservas = new ArrayList<>();
    }

    public int getNumero() {
        return numero;
    }

    public String getTipo() {
        return tipo;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void adicionarReserva(Reserva reserva) {
        reservas.add(reserva);
        setDisponivel(false);
    }

    public void cancelarReserva(Reserva reserva) {
        reservas.remove(reserva);
        if (reservas.isEmpty()) {
            setDisponivel(true);
        }
    }
}