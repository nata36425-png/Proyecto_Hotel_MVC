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
    // ==================================================
    // 2.1 REGISTRAR HUÉSPED
    // ==================================================
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
    // ==================================================
    // 2.2 BUSCAR HUÉSPED
    // ==================================================
    public Huesped buscarHuesped(String documento) {

        for (Huesped h : listaHuespedes) {

            if (h.getDocumento().equals(documento)) {

                return h;
            }
        }

        return null;
    }
    // ==================================================
    // 2.3 ACTUALIZAR HUÉSPED
    // ==================================================
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
    // ==================================================
    // 2.4 ELIMINAR HUÉSPED
    // ==================================================
    public boolean eliminarHuesped(String documento) {

        Huesped huesped = buscarHuesped(documento);

        if (huesped == null) {

            return false;
        }

        listaHuespedes.remove(huesped);

        return true;
    }
    // ==================================================
    // OBTENER LISTA
    // ==================================================
    public ArrayList<Huesped> obtenerHuespedes() {

        return listaHuespedes;
    }
} 
    
    
    

