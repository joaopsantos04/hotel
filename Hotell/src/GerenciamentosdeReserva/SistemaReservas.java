package GerenciamentosdeReserva;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SistemaReservas {
    private List<Quarto> quartos;
    private List<Reserva> reservas;

    public SistemaReservas() {
        quartos = new ArrayList<>();
        reservas = new ArrayList<>();
        // Adicionando alguns quartos de exemplo
        quartos.add(new Quarto(101, "individual"));
        quartos.add(new Quarto(102, "duplo"));
        quartos.add(new Quarto(201, "suíte"));
    }

    public void criarReserva(String nome, String contato, int numeroQuarto, LocalDate dataEntrada, LocalDate dataSaida) {
        Quarto quarto = encontrarQuarto(numeroQuarto);
        if (quarto != null && quarto.isDisponivel() && verificarDisponibilidade(quarto, dataEntrada, dataSaida)) {
            Hospede hospede = new Hospede(nome, contato);
            Reserva reserva = new Reserva(hospede, quarto, dataEntrada, dataSaida);
            quarto.adicionarReserva(reserva);
            reservas.add(reserva);
            System.out.println("Reserva criada com sucesso!");
        } else {
            System.out.println("Quarto não disponível para essas datas.");
        }
    }

    public void cancelarReserva(int numeroQuarto, LocalDate dataEntrada) {
        for (Reserva reserva : reservas) {
            if (reserva.getQuarto().getNumero() == numeroQuarto && reserva.getDataEntrada().equals(dataEntrada)) {
                reserva.cancelar();
                reservas.remove(reserva);
                System.out.println("Reserva cancelada com sucesso!");
                return;
            }
        }
        System.out.println("Reserva não encontrada.");
    }

    public void verificarDisponibilidade(LocalDate dataEntrada, LocalDate dataSaida) {
        System.out.println("Quartos disponíveis:");
        for (Quarto quarto : quartos) {
            if (quarto.isDisponivel() && verificarDisponibilidade(quarto, dataEntrada, dataSaida)) {
                System.out.println("Quarto " + quarto.getNumero() + " (" + quarto.getTipo() + ")");
            }
        }
    }

    private Quarto encontrarQuarto(int numero) {
        for (Quarto quarto : quartos) {
            if (quarto.getNumero() == numero) {
                return quarto;
            }
        }
        return null;
    }

    private boolean verificarDisponibilidade(Quarto quarto, LocalDate dataEntrada, LocalDate dataSaida) {
        for (Reserva reserva : quarto.getReservas()) {
            if (dataEntrada.isBefore(reserva.getDataSaida()) && dataSaida.isAfter(reserva.getDataEntrada())) {
                return false; // O quarto está reservado nesse intervalo
            }
        }
        return true; // O quarto está disponível
    }
}
