
package com.fpmislata.banco.business.service.impl;

import com.fpmislata.banco.business.domain.SucursalBancaria;
import com.fpmislata.banco.business.service.SucursalBancariaService;
import com.fpmislata.banco.persistence.dao.SucursalBancariaDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Jaime
 */
public class SucursalBancariaServiceImpl implements SucursalBancariaService {
    
    @Autowired
    SucursalBancariaDAO sucursalBancariaDAO;
    
    
    @Override
    public List<SucursalBancaria> findByName(String nombreSucursal) {
        return sucursalBancariaDAO.findByName(nombreSucursal);
    }

    @Override
    public SucursalBancaria get(int id) {
        return sucursalBancariaDAO.get(id);
    }

    @Override
    public SucursalBancaria insert(SucursalBancaria sucursalBancaria) {
        return sucursalBancariaDAO.insert(sucursalBancaria);
    }

    @Override
    public SucursalBancaria update(SucursalBancaria sucursalBancaria) {
        return sucursalBancariaDAO.update(sucursalBancaria);
    }

    @Override
    public boolean delete(int id) {
        return sucursalBancariaDAO.delete(id);
    }

    @Override
    public List<SucursalBancaria> findAll() {
        return sucursalBancariaDAO.findAll();
    }
    
}
