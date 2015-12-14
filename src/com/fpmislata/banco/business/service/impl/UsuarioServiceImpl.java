
package com.fpmislata.banco.business.service.impl;

import com.fpmislata.banco.business.domain.Usuario;
import com.fpmislata.banco.business.service.UsuarioService;
import com.fpmislata.banco.core.BussinessException;
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
    public List<Usuario> findByName(String nombre) {
        return usuarioDAO.findByName(nombre);
    }

    @Override
    public Usuario get(int id) throws BussinessException {
        return usuarioDAO.get(id);
    }

    @Override
    public Usuario insert(Usuario usuario) throws BussinessException {
        return usuarioDAO.insert(usuario);
    }

    @Override
    public Usuario update(Usuario usuario) throws BussinessException {
        return usuarioDAO.update(usuario);
    }

    @Override
    public boolean delete(int id) throws BussinessException {
        return usuarioDAO.delete(id);
    }

    @Override
    public List<Usuario> findAll() throws BussinessException {
        return usuarioDAO.findAll();
    }
    
}
