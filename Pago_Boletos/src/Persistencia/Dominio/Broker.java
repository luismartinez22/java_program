package Persistencia.Dominio;

import Dominio.IPersistente;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author DevGL
 *
 */
public abstract class Broker {

    protected IPersistente objP;

    public Broker(IPersistente xObjP) {
        objP = xObjP;
    }

    public IPersistente getObjP() {
        return objP;
    }

    public void setObjP(IPersistente objP) {
        this.objP = objP;
    }

    public boolean guardar(boolean local) {
        return this.ejecutar(this.getInsertCommand(), local);
    }

    public boolean modificar(boolean local) {
        return this.ejecutar(this.getUpdateCommand(), local);
    }

    public boolean eliminar(boolean local) {
        return this.ejecutar(this.getDeleteCommand(), local);
    }

    public boolean ejecutar(String sentenciaSql, boolean local) {
        try {
            Statement st;
            if(local){
                st = BaseDeDatos.getConexionLocal().createStatement();
            }else{
                st = BaseDeDatos.getConexionWeb().createStatement();
            }            
            System.out.println(sentenciaSql);
            st.executeUpdate(sentenciaSql);
            st.close();
            BaseDeDatos.cerrarConexion(local);
            return true;
        } catch (SQLException e) {
            System.out.println("Error al ejecutar sql.\n" + e.getMessage());
            return false;
        }
    }

    public ResultSet obtenerResultSet(String consultaSql) {
        ResultSet rs = null;
        try {
            Statement st = BaseDeDatos.getConexionLocal().createStatement();            
            rs = st.executeQuery(consultaSql);
        } catch (SQLException e) {
            System.out.println("Error al ejecutar sql.\n" + e.getMessage());
        }
        return rs;
    }

    public ArrayList obtenerTodos() {
        ArrayList ret = new ArrayList();
        try {
            ResultSet rs = this.obtenerResultSet(getSelectCommand());            
            while (rs.next()) {
                IPersistente aux = getNuevo();
                obtenerDesdeResultSet(rs, aux);
                ret.add(aux);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener objetos.\n" + e.getMessage());
        }
        return ret;
    }
    
    public ArrayList obtenerUltimos(int id) {
        ArrayList ret = new ArrayList();
        try {
            ResultSet rs = this.obtenerResultSet(getSelectUltimosCommand(id));
            while (rs.next()) {
                IPersistente aux = getNuevo();
                obtenerDesdeResultSet(rs, aux);
                ret.add(aux);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener objetos.\n" + e.getMessage());
        }
        return ret;
    }
    
        public ArrayList obtener_boletos_por_fecha(String fecha) {
        ArrayList ret = new ArrayList();
        try {
            ResultSet rs = this.obtenerResultSet(obtener_por_fecha(fecha));
            while (rs.next()) {
                IPersistente aux = getNuevo();
                obtenerDesdeResultSet(rs, aux);
                ret.add(aux);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener boletos.\n" + e.getMessage());
        }
        return ret;
    }
    

    public abstract String getInsertCommand();

    public abstract String getUpdateCommand();

    public abstract String getDeleteCommand();

    public abstract String getSelectCommand();
    
    public abstract String getSelectUltimosCommand(int id);
    
    public abstract String obtener_por_fecha(String fecha);

    public abstract void obtenerDesdeResultSet(ResultSet rs, Object IPersistentej);

    public abstract IPersistente getNuevo();
}