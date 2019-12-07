
package Persistencia.Dominio;

import Dominio.IPersistente;
/**
 * 
 * @author MAT
 */
public abstract class FactoryPersistence {
  private BaseDeDatos objBD;

  public BaseDeDatos getObjBD() {
        return objBD;
  }

  public abstract Broker createPersistence(Dominio.IPersistente objP) ;

}
