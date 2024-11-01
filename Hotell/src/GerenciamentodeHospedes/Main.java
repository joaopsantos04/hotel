package GerenciamentodeHospedes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Hospede> hospedes = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;
        do {
            System.out.println("Menu:");
            System.out.println("1. Cadastrar novo hóspede");
            System.out.println("2. Visualizar histórico de estadias");
            System.out.println("3. Editar informações do hóspede");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir nova linha

            switch (opcao) {
                case 1:
                    cadastrarHospede();
                    break;
                case 2:
                    if (hospedes.isEmpty()) {
                        System.out.println("Nenhum hóspede cadastrado. Cadastre um hóspede primeiro.");
                    } else {
                        visualizarHistorico();
                    }
                    break;
                case 3:
                    if (hospedes.isEmpty()) {
                        System.out.println("Nenhum hóspede cadastrado para editar. Cadastre um hóspede primeiro.");
                    } else {
                        editarHospede();
                    }
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);
    }

    private static void cadastrarHospede() {
        System.out.print("Digite o nome: ");
        String nome = scanner.nextLine();

        System.out.print("Digite o CPF: ");
        String cpf = scanner.nextLine();

        System.out.print("Digite a data de nascimento (dd/mm/aaaa): ");
        String dataNascimento = scanner.nextLine();

        System.out.print("Digite o endereço: ");
        String endereco = scanner.nextLine();

        System.out.print("Digite o número de telefone: ");
        String numTelefone = scanner.nextLine();

        hospedes.add(new Hospede(nome, cpf, dataNascimento, endereco, numTelefone));
        System.out.println("Hóspede cadastrado com sucesso!");
    }

    private static void visualizarHistorico() {
        System.out.print("Digite o CPF do hóspede: ");
        String cpf = scanner.nextLine();

        for (Hospede hospede : hospedes) {
            if (hospede.getCpf().equals(cpf)) {
                hospede.visualizarHistorico();
                return;
            }
        }
        System.out.println("Hóspede não encontrado.");
    }

    private static void editarHospede() {
        System.out.print("Digite o CPF do hóspede que deseja editar: ");
        String cpf = scanner.nextLine();

        for (Hospede hospede : hospedes) {
            if (hospede.getCpf().equals(cpf)) {
                System.out.print("Digite o novo nome: ");
                String novoNome = scanner.nextLine();

                System.out.print("Digite o novo CPF: ");
                String novoCpf = scanner.nextLine();

                System.out.print("Digite a nova data de nascimento (dd/mm/aaaa): ");
                String novaDataNascimento = scanner.nextLine();

                System.out.print("Digite o novo endereço: ");
                String novoEndereco = scanner.nextLine();

                System.out.print("Digite o novo número de telefone: ");
                String novoNumTelefone = scanner.nextLine();

                hospede.editarDados(novoNome, novoCpf, novaDataNascimento, novoEndereco, novoNumTelefone);
                System.out.println("Dados do hóspede atualizados com sucesso!");
                return;
            }
        }
        System.out.println("Hóspede não encontrado.");
    }
}


