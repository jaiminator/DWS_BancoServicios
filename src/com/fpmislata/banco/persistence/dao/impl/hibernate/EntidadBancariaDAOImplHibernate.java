
package com.fpmislata.banco.persistence.dao.impl.hibernate;

import com.fpmislata.banco.business.domain.EntidadBancaria;
import com.fpmislata.banco.business.domain.HibernateUtil;
import com.fpmislata.banco.core.BussinessException;
import com.fpmislata.banco.persistence.dao.EntidadBancariaDAO;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author alumno
 */
public class EntidadBancariaDAOImplHibernate implements EntidadBancariaDAO {
    
    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public List<EntidadBancaria> findByName(String nombre) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public EntidadBancaria get(int id) throws BussinessException {
        Session session = sessionFactory.openSession();
        
        EntidadBancaria entidadBancaria = (EntidadBancaria)session.get(EntidadBancaria.class,id);
        session.close();
        
        return entidadBancaria;
        
    }

    @Override
    public EntidadBancaria insert(EntidadBancaria t) throws BussinessException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public EntidadBancaria update(EntidadBancaria t) throws BussinessException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(int id) throws BussinessException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<EntidadBancaria> findAll() throws BussinessException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
