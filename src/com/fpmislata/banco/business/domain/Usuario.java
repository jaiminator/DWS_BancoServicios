
package com.fpmislata.banco.business.domain;

/**
 *
 * @author alumno
 */
public class Usuario {
    private int idUsuario;
    private String nombre;
    private String encryptedPassword;
    private Rol rol;
    private String nick;
    
    public Usuario() {
        
    }

    public Usuario(int idUsuario, String nombre, String encryptedPassword, Rol rol, String nick) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.encryptedPassword = encryptedPassword;
        this.rol = rol;
        this.nick = nick;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEncryptedPassword() {
        return encryptedPassword;
    }

    public void setEncryptedPassword(String encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }
    
}
