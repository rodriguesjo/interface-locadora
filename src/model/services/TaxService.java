package model.services;

/**
 * Interface TaxService define o contrato para serviços de cálculo de impostos.
 * Qualquer classe que implementar esta interface deve fornecer uma implementação
 * para o método de cálculo do imposto.
 */
public interface TaxService {

    /**
     * Método para calcular o imposto com base no pagamento básico.
     * 
     * @param basicPayment o valor base sobre o qual o imposto será calculado.
     * @return o valor do imposto calculado.
     */
    double tax(double basicPayment);
}
