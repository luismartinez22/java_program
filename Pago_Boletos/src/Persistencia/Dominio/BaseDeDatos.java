package Persistencia.Dominio;

import Otros.Configuraciones.Configuracion;
import interfaz.Configuraciones.FrmInitConfig;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author DevGL
 *
 */
public class BaseDeDatos {

    static Connection conLocal = null;
    static Connection conWeb = null;

    public static Connection getConexionLocal() throws SQLException {
        try {
            if (conLocal == null || conLocal.isClosed()) {
                if (Configuracion.getInstance().getTipoConexionLocal().equals("ODBC")) {
                    Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                    if (false) {
                        conLocal = DriverManager.getConnection("jdbc:odbc:bd2Terminal");
                    } else {
                        conLocal = DriverManager.getConnection("jdbc:odbc:bd2");
                    }
                } else if (Configuracion.getInstance().getTipoConexionLocal().equals("Manual")) {
                    String user = Configuracion.getInstance().getUserLocal();// "root";
                    String password = Configuracion.getInstance().getPasswordLocal();// "admin22!";
                    String bd = Configuracion.getInstance().getNamebdLocal();// "banca";
                    String url = "jdbc:mysql://127.0.0.1:3306/" + bd;
                    Class.forName("com.mysql.jdbc.Driver");
                    conLocal = DriverManager.getConnection(url, user, password);
                } else {
                    JOptionPane.showMessageDialog(null, "Tipo de conexion desconocida", "Error",
                            JOptionPane.ERROR_MESSAGE);
                    return null;
                }
            }
        } catch (SQLException e1) {
            JOptionPane.showMessageDialog(null, "Error al conectarse a la base de datos local. \nPor favor ingrese la configuración nuevamente o comuniquese con soporte tecnico.\nCEL: 099782809",
                    "Error", JOptionPane.INFORMATION_MESSAGE);
            FrmInitConfig frm = new FrmInitConfig(null, true);
            frm.setVisible(true);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectarse a la base de datos local. \nPor favor ingrese la configuración nuevamente o comuniquese con soporte tecnico.\nCEL: 099782809",
                    "Error", JOptionPane.INFORMATION_MESSAGE);
            FrmInitConfig frm = new FrmInitConfig(null, true);
            frm.setVisible(true);
        } catch (Exception e){
            return null;
        }
        return conLocal;
    }

    public static Connection getConexionWeb() throws SQLException {
        try {
            if (conWeb == null || conWeb.isClosed()) {
                if (Configuracion.getInstance().isTieneconWeb()) {
                    String user = Configuracion.getInstance().getUserWeb(); //"admin";
                    String password = Configuracion.getInstance().getPasswordWeb(); // "admin22!";
                    String bd = Configuracion.getInstance().getNameBdWeb(); //"boletos_db";
                    String url = "jdbc:mysql://"+ Configuracion.getInstance().getUrlWeb()+ "/" + bd;
                    Class.forName("com.mysql.jdbc.Driver");
                    conWeb = DriverManager.getConnection(url, user, password);
                }
            }
        } catch (Exception e) {
        }
        return conWeb;
    }

    public static void cerrarConexion(boolean local) {
        try {
            if (local) {
                if (conLocal != null) {
                    conLocal.close();
                }
            } else {
                if (conWeb != null) {
                    conWeb.close();
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cerrar la conexion con la base de datos.",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
