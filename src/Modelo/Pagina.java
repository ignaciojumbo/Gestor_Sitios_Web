/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Pagina {
    private int idPagina;
    private String FechaRegistro;
    private String nombrePagina;
    private String linkPagina;
    private String tipoPagina;
    private String descripcion;
    private String Usuario;
    private String Clave;

    public int getIdPagina() {
        return idPagina;
    }

    public void setIdPagina(int idPagina) {
        this.idPagina = idPagina;
    }

    public String getFechaRegistro() {
        return FechaRegistro;
    }

    public void setFechaRegistro(String FechaRegistro) {
        this.FechaRegistro = FechaRegistro;
    }

    public String getNombrePagina() {
        return nombrePagina;
    }

    public void setNombrePagina(String nombrePagina) {
        this.nombrePagina = nombrePagina;
    }

    public String getLinkPagina() {
        return linkPagina;
    }

    public void setLinkPagina(String linkPagina) {
        this.linkPagina = linkPagina;
    }

    public String getTipoPagina() {
        return tipoPagina;
    }

    public void setTipoPagina(String tipoPagina) {
        this.tipoPagina = tipoPagina;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getClave() {
        return Clave;
    }

    public void setClave(String Clave) {
        this.Clave = Clave;
    }

   
    

}
