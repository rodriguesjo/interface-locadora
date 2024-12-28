package application;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import model.entities.CarRental; // Importa a classe CarRental, que representa o aluguel de um carro
import model.entities.Vehicle; // Importa a classe Vehicle, que representa um veículo
import model.services.BrazilTaxService; // Importa a classe BrazilTaxService, que calcula o imposto
import model.services.RentalService; // Importa a classe RentalService, que gerencia o aluguel e fatura

public class Program {

    public static void main(String[] args) {
        
        Locale.setDefault(Locale.US); // Define o padrão de localidade para US (para formato de moeda, por exemplo)
        Scanner sc = new Scanner(System.in); // Cria o objeto Scanner para leitura dos dados inseridos pelo usuário
        
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"); // Define o formato para data e hora (dd/MM/yyyy HH:mm)
        
        // Solicita os dados do aluguel
        System.out.println("Enter com os dados do aluguel ");
        System.out.print("Modelo do carro: ");
        String carModel = sc.nextLine(); // Lê o modelo do carro
        System.out.print("Retirada (dd/MM/yyyy HH:mm): ");
        LocalDateTime start = LocalDateTime.parse(sc.nextLine(), fmt); // Lê a data e hora de retirada e converte para LocalDateTime
        System.out.print("Devolução (dd/MM/yyyy HH:mm): ");
        LocalDateTime finish = LocalDateTime.parse(sc.nextLine(), fmt); // Lê a data e hora de devolução e converte para LocalDateTime
        
        // Cria um objeto CarRental com os dados de início, fim e modelo do carro
        CarRental cr = new CarRental(start, finish, new Vehicle(carModel));
        
        // Solicita o preço por hora e por dia para o aluguel
        System.out.print("Entre com o preço por hora: ");
        double pricePerHour = sc.nextDouble();
        System.out.print("Entre com o preço por dia: ");
        double pricePerDay = sc.nextDouble();
        
        // Cria o serviço de aluguel, passando o preço por hora, preço por dia e o serviço de imposto (BrazilTaxService)
        RentalService rentalService = new RentalService(pricePerHour, pricePerDay, new BrazilTaxService());
        
        // Processa a fatura do aluguel com base nos dados do aluguel
        rentalService.processInvoice(cr);
        
        // Exibe os detalhes da fatura
        System.out.println("FATURA: ");
        System.out.println("Veículo: " + cr.getVehicle().getModel());
        System.out.println("Pagamento básico: " + String.format("%.2f", cr.getInvoice().getBasicPayment())); // Exibe o pagamento básico
        System.out.println("Imposto: " + String.format("%.2f", cr.getInvoice().getTax())); // Exibe o valor do imposto
        System.out.println("Pagamento total: " + String.format("%.2f", cr.getInvoice().getTotalPayment())); // Exibe o pagamento total (básico + imposto)
        
        sc.close(); // Fecha o scanner para liberar recursos

    }

}
