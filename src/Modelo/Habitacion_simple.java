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
public class Habitacion_simple extends Habitacion {

    public Habitacion_simple() {
    }

    public Habitacion_simple(int Numero, double precioPorNoche, String Tipo, boolean Disponible) {
        super(Numero, precioPorNoche, Tipo, Disponible);
    }

    @Override
    public double calcularCosto(int noches) {
        return getPrecioPorNoche() * noches; 
    }
    
    @Override
    public String mostrarInformacion() {
        return "Habitación Simple\n" +
               super.mostrarInformacion();
    }  
}
