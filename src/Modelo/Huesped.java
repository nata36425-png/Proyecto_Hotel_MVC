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
   
    public Huesped() {
    }

    public Huesped(String Numero_telefono, String Correo) {
        this.Numero_telefono = Numero_telefono;
        this.Correo = Correo;
        
    }

    public Huesped(String Numero_telefono, String Correo, String Nombre, String Apellido, String Documento) {
        super(Nombre, Apellido, Documento);
        this.Numero_telefono = Numero_telefono;
        this.Correo = Correo;
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
}
