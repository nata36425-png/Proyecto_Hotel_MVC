/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Habitacion;
import Modelo.Habitacion_doble;
import Modelo.Habitacion_simple;
import Modelo.Habitacion_suit;

import java.util.ArrayList;

/**
 *
 * @author natam
 */
public class Controlador_Habitaciones {

    private ArrayList<Habitacion> listaHabitaciones;

    public Controlador_Habitaciones() {

        listaHabitaciones = new ArrayList<>();
    }

    /*
    * Nombre del método: registrarHabitacion
    * Parámetros recibidos: Numero, PrecioPorNoche, Tipo, Disponible
    * Tipo de retorno: Habitacion
    * Descripción: Registrar una  habitacion 
     */
    public boolean registrarHabitacion(int numero, double precio, String tipo, boolean disponible) {
        // VALIDAR NÚMERO

        if (numero <= 0) {

            return false;
        }
        // VALIDAR PRECIO
        if (precio <= 0) {

            return false;
        }
        // VALIDAR DUPLICADOS
        for (Habitacion h
                : listaHabitaciones) {

            if (h.getNumero()
                    == numero) {

                return false;
            }
        }
        // POLIMORFISMO

        Habitacion habitacion = null;

        switch (tipo.toLowerCase()) {

            case "simple":

                habitacion = new Habitacion_simple(numero, precio, tipo, disponible);

                break;

            case "doble":

                habitacion = new Habitacion_doble(numero, precio, tipo, disponible);

                break;

            case "suite":

                habitacion = new Habitacion_suit(numero, precio, tipo, disponible);

                break;

            default:

                return false;
        }
        // ESTADO
        habitacion.setDisponible(disponible);
        // AGREGAR
        listaHabitaciones.add(habitacion);
        return true;
    }
    /*
    * Nombre del método: actualizarHabitacion 
    * Parámetros recibidos: numero, nuevoPrecio, nuevoEstado
    * Tipo de retorno: boolean
    * Descripción: actualizar un cliente
    */
    public boolean actualizarHabitacion(int numero, double nuevoPrecio, boolean nuevoEstado) {

        Habitacion habitacion = consultarHabitacion(numero);
        // VALIDAR EXISTENCIA
        if (habitacion == null) {
            return false;
        }
        // VALIDAR PRECIO
        if (nuevoPrecio <= 0) {
            return false;
        }
        // ACTUALIZAR
        habitacion.setPrecioPorNoche(nuevoPrecio);
        habitacion.setDisponible(nuevoEstado);

        return true;
    }
    /*
    * Nombre del método: actualizarEstadoHabitacion
    * Parámetros recibidos: numero, disponible
    * Tipo de retorno: boolean
    * Descripción: actualizar el estado de la habitacion 
    */
    public boolean actualizarEstadoHabitacion(int numero, boolean disponible) {

        Habitacion habitacion = consultarHabitacion(numero);

        if (habitacion == null) {
            return false;
        }
        habitacion.setDisponible(disponible);
        return true;
    }
    /*
    * Nombre del método: eliminarHabitacion
    * Parámetros recibidos: numero
    * Tipo de retorno: boolean
    * Descripción: Eliminar una habitacion 
    */
    public boolean eliminarHabitacion(int numero) {

        Habitacion habitacion = consultarHabitacion(numero);

        if (habitacion == null) {
            return false;
        }
        listaHabitaciones.remove(habitacion);
        return true;
    }
    /*
    * Nombre del método: consultarHabitacion
    * Parámetros recibidos: numero
    * Tipo de retorno: Habitacion
    * Descripción: Consultar habitacion
    */
    public Habitacion consultarHabitacion(int numero) {

        for (Habitacion h : listaHabitaciones) {

            if (h.getNumero() == numero) {
                return h;
            }
        }

        return null;
    }
   /*
    * Nombre del método: consultarDisponibilidad
    * Parámetros recibidos: numero
    * Tipo de retorno: boolean
    * Descripción: Consultar la disponibilidad de una habitacion
    */
    public boolean consultarDisponibilidad(int numero) {

        Habitacion habitacion = consultarHabitacion(numero);

        if (habitacion == null) {

            return false;
        }

        return habitacion.isDisponible();
    }
    /*
    * Nombre del método: obtenerHabitaciones
    * Parámetros recibidos: ArrayList
    * Tipo de retorno: ArrayList habitaciones
    * Descripción: Obtener habitaciones
    */
    public ArrayList<Habitacion> obtenerHabitaciones() {

        return listaHabitaciones;
    }
    /*
    * Nombre del método: ontenerHabitacionesDisponibles
    * Parámetros recibidos: ArrayList
    * Tipo de retorno: disponibles
    * Descripción: Obtener las habitaciones disponibles
    */
    public ArrayList<Habitacion> obtenerHabitacionesDisponibles() {

        ArrayList<Habitacion> disponibles = new ArrayList<>();

        for (Habitacion h : listaHabitaciones) {

            if (h.isDisponible()) {
                disponibles.add(h);
            }
        }
        return disponibles;
    }
    /*
    * Nombre del método: obtenerHabitacionesOcupadas
    * Parámetros recibidos: ArrayList
    * Tipo de retorno: ocupadas
    * Descripción: Obtener las habitaciones ocupadas
    */
    public ArrayList<Habitacion> obtenerHabitacionesOcupadas() {

        ArrayList<Habitacion> ocupadas = new ArrayList<>();

        for (Habitacion h : listaHabitaciones) {

            if (!h.isDisponible()) {
                ocupadas.add(h);
            }
        }
        return ocupadas;
    }
}
