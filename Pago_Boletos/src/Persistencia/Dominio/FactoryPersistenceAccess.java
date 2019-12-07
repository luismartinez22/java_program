package Persistencia.Dominio;

import Persistencia.Accesso.*;
import Dominio.IPersistente;
import pago_boletos.boleto;

/**
 *
 * @author W.O.R.A.
 *
 */
public class FactoryPersistenceAccess extends FactoryPersistence {

    @Override
    public Broker createPersistence(IPersistente objP) {
        if (objP.getClass() == boleto.class) {
            return new BrokerBoletoAccess((boleto) objP);
        } else {
            return null;
        }
    }
}