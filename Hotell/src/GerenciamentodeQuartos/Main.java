package GerenciamentodeQuartos;

public class Main {

	public static void main(String[] args) {
		Hotel hotel = new Hotel();

		// cadastrar quarto
		hotel.cadastrarQuarto("66", "Casal", 2, 150.00);
		

		// listar quarto disponivel
		hotel.listarQuartosDisponiveis();

		// atualizar status de quarto
		hotel.atualizarStatusQuarto("66", "Disponivel");

		// listar quartos disponiveis novamente
		hotel.listarQuartosDisponiveis();

	}

}
