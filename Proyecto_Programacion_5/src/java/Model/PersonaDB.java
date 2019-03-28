/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import DAO.AccesoDatos;
import DAO.SNMPExceptions;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 *
 * @author Veronica Chacon
 */
public class PersonaDB {
    
    private AccesoDatos accesoDatos = new AccesoDatos();
    private Connection conn;  

    
    Usuario miUsuario;
    private LinkedList<Usuario> listaUsuario = 
            new LinkedList<Usuario>();
private     LinkedList<Perfil> listaPerfil= new LinkedList<Perfil>();

    
    public PersonaDB (Connection conn) {
        accesoDatos = new AccesoDatos();    
        accesoDatos.setDbConn(conn);
    }
    
    
    public PersonaDB() {
        super();
    }
    
    public  LinkedList<Usuario> todoUsuarios() throws SNMPExceptions, 
            SQLException {
      String select = "";
      LinkedList<Usuario> listaU = new LinkedList<Usuario>();
          
          try {
    
              //Se instancia la clase de acceso a datos
              AccesoDatos accesoDatos = new AccesoDatos();  

              //Se crea la sentencia de búsqueda
              select = 
                      "SELECT id_Persona,id_Perfil,clave FROM PerfilPersona";
              //Se ejecuta la sentencia SQL
              ResultSet rsPA = accesoDatos.ejecutaSQLRetornaRS(select);
             //Se llena el arryaList con los proyectos   
              while (rsPA.next()) {

                int codPerfil = rsPA.getInt("id_Persona");
                int codPersona = rsPA.getInt("id_Perfil");
                String clave= rsPA.getString("clave");
                
                Usuario Usuario = new Usuario(codPerfil,codPersona,clave);
                listaU.add(Usuario);
              }
              rsPA.close();
              
          } catch (SQLException e) {
              throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION, 
                                      e.getMessage(), e.getErrorCode());
          }catch (Exception e) {
              throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION, 
                                      e.getMessage());
          } finally {
              
          }
          return listaU;
      }
    
    
    public  Usuario unUsuario(int pId) throws SNMPExceptions, 
            SQLException {
      String select = "";
      
          try {
              //Se instancia la clase de acceso a datos
              AccesoDatos accesoDatos = new AccesoDatos();  

              //Se crea la sentencia de búsqueda
              select = 
                      "SELECT id_Persona, id_Perfil, clave FROM PerfilPersona where id_Persona= "+pId;
              //Se ejecuta la sentencia SQL
              ResultSet rsPA = accesoDatos.ejecutaSQLRetornaRS(select);
             //Se llena el arryaList con los proyectos   

             if(!rsPA.next()){
                 miUsuario=null;
             }
             
             else{
             int elPerfil= rsPA.getInt("id_Perfil");
             int laPersona= rsPA.getInt("id_Persona");
             String laClave= rsPA.getString("clave");
             
             Usuario elUsuario= new Usuario(laPersona,elPerfil, laClave);
             this.miUsuario=elUsuario;
             }
             
             rsPA.close();
              
          } catch (SQLException e) {
              throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION, 
                                      e.getMessage(), e.getErrorCode());
          }catch (Exception e) {
              throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION, 
                                      e.getMessage());
          } finally {
              
          }
          return miUsuario;
      }
 
    
    public  LinkedList<Perfil> todoPerfil() throws SNMPExceptions, 
            SQLException {
      String select = "";
      LinkedList<Perfil> listaPerfil = new LinkedList<Perfil>();
          
          try {
    
              //Se instancia la clase de acceso a datos
              AccesoDatos accesoDatos = new AccesoDatos();  

              //Se crea la sentencia de búsqueda
              select = 
                      "SELECT id,descripcion,estatus FROM Perfil";
              //Se ejecuta la sentencia SQL
              ResultSet rsPA = accesoDatos.ejecutaSQLRetornaRS(select);
             //Se llena el arryaList con los proyectos   
              while (rsPA.next()) {

                int id = rsPA.getInt("id");
                String descripcion = rsPA.getString("descripcion");
                int estatus= rsPA.getInt("estatus");
                
                Perfil miPerfil = new Perfil(id,descripcion,estatus);
                listaPerfil.add(miPerfil);
              }
              rsPA.close();
              
          } catch (SQLException e) {
              throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION, 
                                      e.getMessage(), e.getErrorCode());
          }catch (Exception e) {
              throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION, 
                                      e.getMessage());
          } finally {
              
          }
          return listaPerfil;
      }

    public Usuario getMiUsuario() {
        return miUsuario;
    }

    public void setMiUsuario(Usuario miUsuario) {
        this.miUsuario = miUsuario;
    }

    public LinkedList<Usuario> getListaUsuario() {
        return listaUsuario;
    }

    public void setListaUsuario(LinkedList<Usuario> listaUsuario) {
        this.listaUsuario = listaUsuario;
    }

    public LinkedList<Perfil> getListaPerfil() {
        return listaPerfil;
    }

    public void setListaPerfil(LinkedList<Perfil> listaPerfil) {
        this.listaPerfil = listaPerfil;
    }
  

    
}
