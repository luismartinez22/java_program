/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pago_boletos;

import java.util.ArrayList;
import java.util.Observable;

/**
 *
 * @author luis
 */
public class gest_usuario extends Observable {
    private ArrayList<usuario> col_usuario = new ArrayList<usuario>();
    private static gest_usuario objGestUsr = null;

    public gest_usuario() {
        usuario objc = new usuario();
        col_usuario = objc.obtenerTodos();
    }

    public static gest_usuario getInstance() {
        if (objGestUsr == null) {
            objGestUsr = new gest_usuario();
        }
        return objGestUsr;
    }


    public boolean alta_usuario(String nombre, String apellido, String usuario, String clave) {
            usuario xObjUsuario = new usuario(nombre, apellido, usuario, clave);
            col_usuario.add(xObjUsuario);
            xObjUsuario.guardar(true);
            return true;
    }

    public ArrayList<usuario> devolver_usuario() {
        return col_usuario;
    }

    public Boolean existe_usuario(String usuario, String clave) {
        for (usuario objC : col_usuario) {
            if (objC.getNombreDeUsuario().equals(usuario) && objC.getContrasena().equals(clave)) {
                return true;
            }
        }
        return false;
    }
}
