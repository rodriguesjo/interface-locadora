package model.entities;

public class Vehicle {

    // Atributo para armazenar o modelo do veículo
    private String model; 

    // Construtor que permite inicializar o veículo com um modelo
    public Vehicle(String model) {        
        this.model = model;
    }

    // Getter para obter o modelo do veículo
    public String getModel() {
        return model;
    }

    // Setter para atualizar o modelo do veículo
    public void setModel(String model) {
        this.model = model;
    }
    
}
