/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import Modelo.Habitacion;
import Modelo.Hotel;

/**
 *
 * @author natam
 */
public class Controlador_Hotel {
    
    private Hotel hotel;

    private Controlador_Habitaciones controladorHabitacion;

    public Controlador_Hotel(Hotel hotel, Controlador_Habitaciones controladorHabitacion) {

        this.hotel = hotel;
        this.controladorHabitacion = controladorHabitacion;
    }

   public Controlador_Hotel() {
       
   }

    
    // ==================================
    // TOTAL HABITACIONES
    // ==================================
    public int totalHabitaciones() {

        return controladorHabitacion.obtenerHabitaciones().size();
    }
    // ==================================
    // DISPONIBLES
    // ==================================
    public int habitacionesDisponibles() {

        int contador = 0;

        for(Habitacion h : controladorHabitacion.obtenerHabitaciones()) {

            if(h.isDisponible()) {

                contador++;
            }
        }

        return contador;
    }
    // ==================================
    // OCUPADAS
    // ==================================
    public int habitacionesOcupadas() {

        return totalHabitaciones() - habitacionesDisponibles();
    }
    // ==================================
    // PORCENTAJE OCUPACIÓN
    // ==================================
    public double porcentajeOcupacion() {

        if(totalHabitaciones() == 0) {

            return 0;
        }

        return (double) habitacionesOcupadas() * 100 / totalHabitaciones();
    }
    // ==================================
    // INFORMACIÓN DEL HOTEL
    // ==================================
    public String informacionHotel() {

        return "Hotel: " + hotel.getNombre()
                + "\nUbicación: " + hotel.getUbicacion()
                + "\nHabitaciones: " + totalHabitaciones()
                + "\nDisponibles: " + habitacionesDisponibles()
                + "\nOcupadas: " + habitacionesOcupadas()
                + "\nOcupación: " + porcentajeOcupacion()
                + "%";
    }
}
    

