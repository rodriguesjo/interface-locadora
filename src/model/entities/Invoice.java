package model.entities;

public class Invoice {

    // Valor básico do pagamento
    private Double basicPayment;
    // Valor do imposto
    private Double tax;

    // Construtor para inicializar os valores de pagamento básico e imposto
    public Invoice(Double basicPayment, Double tax) {        
        this.basicPayment = basicPayment;
        this.tax = tax;
    }

    // Getter para obter o valor básico do pagamento
    public Double getBasicPayment() {
        return basicPayment;
    }

    // Setter para atualizar o valor básico do pagamento
    public void setBasicPayment(Double basicPayment) {
        this.basicPayment = basicPayment;
    }

    // Getter para obter o valor do imposto
    public Double getTax() {
        return tax;
    }

    // Setter para atualizar o valor do imposto
    public void setTax(Double tax) {
        this.tax = tax;
    }

    /**
     * Calcula o valor total do pagamento.
     * 
     * @return Soma do pagamento básico com o imposto.
     */
    public Double getTotalPayment() {
        return getBasicPayment() + getTax();
    }
}
