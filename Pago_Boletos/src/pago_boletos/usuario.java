/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pago_boletos;

/**
 *
 * @author luis
 */
public class usuario {
    private String nombre;
    private String appelido;
    private String nombreDeUsuario;
    private String contrasena;

    public usuario(String nombre, String appelido, String nombreDeUsuario, String contrasena) {
        this.nombre = nombre;
        this.appelido = appelido;
        this.nombreDeUsuario = nombreDeUsuario;
        this.contrasena = contrasena;
    }
    
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAppelido() {
        return appelido;
    }

    public void setAppelido(String appelido) {
        this.appelido = appelido;
    }

    public String getNombreDeUsuario() {
        return nombreDeUsuario;
    }

    public void setNombreDeUsuario(String nombreDeUsuario) {
        this.nombreDeUsuario = nombreDeUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    
    
    
}
