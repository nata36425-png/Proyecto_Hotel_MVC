/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author natam
 */
public class Habitacion_suit extends Habitacion{

    public Habitacion_suit() {
    }

    public Habitacion_suit(int Numero, double precioPorNoche, String Tipo, boolean Disponible) {
        super(Numero, precioPorNoche, Tipo, Disponible);
    }
    
     @Override
    public double calcularCosto(int noches) {
        return (getPrecioPorNoche() * noches) + 100000;
    }

    @Override
    public String mostrarInformacion() {
        return "Suite\n" +
               super.mostrarInformacion();
    }
    
}
