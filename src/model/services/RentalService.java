package model.services;

import java.time.Duration;

import model.entities.CarRental;
import model.entities.Invoice;

public class RentalService {

    // Preço por hora de locação
    private Double pricePerHour;
    // Preço por dia de locação
    private Double pricePerDay;

    // Serviço responsável pelo cálculo de impostos
    private TaxService taxService;

    /**
     * Construtor com parâmetros.
     * 
     * @param pricePerHour Preço da locação por hora.
     * @param pricePerDay Preço da locação por dia.
     * @param taxService Serviço de cálculo de impostos.
     */
    public RentalService(Double pricePerHour, Double pricePerDay, TaxService taxService) {        
        this.pricePerHour = pricePerHour;
        this.pricePerDay = pricePerDay;
        this.taxService = taxService;
    }
    
    /**
     * Processa a nota fiscal (Invoice) para a locação de carro.
     * 
     * @param carRental Instância de CarRental contendo os dados da locação.
     */
    public void processInvoice(CarRental carRental) {
        
        // Calcula a duração da locação em minutos
        double minutes = Duration.between(carRental.getStart(), carRental.getFinish()).toMinutes();
        // Converte a duração para horas
        double hours = minutes / 60.0;

        double basicPayment;
        // Define o pagamento básico com base na duração: até 12 horas cobra por hora, acima disso por dia
        if (hours <= 12) {
            basicPayment = pricePerHour * Math.ceil(hours); // Arredonda para cima as horas
        } else {
            basicPayment = pricePerDay * Math.ceil(hours / 24.0); // Arredonda para cima os dias
        }

        // Calcula o imposto baseado no pagamento básico
        double tax = taxService.tax(basicPayment);

        // Define a nota fiscal na locação com o pagamento básico e o imposto
        carRental.setInvoice(new Invoice(basicPayment, tax));
    }
}
