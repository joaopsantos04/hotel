package GerenciamentodeQuartos;

public class quartosReserva implements Gerenciavel {
	private String numero;
	private String tipo;
	private int capacidade;
	private double preco;
	private String status;

	public static final String STATUS_DISPONIVEL = "disponivel";
	public static final String STATUS_OCUPADO = "ocupado";
	public static final String STATUS_EM_MANUNTENCAO = "em mauntenção";

	public quartosReserva(String numero, String tipo, int capacidade, double preco) {
		this.numero = numero;
		this.tipo = tipo;
		this.capacidade = capacidade;
		this.preco = preco;
		this.status = STATUS_DISPONIVEL;

	}

	public String getNumero() {
		return numero;
	}

	public String getTipo() {
		return tipo;
	}

	public int getCapacidade() {
		return capacidade;
	}

	public double getPreco() {
		return preco;
	}

	public String getStatus() {
		return status;
	}

	@Override
	public void cadastrar() {

	}

	@Override
	public void listar() {
		System.out.println(this);

	}

	@Override
	public void atualizarStatus(String novoStatus) {
		this.status = novoStatus;
		System.out.println("Status do quarto (" + numero + ") atualizado para " + novoStatus);
	}

	@Override
	public String toString() {
		return "Quarto " + numero + ": Tipo=" + tipo + ", Capacidade=" + capacidade + ", Preço=" + preco + ", Status="
				+ status;
	}
}
