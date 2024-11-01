package GerenciamentodeQuartos;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
	private List<quartosReserva> quartos;

	public Hotel() {
		this.quartos = new ArrayList<>();

	}

	public void cadastrarQuarto(String numero, String tipo, int capacidade, double preco) {
		quartosReserva novoQuarto = new quartosReserva(numero, tipo, capacidade, preco);
		quartos.add(novoQuarto);
		System.out.println("Quarto " + numero + " cadastrado com sucesso.");

	}

	public void listarQuartosDisponiveis() {
		System.out.println("Quartos Disponiveis:");
		for (quartosReserva quarto : quartos) {
			if (quarto.getStatus().equals("Disponivel")) {
				quarto.listar();
			}
		}
	}

	public void atualizarStatusQuarto(String numero, String novoStatus) {
		for (quartosReserva quarto : quartos) {
			if (quarto.getNumero().equals(numero)) {
				quarto.atualizarStatus(novoStatus);
				return;

			}
		}
		System.out.println("Quarto não encontrado. ");
	}
}
