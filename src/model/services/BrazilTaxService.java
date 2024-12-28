package model.services;

/**
 * Classe que implementa a TaxService para calcular impostos no Brasil.
 */
public class BrazilTaxService implements TaxService {

    /**
     * Calcula o imposto com base no pagamento básico.
     * 
     * @param basicPayment o valor base para o cálculo do imposto.
     * @return o valor do imposto calculado.
     */
    @Override
    public double tax(double basicPayment) {
        if (basicPayment <= 100.0) {
            return basicPayment * 0.20; // Imposto de 20% para valores até 100
        } else {
            return basicPayment * 0.15; // Imposto de 15% para valores acima de 100
        }
    }
}
