/**
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import java.util.ArrayList;
/**
 * 
 * @author W.O.R.A.
 * 
 */
public interface IPersistente {
    
  boolean guardar(boolean local) ;

  boolean modificar(boolean local) ;

  boolean eliminar(boolean local) ;

  ArrayList obtenerTodos() ;
  
  String actualizacion() ;
  
  void setactualizado() ;

}
