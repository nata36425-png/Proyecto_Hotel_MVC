/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author natam
 */
public class Reservas {
    
    private Huesped huesped;
    private Habitacion habitacion;
    private LocalDate fechaIngreso;
    private LocalDate fechaSalida;
    private String Estado;

    public Reservas() {
    }

    public Reservas(Huesped huesped, Habitacion habitacion, LocalDate fechaIngreso, LocalDate fechaSalida, String Estado) {
        this.huesped = huesped;
        this.habitacion = habitacion;
        this.fechaIngreso = fechaIngreso;
        this.fechaSalida = fechaSalida;
        this.Estado = "Activa";
    }

    public Huesped getHuesped() {
        return huesped;
    }

    public void setHuesped(Huesped huesped) {
        this.huesped = huesped;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public LocalDate getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(LocalDate fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }
    
    public void cancelar() {
        this.Estado = "CANCELADA";
        habitacion.setDisponible(true);
    }
  
     public double calcularTotal() {

        long dias = ChronoUnit.DAYS.between(fechaIngreso, fechaSalida);

        return habitacion.calcularCosto((int) dias);
    }

    public String generarComprobante() {

        return "===== RESERVA =====" +
               "\nHuésped: " + huesped.getNombre() +
               "\nHabitación: " + habitacion.getNumero() +
               "\nIngreso: " + fechaIngreso +
               "\nSalida: " + fechaSalida +
               "\nTotal: $" + calcularTotal();
    }
}
