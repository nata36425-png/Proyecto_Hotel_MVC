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
   /*
    * Nombre del método: totalHabitaciones
    * Parámetros recibidos: no recibe
    * Tipo de retorno: int
    * Descripción: Obtener el total de las habitaciones
    */
    public int totalHabitaciones() {
        return controladorHabitacion.obtenerHabitaciones().size();
    }
    /*
    * Nombre del método: habitacionesDisponibles
    * Parámetros recibidos: no recibe
    * Tipo de retorno: contador
    * Descripción: mostrar las habitaciones disponibles
    */
    public int habitacionesDisponibles() {

        int contador = 0;

        for(Habitacion h : controladorHabitacion.obtenerHabitaciones()) {

            if(h.isDisponible()) {

                contador++;
            }
        }
        return contador;
    }
    /*
    * Nombre del método: habitacionesOcupadas
    * Parámetros recibidos: no recibe
    * Tipo de retorno: double habitacionesOcupadas
    * Descripción: Mostrar las habitaciones ocupadas
    */
    public int habitacionesOcupadas() {
        return totalHabitaciones() - habitacionesDisponibles();
    }
    /*
    * Nombre del método: porcentajeOcupacion
    * Parámetros recibidos: total habitaciones
    * Tipo de retorno: porcentaje de ocupacion 
    * Descripción: Muestra el procentaje de ocupacion del hotel
    */
    public double porcentajeOcupacion() {

        if(totalHabitaciones() == 0) {
            return 0;
        }
        return (double) habitacionesOcupadas() * 100 / totalHabitaciones();
    }
    /*
    * Nombre del método: informacionHotel
    * Parámetros recibidos: no recibe
    * Tipo de retorno: nombre, ubicacion, total habitaciones, habitaciones ocupadas,
    disponibles y %ocupacion  
    * Descripción: Muestra toda la informacion de ocupacion del hotel
    */
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
    

