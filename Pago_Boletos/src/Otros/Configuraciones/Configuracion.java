package Otros.Configuraciones;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.HashMap;

/**
 *
 * @author W.O.R.A.
 *
 */
public class Configuracion {

    private double valordolar;
    private double valorgasoil;
    private int configfletescortos; //Define el limite entre fletes cortos y largos
    
    private String tipoConexionLocal = "Manual"; //ODBC o Manual
    private String userLocal = "root";
    private String passwordLocal = "Root100%";
    private String namebdLocal = "banca";
    
    private boolean tieneconWeb; //¿ Tiene conexion web ?
    private String urlWeb;// = "jdbc:mysql://www.transportesgriplan3.uy/" + bd; //Formato www.transportesgriplan3.uy
    private String userWeb; // = "woragrip_admin";
    private String passwordWeb;// = "50cent";
    private String namebdWeb;// = "woragrip_db";
    
    private String version;
    private String cActualizacion;
    
    private static Configuracion objConfiguraciones;

    private Configuracion() {
        try {
            init();
        } catch (Exception e) {
            System.exit(1);
        }
    }

    public static Configuracion getInstance() {
        if (objConfiguraciones == null) {
            objConfiguraciones = new Configuracion();
        }
        return objConfiguraciones;
    }

    public String getcActualizacion() {
        return cActualizacion;
    }

    public void setcActualizacion(String cActualizacion) {
        this.cActualizacion = cActualizacion;
    }

    public double getValordolar() {
        return valordolar;
    }

    public void setValordolar(double valordolar) {
        this.valordolar = valordolar;
    }

    public double getValorgasoil() {
        return valorgasoil;
    }

    public void setValorgasoil(double valorgasoil) {
        this.valorgasoil = valorgasoil;
    }

    public int getConfigfletescortos() {
        return configfletescortos;
    }

    public void setConfigfletescortos(int thisigfletescortos) {
        this.configfletescortos = thisigfletescortos;
    }

    public String getTipoConexionLocal() {
        return tipoConexionLocal;
    }

    public void setTipoConexionLocal(String tipoConexionLocal) {
        this.tipoConexionLocal = tipoConexionLocal;
    }

    public String getUserLocal() {
        return userLocal;
    }

    public void setUserLocal(String userLocal) {
        this.userLocal = userLocal;
    }

    public String getPasswordLocal() {
        return passwordLocal;
    }

    public void setPasswordLocal(String passwordLocal) {
        this.passwordLocal = passwordLocal;
    }

    public String getNamebdLocal() {
        return namebdLocal;
    }

    public void setNamebdLocal(String namebdLocal) {
        this.namebdLocal = namebdLocal;
    }

    public boolean isTieneconWeb() {
        return tieneconWeb;
    }

    public void setTieneconWeb(boolean tieneconWeb) {
        this.tieneconWeb = tieneconWeb;
    }

    public String getUrlWeb() {
        return urlWeb;
    }

    public void setUrlWeb(String urlWeb) {
        this.urlWeb = urlWeb;
    }

    public String getUserWeb() {
        return userWeb;
    }

    public void setUserWeb(String userWeb) {
        this.userWeb = userWeb;
    }

    public String getPasswordWeb() {
        return passwordWeb;
    }

    public void setPasswordWeb(String passwordWeb) {
        this.passwordWeb = passwordWeb;
    }

    public String getNameBdWeb() {
        return namebdWeb;
    }

    public void setNameBdWeb(String namebdWeb) {
        this.namebdWeb = namebdWeb;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
    
    public void reInit(){
        this.init();
    }

    private void init() {
        HashMap<String, String> hsmap = new HashMap<String, String>();
        try {
            FileReader archivo = new FileReader("lib/config.txt");
            BufferedReader br = new BufferedReader(archivo);
            String linea;

            while ((linea = br.readLine()) != null) {
                String attr = linea.substring(0, linea.indexOf(":"));
                String value = linea.substring(linea.indexOf(":") + 1, linea.indexOf(";"));
                hsmap.put(attr, value);
            }
            this.setValordolar(Double.parseDouble(hsmap.get("valordolar")));
            this.setValorgasoil(Double.parseDouble(hsmap.get("valorgasoil")));
            this.setConfigfletescortos(Integer.parseInt(hsmap.get("configfletescortos")));

            String a = hsmap.get("tipoConexionLocal");
            this.setTipoConexionLocal(a);
            this.setUserLocal(hsmap.get("userLocal"));
            this.setPasswordLocal(hsmap.get("passwordLocal"));
            this.setNamebdLocal(hsmap.get("namebdLocal"));

            this.setTieneconWeb(Boolean.getBoolean(hsmap.get("tieneconWeb")));
            this.setUrlWeb(hsmap.get("urlWeb"));
            this.setUserWeb(hsmap.get("userWeb"));
            this.setPasswordWeb(hsmap.get("passwordWeb"));
            this.setNameBdWeb(hsmap.get("namebdWeb"));

            this.setVersion(hsmap.get("version"));
            this.setcActualizacion(hsmap.get("actualizacion"));
            objConfiguraciones = this;
        } catch (Exception e) {
            
        }
    }

    public boolean modificar() {
        try
        {
            FileWriter fw = new FileWriter("lib/config.txt");
            PrintWriter pw = new PrintWriter(fw);
            String x = toString();
            pw.println(x);
            fw.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void modificarConfiguraciones(double valordolar, double valorgasoil, int thisigfletescortos) {
        this.modificarConfiguraciones(valordolar, valorgasoil, thisigfletescortos, tipoConexionLocal, userLocal, passwordLocal, namebdLocal, tieneconWeb, urlWeb, userWeb, passwordWeb, namebdWeb);
    }

    public void modificarConfiguraciones(double valordolar, double valorgasoil, int thisigfletescortos,
            String tipoConexionLocal, String userLocal, String passwordLocal, String namebdLocal,
            boolean tieneconWeb, String urlWeb, String userWeb, String passwordWeb, String namebdWeb)
    {
        //Recibe todos los campos, pero solo modifica los que fueron ingresados
        if (valordolar != 0) {
            this.valordolar = valordolar;
        }
        if (valorgasoil != 0) {
            this.valorgasoil = valorgasoil;
        }
        if (thisigfletescortos != 0) {
            this.configfletescortos = thisigfletescortos;
        }
        if (tipoConexionLocal != null) {
            this.tipoConexionLocal = tipoConexionLocal;
        }
        if (userLocal != null) {
            this.userLocal = userLocal;
        }
        if (passwordLocal != null) {
            this.passwordLocal = passwordLocal;
        }
        if (namebdLocal != null) {
            this.namebdLocal = namebdLocal;
        }
        if (tieneconWeb) {
            this.tieneconWeb = tieneconWeb;
        }
        if (urlWeb != null) {
            this.urlWeb = urlWeb;
        }
        if (userWeb != null) {
            this.userWeb = userWeb;
        }
        if (passwordWeb != null) {
            this.passwordWeb = passwordWeb;
        }
        if (namebdWeb != null) {
            this.namebdWeb = namebdWeb;
        }        
        if (version != null) {
            this.version = version;
        }
        modificar();
    }

    /**
     *
     * No modificar. (Se utiliza para escribir en este formato el archivo de configuraciones)
     */
    @Override
    public String toString() {
        return "valordolar:" + valordolar + ";\nvalorgasoil:" + valorgasoil + ";\nconfigfletescortos:" 
                + configfletescortos + ";\ntipoConexionLocal:" + tipoConexionLocal + ";\nuserLocal:" + 
                userLocal + ";\npasswordLocal:" + passwordLocal + ";\nnamebdLocal:"
                + namebdLocal + ";\ntieneconWeb:" + tieneconWeb + ";\nurlWeb:" + urlWeb + ";\nuserWeb:"
                + userWeb + ";\npasswordWeb:" + passwordWeb + ";\nnamebdWeb:" + namebdWeb + ";\nversion:"
                + version + ";\nactualizacion:" + cActualizacion + ';';
    }
    
    
}
