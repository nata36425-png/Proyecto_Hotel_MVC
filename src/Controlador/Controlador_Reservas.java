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

    // =====================================
    // 3.1 CREAR RESERVA
    // 3.2 ASOCIAR HUÉSPED Y HABITACIÓN
    // 3.3 REGISTRAR FECHAS
    // =====================================

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
        // La salida debe ser posterior al ingreso
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
    // =====================================
    // BUSCAR RESERVA
    // =====================================
    public Reservas buscarReserva(int numeroHabitacion) {

        for (Reservas r : listaReservas) {

            if (r.getHabitacion().getNumero() == numeroHabitacion && !r.getEstado().equalsIgnoreCase("Cancelada")) {

                return r;
            }
        }

        return null;
    }
    // =====================================
    // 3.4 ACTUALIZAR DISPONIBILIDAD
    // =====================================
    public boolean actualizarDisponibilidad(int numeroHabitacion, boolean disponible) {

        Reservas reserva = buscarReserva(numeroHabitacion);

        if (reserva == null) {

            return false;
        }

        reserva.getHabitacion().setDisponible(disponible);

        return true;
    }
    // =====================================
    // 3.5 CALCULAR COSTO TOTAL
    // =====================================
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
    // =====================================
    // 3.6 GENERAR COMPROBANTE
    // =====================================
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
    // =====================================
    // 3.7 CANCELAR RESERVA
    // =====================================
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
    // =====================================
    // OBTENER TODAS LAS RESERVAS
    // =====================================
    public ArrayList<Reservas> obtenerReservas() {

        return listaReservas;
    }
    // =====================================
    // CONTAR RESERVAS
    // =====================================
    public int cantidadReservas() {

        return listaReservas.size();
    }
}

