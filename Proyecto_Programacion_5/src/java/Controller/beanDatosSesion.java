/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Map;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 *
 * @author Veronica Chacon
 */
@Named(value = "beanDatosSesioin")
@SessionScoped
public class beanDatosSesion implements Serializable {

int perfil;
String usuario;

    /**
     * Creates a new instance of beanDatosSesioin
     */
    public beanDatosSesion() {
    }

        public void consultarSesion(){
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("Usuario");
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("Perfil");
        final ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
	final Map<String, Object> session = context.getSessionMap();
	final String miUsuario = session.get("Usuario").toString();
        final int miPerfil = (Integer)session.get("Perfil");

		try {
                        this.setUsuario(miUsuario);
                        this.setPerfil(miPerfil);
			
		} catch (ClassCastException e) {
			
		}
	}
	
	

    public int getPerfil() {
        return perfil;
    }

    public void setPerfil(int perfil) {
        this.perfil = perfil;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

}
