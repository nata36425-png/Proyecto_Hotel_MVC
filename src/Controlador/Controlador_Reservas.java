/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

import Modelo.Huesped;
import Modelo.Habitacion;
import Modelo.Reservas;
/**
 *
 * @author natam
 */
public class Controlador_Reservas {
    
    private ArrayList<Reservas> listaReservas;

    public Controlador_Reservas() {

        listaReservas = new ArrayList<>();
    }
    /*
    * Nombre del método: crearReserva
    * Parámetros recibidos: huesped, habitacion, fechaIngreso, fechaSalida
    * Tipo de retorno: boolean
    * Descripción: Crea la reserva del huesped
    */
    public boolean crearReserva(Huesped huesped, Habitacion habitacion, LocalDate fechaIngreso, LocalDate fechaSalida) {
        // Validar datos
        if (huesped == null
                || habitacion == null
                || fechaIngreso == null
                || fechaSalida == null) {
            return false;
        }
        // Verificar disponibilidad
        if (!habitacion.isDisponible()) {
            return false;
        }
        // La salida debe ser despues del ingreso
        if (!fechaSalida.isAfter(fechaIngreso)) {
            return false;
        }
        
        Reservas reserva = new Reservas();

        reserva.setHuesped(huesped);
        reserva.setHabitacion(habitacion);
        reserva.setFechaIngreso(fechaIngreso);
        reserva.setFechaSalida(fechaSalida);
        reserva.setEstado("Activa");
        
        // Marcar habitación como ocupada
        habitacion.setDisponible(false);
        listaReservas.add(reserva);
        return true;
    }
   /*
    * Nombre del método: buscarReserva
    * Parámetros recibidos: numeroHabitacion
    * Tipo de retorno: reserva r
    * Descripción: Busca la reserva asociada al numero de habitacion 
    */
    public Reservas buscarReserva(int numeroHabitacion) {

        for (Reservas r : listaReservas) {

            if (r.getHabitacion().getNumero() == numeroHabitacion && !r.getEstado().equalsIgnoreCase("Cancelada")) {
                return r;
            }
        }
        return null;
    }
    /*
    * Nombre del método: actualizarDisponibilidad 
    * Parámetros recibidos: numeroHabitacion, disponible 
    * Tipo de retorno: boolean
    * Descripción: Actualiza la disponibilidad de la habitacion segun la reserva
    */
    public boolean actualizarDisponibilidad(int numeroHabitacion, boolean disponible) {

        Reservas reserva = buscarReserva(numeroHabitacion);

        if (reserva == null) {
            return false;
        }

        reserva.getHabitacion().setDisponible(disponible);
        return true;
    }
    /*
    * Nombre del método: calcularCostoTotal
    * Parámetros recibidos: nuemroHabitacion
    * Tipo de retorno: Calcular costo
    * Descripción: Calcula el costo con el numero de habitacion y la cantidad de noches
    */
    public double calcularCostoTotal(int numeroHabitacion) {

        Reservas reserva = buscarReserva(numeroHabitacion);

        if (reserva == null) {
            return 0;
        }
        long noches = ChronoUnit.DAYS.between(reserva.getFechaIngreso(), reserva.getFechaSalida());
        if (noches <= 0) {
            return 0;
        }
        return reserva.getHabitacion().calcularCosto((int) noches);
    }
    /*
    * Nombre del método: generarComprobante
    * Parámetros recibidos: numeroHabitacion
    * Tipo de retorno: nombre huesped, documento, numero de habitacion,tipo, 
    fecha ingreso, salida, noches, estado de reserva y costototal 
    * Descripción: Genera el comprobante de la reserva mostrando todos los datos 
    */
    public String generarComprobante(int numeroHabitacion) {

        Reservas reserva = buscarReserva(numeroHabitacion);

        if (reserva == null) {
            return "Reserva no encontrada";
        }

        long noches = ChronoUnit.DAYS.between(reserva.getFechaIngreso(), reserva.getFechaSalida());
        return
                "===== COMPROBANTE DE RESERVA ====="
                + "\nHuésped: " + reserva.getHuesped().getNombre()
                + "\nDocumento: "+ reserva.getHuesped().getDocumento()
                + "\nHabitación: " + reserva.getHabitacion().getNumero()
                + "\nTipo: " + reserva.getHabitacion().getTipo()
                + "\nFecha de ingreso: " + reserva.getFechaIngreso()
                + "\nFecha de salida: " + reserva.getFechaSalida()
                + "\nNoches: " + noches
                + "\nEstado: " + reserva.getEstado()
                + "\nCosto Total: $" + calcularCostoTotal(numeroHabitacion);
    }
    /*
    * Nombre del método: cancelarReserva
    * Parámetros recibidos: numeroHabitacion
    * Tipo de retorno: boolean
    * Descripción: Cancela una reserva creada busacando por el numero de habitacion
    */
    public boolean cancelarReserva(int numeroHabitacion) {

        Reservas reserva = buscarReserva(numeroHabitacion);

        if (reserva == null) {
            return false;
        }

        if (reserva.getEstado().equalsIgnoreCase("Cancelada")) {
            return false;
        }

        reserva.setEstado("Cancelada");
        reserva.getHabitacion().setDisponible(true);
        return true;
    }
    /*
    * Nombre del método: obtenerReservas
    * Parámetros recibidos: No recibe
    * Tipo de retorno: listaReservas
    * Descripción: Obtiene la lista de reservas 
    */
    public ArrayList<Reservas> obtenerReservas() {
        return listaReservas;
    }
    /*
    * Nombre del método: cantidadReservas
    * Parámetros recibidos: No recibe 
    * Tipo de retorno: listaReservas.size(Tamaño de la lista)
    * Descripción: Muestra todas las reservas que se tienen registradas o creadas
    */
    public int cantidadReservas() {
        return listaReservas.size();
    }
}

