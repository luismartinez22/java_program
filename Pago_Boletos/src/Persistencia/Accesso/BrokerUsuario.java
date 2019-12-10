package Persistencia.Accesso;

import java.sql.ResultSet;

import Dominio.IPersistente;
import Persistencia.Dominio.Broker;
import pago_boletos.usuario;

public class BrokerUsuario extends Broker {

	public BrokerUsuario(usuario objUsuario) {
        super(objUsuario);
    }

	@Override
	public String getInsertCommand() {
		usuario Usr = (usuario) this.getObjP();
        return "INSERT INTO usuario(nombre, apellido, usuario, clave)" + "VALUES('" + Usr.getNombre() + "','" + Usr.getAppelido() + "','" + Usr.getNombreDeUsuario() + "','" + Usr.getContrasena()+")";

	}

	@Override
	public String getUpdateCommand() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDeleteCommand() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getSelectCommand() {
                return "SELECT * FROM usuario";
	}

	@Override
	public String getSelectUltimosCommand(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void obtenerDesdeResultSet(ResultSet rs, Object IPersistentej) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public IPersistente getNuevo() {
		// TODO Auto-generated method stub
		return null;
	}

}
