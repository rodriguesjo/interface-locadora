package model.entities;

import java.time.LocalDateTime;

public class CarRental {

    // Data e hora do início da locação
    private LocalDateTime start;
    // Data e hora do término da locação
    private LocalDateTime finish;

    // Veículo associado à locação
    private Vehicle vehicle;
    // Nota fiscal gerada para a locação
    private Invoice invoice;   

    /**
     * Construtor com parâmetros.
     * 
     * @param start Data e hora do início da locação.
     * @param finish Data e hora do término da locação.
     * @param vehicle Veículo alugado.
     */
    public CarRental(LocalDateTime start, LocalDateTime finish, Vehicle vehicle) {        
        this.start = start;
        this.finish = finish;
        this.vehicle = vehicle;        
    }

    // Getter para obter a data e hora do início da locação
    public LocalDateTime getStart() {
        return start;
    }

    // Setter para atualizar a data e hora do início da locação
    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    // Getter para obter a data e hora do término da locação
    public LocalDateTime getFinish() {
        return finish;
    }

    // Setter para atualizar a data e hora do término da locação
    public void setFinish(LocalDateTime finish) {
        this.finish = finish;
    }

    // Getter para obter o veículo associado à locação
    public Vehicle getVehicle() {
        return vehicle;
    }

    // Setter para atualizar o veículo associado à locação
    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    // Getter para obter a nota fiscal da locação
    public Invoice getInvoice() {
        return invoice;
    }

    // Setter para definir ou atualizar a nota fiscal da locação
    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }
}
