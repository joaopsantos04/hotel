package GerenciamentodeFuncionario;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GerenciadorFuncionarios {
    private List<Funcionario> funcionarios;

    public GerenciadorFuncionarios() {
        this.funcionarios = new ArrayList<>();
    }

   
    public void cadastrarFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
        System.out.println("Funcionário cadastrado com sucesso!");
    }

    
    public void editarFuncionario(String cpf) {
        for (Funcionario func : funcionarios) {
            if (func.getCpf().equals(cpf)) {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Digite o novo nome:");
                func.setNome(scanner.nextLine());
                System.out.println("Digite o novo cargo:");
                func.setCargo(scanner.nextLine());
                System.out.println("Digite o novo salário por hora:");
                func.setSalarioPorHora(scanner.nextDouble());
                scanner.nextLine();  
                System.out.println("Digite o novo turno:");
                func.setTurno(scanner.nextLine());
                System.out.println("Informações atualizadas com sucesso!");
                return;
            }
        }
        System.out.println("Funcionário não encontrado.");
    }

    
    public void registrarHoras(String cpf, double horas) {
        for (Funcionario func : funcionarios) {
            if (func.getCpf().equals(cpf)) {
                func.registrarHoras(horas);
                System.out.println("Horas registradas com sucesso!");
                return;
            }
        }
        System.out.println("Funcionário não encontrado.");
    }

    
    public void calcularSalario(String cpf) {
        for (Funcionario func : funcionarios) {
            if (func.getCpf().equals(cpf)) {
                double salario = func.calcularSalario();
                System.out.println("Salário calculado: R$ " + salario);
                return;
            }
        }
        System.out.println("Funcionário não encontrado.");
    }

    public void listarFuncionarios() {
        for (Funcionario func : funcionarios) {
            System.out.println(func);
        }
    }
}

