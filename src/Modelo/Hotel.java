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
public class Hotel {
    
    private String Nombre;
    private String Ubicacion;

    public Hotel() {
    }

    public Hotel(String Nombre, String Ubicacion) {
        this.Nombre = Nombre;
        this.Ubicacion = Ubicacion;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getUbicacion() {
        return Ubicacion;
    }

    public void setUbicacion(String Ubicacion) {
        this.Ubicacion = Ubicacion;
    }
    
    
}
