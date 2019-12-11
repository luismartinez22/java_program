package Dominio;


import java.util.ArrayList;
import java.util.List;
import pago_boletos.boleto;
import pago_boletos.gest_boleto;
import pago_boletos.gest_usuario;
public class Facade {

    private static Facade objFacade = null;

    gest_boleto obj_boleto;
    gest_usuario obj_usuario;

    public static Facade getInstance() {
        if (objFacade == null) {
            objFacade = new Facade();
        }
        return objFacade;
    }

    private Facade() {
        obj_boleto = gest_boleto.getInstance();
        obj_usuario = gest_usuario.getInstance();
    }

    public ArrayList<IPersistente> devolverTodasSincronizaciones() {
        ArrayList<IPersistente> x = new ArrayList<IPersistente>();
        x.addAll(obj_boleto.devolver_boletos());
        return x;
    }

    //MEtodos de la gestora
    public boolean alta_boleto(int ocr, String fecha_sorteo, String fecha_pago, String tipo_juego, Boolean validado) {
        return obj_boleto.alta_boletos(ocr, fecha_sorteo, fecha_pago, tipo_juego, validado);
    }


    public ArrayList<boleto> devolver_boleto() {
        return obj_boleto.devolver_boletos();
    }

    public void modificar_boleto(int ocr) {
        obj_boleto.modificar_boletos(ocr);
    }
    
    //Gestora de Usuario
    public Boolean existe_usuario(String usuario, String clave) {
    	return obj_usuario.existe_usuario(usuario, clave);
    }

}
