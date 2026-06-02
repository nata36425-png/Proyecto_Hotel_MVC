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
public class Habitacion_doble extends Habitacion{

    public Habitacion_doble() {
    }

    public Habitacion_doble(int Numero, double precioPorNoche, String Tipo, boolean Disponible) {
        super(Numero, precioPorNoche, Tipo, Disponible);
    }
    
    @Override
    public double calcularCosto(int noches) {
        return (getPrecioPorNoche() * noches) + 50000;
    }

    @Override
    public String mostrarInformacion() {
        return "Habitación Doble\n" +
               super.mostrarInformacion();
    }  
}
