package GerenciamentosdeReserva;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SistemaReservas sistema = new SistemaReservas();
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Criar Reserva");
            System.out.println("2. Cancelar Reserva");
            System.out.println("3. Verificar Disponibilidade");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao;

            try {
                opcao = scanner.nextInt();
                scanner.nextLine(); 

                switch (opcao) {
                    case 1:
                        System.out.print("Nome do hóspede: ");
                        String nome = scanner.nextLine();
                        System.out.print("Contato do hóspede: ");
                        String contato = scanner.nextLine();
                        System.out.print("Número do quarto: ");
                        int numeroQuarto = scanner.nextInt();
                        System.out.print("Data de entrada (YYYY-MM-DD): ");
                        LocalDate dataEntrada = LocalDate.parse(scanner.next());
                        System.out.print("Data de saída (YYYY-MM-DD): ");
                        LocalDate dataSaida = LocalDate.parse(scanner.next());

                        sistema.criarReserva(nome, contato, numeroQuarto, dataEntrada, dataSaida);
                        break;

                    case 2:
                        // Cancelar Reserva
                        System.out.print("Número do quarto para cancelar: ");
                        numeroQuarto = scanner.nextInt();
                        System.out.print("Data de entrada da reserva (YYYY-MM-DD): ");
                        dataEntrada = LocalDate.parse(scanner.next());
                        sistema.cancelarReserva(numeroQuarto, dataEntrada);
                        break;

                    case 3:
                        // Verificar Disponibilidade
                        System.out.print("Data de entrada (YYYY-MM-DD): ");
                        dataEntrada = LocalDate.parse(scanner.next());
                        System.out.print("Data de saída (YYYY-MM-DD): ");
                        dataSaida = LocalDate.parse(scanner.next());
                        sistema.verificarDisponibilidade(dataEntrada, dataSaida);
                        break;

                    case 4:
                        // Sair
                        System.out.println("Saindo...");
                        scanner.close();
                        return;

                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Por favor, insira um número válido.");
                scanner.nextLine(); // Limpa o buffer para a próxima entrada
            } catch (DateTimeParseException e) {
                System.out.println("Formato de data inválido. Por favor, use o formato YYYY-MM-DD.");
            } catch (Exception e) {
                System.out.println("Ocorreu um erro inesperado: " + e.getMessage());
            }
        }
    }
}


