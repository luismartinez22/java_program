package Persistencia.Dominio;

import Dominio.IPersistente;

/**
 *
 * @author W.O.R.A.
 * 
 */
public class FachadaBaseDeDatos {

    private FactoryPersistence fabricaOp;
    private static FachadaBaseDeDatos objGBD = null;

    public Broker obtenerBroker(IPersistente objP) {
        return fabricaOp.createPersistence(objP);
    }

    public static FachadaBaseDeDatos getInstance() {
        if (objGBD == null) {
            objGBD = new FachadaBaseDeDatos();
        }
        return objGBD;
    }

    private FachadaBaseDeDatos() {
        fabricaOp = new FactoryPersistenceAccess();
    }
}