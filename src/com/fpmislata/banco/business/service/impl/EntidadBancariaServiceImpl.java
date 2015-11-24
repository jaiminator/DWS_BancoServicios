
package com.fpmislata.banco.business.service.impl;

import com.fpmislata.banco.business.domain.EntidadBancaria;
import com.fpmislata.banco.business.service.EntidadBancariaService;
import com.fpmislata.banco.persistence.dao.EntidadBancariaDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author alumno
 */
public class EntidadBancariaServiceImpl implements EntidadBancariaService {
    
    @Autowired
    EntidadBancariaDAO entidadBancariaDAO;
    
    
    @Override
    public List<EntidadBancaria> findByName(String nombre) {
        return entidadBancariaDAO.findByName(nombre);
    }

    @Override
    public EntidadBancaria get(int id) {
        return entidadBancariaDAO.get(id);
    }

    @Override
    public EntidadBancaria insert(EntidadBancaria entidadBancaria) {
        return entidadBancariaDAO.insert(entidadBancaria);
    }

    @Override
    public EntidadBancaria update(EntidadBancaria entidadBancaria) {
        return entidadBancariaDAO.update(entidadBancaria);
    }

    @Override
    public boolean delete(int id) {
        return entidadBancariaDAO.delete(id);
    }

    @Override
    public List<EntidadBancaria> findAll() {
        return entidadBancariaDAO.findAll();
    }
    
}

