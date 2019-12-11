package Persistencia.Accesso;

import java.sql.ResultSet;

import Dominio.IPersistente;
import Persistencia.Dominio.Broker;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import pago_boletos.boleto;
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
                try {
            usuario Usr = (usuario) IPersistentej;
            Usr.setNombre(rs.getString("nombre"));
            Usr.setAppelido(rs.getString("apellido"));
            Usr.setNombreDeUsuario(rs.getString("usuario"));
            Usr.setContrasena(rs.getString("clave"));
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener los usuarios.\nSi el problema persiste comuniquese a DevGL\nCel: 099782809", "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
		
	}

	@Override
	public IPersistente getNuevo() {
		// TODO Auto-generated method stub
		return new usuario();
	}

    @Override
    public String obtener_por_fecha(String fecha) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
