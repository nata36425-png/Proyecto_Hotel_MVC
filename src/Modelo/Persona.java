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
public class Persona {
    
    private String Nombre;
    private String Apellido;
    private String Documento;

    public Persona() {
    }

    public Persona(String Nombre, String Apellido, String Documento) {
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Documento = Documento;
    }

    

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getDocumento() {
        return Documento;
    }

    public void setDocumento(String Documento) {
        this.Documento = Documento;
    }
    
    public void mostrarInfo () {
         
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        this.Apellido = apellido;
    }
    
    public String MostrarInfo() {
        return "Documento: " + this.Documento + " | " + this.Nombre + this.Apellido;
    }   
}
