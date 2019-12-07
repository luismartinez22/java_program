package Persistencia.Accesso;

import Persistencia.Dominio.Broker;
import pago_boletos.boleto;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author DevGL
 *
 */
public class BrokerBoletoAccess extends Broker {

    public BrokerBoletoAccess(boleto objU) {
        super(objU);
    }

    @Override
    public String getInsertCommand() {
        boleto Usr = (boleto) this.getObjP();
        return "INSERT INTO boletos(ocr, fecha_sorteo, fecha_pago, tipo_juego, validado)" + "VALUES('" + Usr.getOcr() + "','" + Usr.getFecha_sorteo() + "','" + Usr.getFecha_pago() + "','" + Usr.getTipo_juego()+ "'," + Usr.getValidado()+")";

    }

    @Override
    public String getUpdateCommand() {
        boleto Usr = (boleto) this.getObjP();
        return "UPDATE boletos SET validado=" + true + " WHERE ocr=" + Usr.getOcr();
    }


    @Override
    public String getSelectCommand() {
        return "SELECT * FROM boletos";
    }
    
    @Override
    public String getSelectUltimosCommand(int id) {
        return "";
    }

    @Override
    public void obtenerDesdeResultSet(ResultSet rs, Object IPersistentej) {
        try {
            boleto Usr = (boleto) IPersistentej;
            Usr.setOcr(rs.getInt("ocr"));
            Usr.setFecha_sorteo(rs.getString("fecha_sorteo"));
            Usr.setFecha_pago(rs.getString("fecha_pago"));
            Usr.setTipo_juego(rs.getString("tipo_juego"));
            Usr.setValidado(rs.getBoolean("validado"));
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener los usuarios.\nSi el problema persiste comuniquese a DevGL\nCel: 099782809", "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }

    @Override
    public Dominio.IPersistente getNuevo() {
        return new boleto();
    }

    @Override
    public String getDeleteCommand() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
