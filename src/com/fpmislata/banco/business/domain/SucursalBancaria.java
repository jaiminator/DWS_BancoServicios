
package com.fpmislata.banco.business.domain;

import java.util.Date;

/**
 *
 * @author alumno
 */
public class SucursalBancaria {
    private int idSucursalBancaria;
    private String nombreSucursal;
    private String direccion;
    private String director;
    private String telefono;
    private Date fechaApertura;
    
    public SucursalBancaria() {
        
    }
    
    public SucursalBancaria(int idSucursalBancaria, String nombreSucursal, String direccion, String director, String telefono, Date fechaApertura) {
        this.idSucursalBancaria = idSucursalBancaria;
        this.nombreSucursal = nombreSucursal;
        this.direccion = direccion;
        this.director = director;
        this.telefono = telefono;
        this.fechaApertura = fechaApertura;
    }

    public int getIdSucursalBancaria() {
        return idSucursalBancaria;
    }

    public void setIdSucursalBancaria(int idSucursalBancaria) {
        this.idSucursalBancaria = idSucursalBancaria;
    }

    public String getNombreSucursal() {
        return nombreSucursal;
    }

    public void setNombreSucursal(String nombreSucursal) {
        this.nombreSucursal = nombreSucursal;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Date getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(Date fechaApertura) {
        this.fechaApertura = fechaApertura;
    }
    
}
