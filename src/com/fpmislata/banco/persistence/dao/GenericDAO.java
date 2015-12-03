
package com.fpmislata.banco.persistence.dao;

import com.fpmislata.banco.core.BussinessException;
import java.util.List;

/**
 *
 * @author alumno
 */
public interface GenericDAO<T> {
    T get(int id) throws BussinessException;
    T insert(T t) throws BussinessException;
    T update(T t) throws BussinessException;
    boolean delete(int id) throws BussinessException;
    List<T> findAll() throws BussinessException;
}
