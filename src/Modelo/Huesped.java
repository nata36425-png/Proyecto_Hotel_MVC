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
public class Huesped extends Persona{
    
    private String Numero_telefono;
    private String Correo;
    private int Numero_habitacion;

    public Huesped() {
    }

    public Huesped(String Numero_telefono, String Correo, int Numero_habitacion) {
        this.Numero_telefono = Numero_telefono;
        this.Correo = Correo;
        this.Numero_habitacion = Numero_habitacion;
    }

    public Huesped(String Numero_telefono, String Correo, int Numero_habitacion, String Nombre, String Apellido, String Documento) {
        super(Nombre, Apellido, Documento);
        this.Numero_telefono = Numero_telefono;
        this.Correo = Correo;
        this.Numero_habitacion = Numero_habitacion;
    }

   
    
   
    @Override
    public String MostrarInfo() {
        return super.MostrarInfo() + this.Correo;
    }

    public String getNumero_telefono() {
        return Numero_telefono;
    }

    public void setNumero_telefono(String Numero_telefono) {
        this.Numero_telefono = Numero_telefono;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public int getNumero_habitacion() {
        return Numero_habitacion;
    }

    public void setNumero_habitacion(int Numero_habitacion) {
        this.Numero_habitacion = Numero_habitacion;
    }
}
