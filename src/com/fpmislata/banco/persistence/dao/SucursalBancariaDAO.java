
package com.fpmislata.banco.persistence.dao;

import com.fpmislata.banco.business.domain.SucursalBancaria;
import java.util.List;

/**
 *
 * @author alumno
 */
public interface SucursalBancariaDAO extends GenericDAO<SucursalBancaria> {
    List<SucursalBancaria> findByName(String nombreSucursal);
}
