/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import Modelo.Huesped;

import java.util.ArrayList;

/**
 *
 * @author natam
 */

public class Controlador_Huesped {

    private ArrayList<Huesped> listaHuespedes;

    public Controlador_Huesped() { 
        
        listaHuespedes = new ArrayList<>();
    }
    /*
    * Nombre del método: registrarHuesped
    * Parámetros recibidos: Huesped huesped
    * Tipo de retorno: boolean
    * Descripción: Registrar huesped
    */
    public boolean registrarHuesped(Huesped huesped) {
        // VALIDAR NULO
        if (huesped == null) {
            return false;
        }
        // VALIDAR DUPLICADOS
        for (Huesped h : listaHuespedes) {

            if (h.getDocumento().equals(huesped.getDocumento())) {
                return false;
            }
        }
        // AGREGAR
        listaHuespedes.add(huesped);
        return true;
    }
   /*
    * Nombre del método: buscarHuesped
    * Parámetros recibidos: documento
    * Tipo de retorno: huesped 
    * Descripción: Busca al huesped por el documento
    */
    public Huesped buscarHuesped(String documento) {

        for (Huesped h : listaHuespedes) {

            if (h.getDocumento().equals(documento)) {
                return h;
            }
        }
        return null;
    }
   /*
    * Nombre del método: actualizarHuesped
    * Parámetros recibidos: documento, nuevoNombre, nuevoApellido, numeroTelefono, nuevoCorreo
    * Tipo de retorno: boolean
    * Descripción: Actualiza al huesped con datos nuevos 
    */
    public boolean actualizarHuesped(String documento, String nuevoNombre, String nuevoApellido, String nuevoTelefono, String nuevoCorreo) {

        Huesped huesped = buscarHuesped(documento);
        
        if (huesped == null) {
            return false;
        }
        
        huesped.setNombre(nuevoNombre);
        huesped.setApellido(nuevoApellido);
        huesped.setNumero_telefono(nuevoTelefono);               
        huesped.setCorreo(nuevoCorreo);
        return true;
    }
   /*
    * Nombre del método: eliminarHuesped
    * Parámetros recibidos: documento
    * Tipo de retorno: boolean
    * Descripción: Elimina al huesped que ya existe usando el documento
    */
    public boolean eliminarHuesped(String documento) {

        Huesped huesped = buscarHuesped(documento);

        if (huesped == null) {
            return false;
        }
        listaHuespedes.remove(huesped);
        return true;
    }
    /*
    * Nombre del método: obtenerHuespedes
    * Parámetros recibidos: no recibe
    * Tipo de retorno: listaHuespedes 
    * Descripción: enlista a los huespedes en una losta para así tenerlos 
    */
    public ArrayList<Huesped> obtenerHuespedes() {
        return listaHuespedes;
    }
} 
    
    
    

