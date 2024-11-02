package GerenciamentodeFuncionario;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GerenciadorFuncionarios gerenciador = new GerenciadorFuncionarios();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Cadastrar funcionário");
            System.out.println("2. Editar informações do funcionário");
            System.out.println("3. Registrar horas de trabalho");
            System.out.println("4. Calcular salário");
            System.out.println("5. Listar todos os funcionários");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Digite o nome:");
                    String nome = scanner.nextLine();
                    System.out.println("Digite o CPF:");
                    String cpf = scanner.nextLine();
                    System.out.println("Digite o cargo:");
                    String cargo = scanner.nextLine();
                    System.out.println("Digite o salário por hora:");
                    double salario = scanner.nextDouble();
                    scanner.nextLine(); 
                    System.out.println("Digite o turno:");
                    String turno = scanner.nextLine();

                    Funcionario funcionario = new Funcionario(nome, cpf, cargo, salario, turno);
                    gerenciador.cadastrarFuncionario(funcionario);
                    break;
                case 2:
                    System.out.println("Digite o CPF do funcionário para editar:");
                    String cpfEdit = scanner.nextLine();
                    gerenciador.editarFuncionario(cpfEdit);
                    break;
                case 3:
                    System.out.println("Digite o CPF do funcionário para registrar horas:");
                    String cpfHoras = scanner.nextLine();
                    System.out.println("Digite a quantidade de horas:");
                    double horas = scanner.nextDouble();
                    gerenciador.registrarHoras(cpfHoras, horas);
                    break;
                case 4:
                    System.out.println("Digite o CPF do funcionário para calcular o salário:");
                    String cpfSalario = scanner.nextLine();
                    gerenciador.calcularSalario(cpfSalario);
                    break;
                case 5:
                    gerenciador.listarFuncionarios();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);

        scanner.close();
    }
}

