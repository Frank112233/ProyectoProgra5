/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.SNMPExceptions;
import Model.Perfil;
import Model.Persona;
import Model.PersonaDB;
import Model.Usuario;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedList;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

/**
 *
 * @author Veronica Chacon
 */
@Named(value = "beanUsuarios")
@SessionScoped
public class beanUsuarios implements Serializable {

    /**
     * Creates a new instance of beanUsuarios
     */
    public beanUsuarios() {
    }
    

    LinkedList<SelectItem> listaItemPerfil = new LinkedList<>();
    LinkedList<Usuario> listaUsuarios = new LinkedList<Usuario>();
    LinkedList<Perfil> listaPerfiles= new LinkedList<Perfil>();
    Usuario miUsuario;
    Perfil miPerfil;
    PersonaDB personaDB;
    int selectPerfil;
    int selectUsuario;
    String selectClave;
    String mensajeLogin;

    public LinkedList<SelectItem> getListaItemPerfil() throws SNMPExceptions, SQLException {
          String descripcion="";
        int codigo=0;
        
        LinkedList<Perfil> lista = new LinkedList<Perfil>();
        personaDB = new PersonaDB();
        
        lista = personaDB.todoPerfil();
        
        LinkedList resultList = new LinkedList();
        resultList.add(new SelectItem(0, 
                "Seleccione Perfil"));
        
        for (Iterator iter= lista.iterator();
                iter.hasNext();) {
        
            Perfil item = (Perfil) iter.next();
            descripcion=item.getDescripcion();
            codigo=item.getId();
            resultList.add(new SelectItem(codigo, 
                    descripcion));
         }         
         return resultList; 
        
  }

     public String autenticar() throws SNMPExceptions, SQLException{
         
         this.miUsuario= this.personaDB.unUsuario(this.selectUsuario);
         
if(miUsuario==null){
    this.mensajeLogin="Usuario no Registrado";
}
else{
    if(miUsuario.getPerfil()!=this.selectPerfil){
    this.mensajeLogin="Perfil no Autorizado";
    }
    else{
    if(miUsuario.getClave().equals(this.selectClave)){
        this.mensajeLogin="Exito";
    }
    else{
    this.mensajeLogin="Clave Incorrecta";
    }
    }

}

return this.mensajeLogin;
     }
           
        /*   if (Usuario1 != null){
               FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("Usuario",UsuarioIngresado);
               FacesContext.getCurrentInstance().getExternalContext().redirect("Home.xhtml");
}*/
          
    
    
    public void setListaItemPerfil(LinkedList<SelectItem> listaItemPerfil) {
        this.listaItemPerfil = listaItemPerfil;
    }

    public LinkedList<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(LinkedList<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public LinkedList<Perfil> getListaPerfiles() throws SNMPExceptions, SQLException {
                LinkedList<Perfil> lista = new LinkedList<Perfil>();
        personaDB = new PersonaDB();
        
        lista = personaDB.todoPerfil();
        
        LinkedList resultLista = new LinkedList();
        resultLista=lista;       

        return resultLista; 
    }

    public void setListaPerfiles(LinkedList<Perfil> listaPerfiles) {
        this.listaPerfiles = listaPerfiles;
    }

    public Usuario getMiUsuario() {
        return miUsuario;
    }

    public void setMiUsuario(Usuario miUsuario) {
        this.miUsuario = miUsuario;
    }

    public Perfil getMiPerfil() {
        return miPerfil;
    }

    public void setMiPerfil(Perfil miPerfil) {
        this.miPerfil = miPerfil;
    }

    public PersonaDB getPersonaDB() {
        return personaDB;
    }

    public void setPersonaDB(PersonaDB personaDB) {
        this.personaDB = personaDB;
    }

    public int getSelectPerfil() {
        return selectPerfil;
    }

    public void setSelectPerfil(int selectPerfil) {
        this.selectPerfil = selectPerfil;
    }

    public int getSelectUsuario() {
        return selectUsuario;
    }

    public void setSelectUsuario(int selectUsuario) {
        this.selectUsuario = selectUsuario;
    }

    public String getSelectClave() {
        return selectClave;
    }

    public void setSelectClave(String selectClave) {
        this.selectClave = selectClave;
    }

    public String getMensajeLogin() {
        return mensajeLogin;
    }

    public void setMensajeLogin(String mensajeLogin) {
        this.mensajeLogin = mensajeLogin;
    }




}
