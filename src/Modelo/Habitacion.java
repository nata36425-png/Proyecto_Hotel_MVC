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
public class Habitacion {
    
    private int Numero;
    private double precioPorNoche;
    private String Tipo;
    private boolean Disponible;

    public Habitacion() {
    }

    public Habitacion(int Numero, double precioPorNoche, String Tipo, boolean Disponible) {
        this.Numero = Numero;
        this.precioPorNoche = precioPorNoche;
        this.Tipo = Tipo;
        this.Disponible = Disponible;
    }

    public int getNumero() {
        return Numero;
    }

    public void setNumero(int Numero) {
        this.Numero = Numero;
    }

    public double getPrecioPorNoche() {
        return precioPorNoche;
    }

    public void setPrecioPorNoche(double precioPorNoche) {
        this.precioPorNoche = precioPorNoche;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }

    public boolean isDisponible() {
        return Disponible;
    }

    public void setDisponible(boolean Disponible) {
        this.Disponible = Disponible;
    }
    
    public double calcularCosto(int noches) {
        return precioPorNoche * noches;
    }
    
   public String mostrarInformacion() {
        return "Habitación #" + this.Numero +
               "\nPrecio: " + this.precioPorNoche +
               "\nDisponible: " + this.Disponible;
    }
   
}
