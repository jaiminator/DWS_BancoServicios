
package com.fpmislata.banco.business.service;

import java.util.List;

/**
 *
 * @author alumno
 */
public interface GenericService<T> {
    T get(int id);
    T insert(T t);
    T update(T t);
    boolean delete(int id);
    List<T> findAll();
}
