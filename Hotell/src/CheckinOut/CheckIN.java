package CheckinOut;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

class Quarto {
    private int numero;
    private boolean ocupado;
    private LocalDate dataCheckIn;
    private double precoPorDia;

    public Quarto(int numero, double precoPorDia) {
        this.numero = numero;
        this.precoPorDia = precoPorDia;
        this.ocupado = false;
    }

    public void checkIn(LocalDate dataCheckIn) {
        if (!ocupado) {
            this.ocupado = true;
            this.dataCheckIn = dataCheckIn;
            System.out.println("Check-in realizado com sucesso no quarto " + numero + ".");
            System.out.println("O quarto " + numero + " agora está ocupado.");
        } else {
            System.out.println("O quarto " + numero + " já está ocupado.");
        }
    }

    public void checkOut(LocalDate dataCheckOut) {
        if (ocupado) {
            long diasEstadia = ChronoUnit.DAYS.between(dataCheckIn, dataCheckOut);
            double valorTotal = diasEstadia * precoPorDia;
            System.out.println("Check-out realizado com sucesso no quarto " + numero + ".");
            System.out.println("Total de dias: " + diasEstadia + ". Valor total: R$ " + valorTotal);
            ocupado = false; 
            System.out.println("O quarto " + numero + " agora está disponível.");
        } else {
            System.out.println("O quarto " + numero + " já está disponível.");
        }
    }

    public boolean isOcupado() {
        return ocupado;
    }
}

public class CheckIN {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        
        System.out.println("Digite o número do quarto: ");
        int numeroQuarto = scanner.nextInt();
        scanner.nextLine(); 

        System.out.println("Digite o preço por dia do quarto: ");
        double precoPorDia = scanner.nextDouble();
        scanner.nextLine(); 

        Quarto quarto = new Quarto(numeroQuarto, precoPorDia);


        System.out.println("Digite a data de check-in (dd/MM/yyyy): ");
        String dataCheckInStr = scanner.nextLine();
        LocalDate dataCheckIn = LocalDate.parse(dataCheckInStr, formatter);
        quarto.checkIn(dataCheckIn);

     
        System.out.println("Digite a data de check-out (dd/MM/yyyy): ");
        String dataCheckOutStr = scanner.nextLine();
        LocalDate dataCheckOut = LocalDate.parse(dataCheckOutStr, formatter);
        quarto.checkOut(dataCheckOut);

        scanner.close();
    }
}

