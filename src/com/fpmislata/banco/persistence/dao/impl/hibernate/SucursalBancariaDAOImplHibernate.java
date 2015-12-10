
package com.fpmislata.banco.persistence.dao.impl.hibernate;

import com.fpmislata.banco.business.domain.SucursalBancaria;
import com.fpmislata.banco.core.BussinessException;
import com.fpmislata.banco.persistence.dao.SucursalBancariaDAO;
import java.util.List;

/**
 *
 * @author alumno
 */
public class SucursalBancariaDAOImplHibernate implements SucursalBancariaDAO {

    @Override
    public List<SucursalBancaria> findByName(String nombreSucursal) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public SucursalBancaria get(int id) throws BussinessException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public SucursalBancaria insert(SucursalBancaria t) throws BussinessException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public SucursalBancaria update(SucursalBancaria t) throws BussinessException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(int id) throws BussinessException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<SucursalBancaria> findAll() throws BussinessException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
