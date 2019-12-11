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
public class gest_boleto extends Observable {
    private ArrayList<boleto> col_boletos = new ArrayList<boleto>();
    private static gest_boleto objGestC = null;

    public gest_boleto() {
        boleto objc = new boleto();
        col_boletos = objc.obtenerTodos();
    }

    public static gest_boleto getInstance() {
        if (objGestC == null) {
            objGestC = new gest_boleto();
        }
        return objGestC;
    }


    public boolean alta_boletos(int ocr, String fecha_sorteo, String fecha_pago, String tipo_juego, Boolean validado) {
            boleto xObjC = new boleto(ocr, fecha_sorteo, fecha_pago, tipo_juego, validado);
            col_boletos.add(xObjC);
            xObjC.guardar(true);
            //this.setChanged();
            //this.notifyObservers();
            return true;
    }

    public ArrayList<boleto> devolver_boletos() {
        return col_boletos;
    }
    
    public ArrayList<boleto> obtener_boletos_por_fecha(String fecha) {
        ArrayList<boleto> x = new ArrayList<boleto>();
        boleto objC = new boleto();
        return objC.obtener_boletos_por_fecha(fecha);
    }

    public ArrayList<boleto> devolver_boletos_sincronizar() {
        ArrayList<boleto> x = new ArrayList<boleto>();
        for (boleto objC : col_boletos) {
            if (!objC.actualizacion().equals("")) {
                x.add(objC);
            }
        }
        return x;
    }

    public void modificar_boletos(int ocr) {
        boleto xObjC = devolverBoletoId(ocr);
        xObjC.setOcr(ocr);
        xObjC.setValidado(Boolean.TRUE);
        xObjC.modificar(true);
        this.setChanged();
        this.notifyObservers(ocr);
    }

    public boleto devolverBoletoId(int xId) {
        for (boleto c : col_boletos) {
            if (xId == c.getOcr()) {
                return c;
            }
        }
        return null;
    }
}
