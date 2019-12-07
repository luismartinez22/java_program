/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pago_boletos;

import Persistencia.Dominio.FachadaBaseDeDatos;
import Dominio.IPersistente;
import Persistencia.Dominio.Broker;
import java.util.ArrayList;

/**
 *
 * @author luis
 */
public class boleto implements IPersistente  {
    private int ocr;
    private String fecha_sorteo;
    private String fecha_pago;
    private String tipo_juego;
    private Boolean validado;
    Broker objBroker;
    
        public boleto() {
        objBroker = FachadaBaseDeDatos.getInstance().obtenerBroker(this);
    }

    public boleto(int ocr, String fecha_sorteo, String fecha_pago, String tipo_juego, Boolean validado) {
        this.ocr = ocr;
        this.fecha_sorteo = fecha_sorteo;
        this.fecha_pago = fecha_pago;
        this.tipo_juego = tipo_juego;
        this.validado = validado;
        objBroker = FachadaBaseDeDatos.getInstance().obtenerBroker(this);
    }

    public int getOcr() {
        return ocr;
    }

    public void setOcr(int ocr) {
        this.ocr = ocr;
    }

    public String getFecha_sorteo() {
        return fecha_sorteo;
    }

    public void setFecha_sorteo(String fecha_sorteo) {
        this.fecha_sorteo = fecha_sorteo;
    }

    public String getFecha_pago() {
        return fecha_pago;
    }

    public void setFecha_pago(String fecha_pago) {
        this.fecha_pago = fecha_pago;
    }

    public String getTipo_juego() {
        return tipo_juego;
    }

    public void setTipo_juego(String tipo_juego) {
        this.tipo_juego = tipo_juego;
    }

    public Boolean getValidado() {
        return validado;
    }

    public void setValidado(Boolean validado) {
        this.validado = validado;
    }

    @Override
    public String toString() {
        return "boleto{" + "ocr=" + ocr + ", fecha_sorteo=" + fecha_sorteo + ", fecha_pago=" + fecha_pago + ", tipo_juego=" + tipo_juego + ", validado=" + validado + '}';
    }

    @Override
    public boolean guardar(boolean local) {
        return objBroker.guardar(local);
    }

    @Override
    public boolean modificar(boolean local) {
        return objBroker.modificar(local);
    }

    @Override
    public boolean eliminar(boolean local) {
        return objBroker.eliminar(local);
    }

    @Override
    public ArrayList obtenerTodos() {
        return objBroker.obtenerTodos();
    }

    @Override
    public String actualizacion() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setactualizado() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    
}
