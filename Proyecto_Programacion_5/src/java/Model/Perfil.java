/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Veronica Chacon
 */
public class Perfil {
    int id;
    String descripcion;
    int estatus;


public Perfil(int pId, String pDescripcion, int pEstatus){    
    this.id= pId;
this.descripcion = pDescripcion;
this.estatus= pEstatus;
}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getEstatus() {
        return estatus;
    }

    public void setEstatus(int estatus) {
        this.estatus = estatus;
    }


}








