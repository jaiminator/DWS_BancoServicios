
package com.fpmislata.banco.business.service.impl;

import com.fpmislata.banco.business.domain.SucursalBancaria;
import com.fpmislata.banco.business.service.SucursalBancariaService;
import com.fpmislata.banco.core.BussinessException;
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
    public SucursalBancaria get(int id) throws BussinessException {
        return sucursalBancariaDAO.get(id);
    }

    @Override
    public SucursalBancaria insert(SucursalBancaria sucursalBancaria) throws BussinessException {
        return sucursalBancariaDAO.insert(sucursalBancaria);
    }

    @Override
    public SucursalBancaria update(SucursalBancaria sucursalBancaria) throws BussinessException {
        return sucursalBancariaDAO.update(sucursalBancaria);
    }

    @Override
    public boolean delete(int id) throws BussinessException {
        return sucursalBancariaDAO.delete(id);
    }

    @Override
    public List<SucursalBancaria> findAll() throws BussinessException {
        return sucursalBancariaDAO.findAll();
    }
    
}
