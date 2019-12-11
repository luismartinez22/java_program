/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pago_boletos;

import Persistencia.Dominio.FachadaBaseDeDatos;
import Dominio.IPersistente;
import Persistencia.Accesso.BrokerUsuario;
import Persistencia.Dominio.Broker;
import java.util.ArrayList;

/**
 *
 * @author luis
 */
public class usuario implements IPersistente{
    private String nombre;
    private String appelido;
    private String nombreDeUsuario;
    private String contrasena;
    Broker objBroker;
    BrokerUsuario objBrokerUsuario = new BrokerUsuario(this);
    
    public usuario() {
    objBroker = FachadaBaseDeDatos.getInstance().obtenerBroker(this);
}
    
    public usuario(String nombre, String appelido, String nombreDeUsuario, String contrasena) {
        this.nombre = nombre;
        this.appelido = appelido;
        this.nombreDeUsuario = nombreDeUsuario;
        this.contrasena = contrasena;
        objBroker = FachadaBaseDeDatos.getInstance().obtenerBroker(this);
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



	@Override
	public boolean guardar(boolean local) {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public boolean modificar(boolean local) {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public boolean eliminar(boolean local) {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public ArrayList obtenerTodos() {
		return objBrokerUsuario.obtenerTodos();
	}



	@Override
	public String actualizacion() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public void setactualizado() {
		// TODO Auto-generated method stub
		
	}
    
    
    
}
