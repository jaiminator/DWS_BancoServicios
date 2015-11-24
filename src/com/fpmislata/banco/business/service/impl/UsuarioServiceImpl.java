/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.business.service.impl;

import com.fpmislata.banco.business.domain.Usuario;
import com.fpmislata.banco.business.service.UsuarioService;
import com.fpmislata.banco.persistence.dao.UsuarioDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author alumno
 */
public class UsuarioServiceImpl implements UsuarioService {
    
    @Autowired
    UsuarioDAO usuarioDAO;

    @Override
    public List<Usuario> findByName(String nombreUsuario) {
        return usuarioDAO.findByName(nombreUsuario);
    }

    @Override
    public Usuario get(int id) {
        return usuarioDAO.get(id);
    }

    @Override
    public Usuario insert(Usuario usuario) {
        return usuarioDAO.insert(usuario);
    }

    @Override
    public Usuario update(Usuario usuario) {
        return usuarioDAO.update(usuario);
    }

    @Override
    public boolean delete(int id) {
        return usuarioDAO.delete(id);
    }

    @Override
    public List<Usuario> findAll() {
        return usuarioDAO.findAll();
    }
    
}
