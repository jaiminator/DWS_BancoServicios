
package com.fpmislata.banco.business.service;

import com.fpmislata.banco.business.domain.SucursalBancaria;
import java.util.List;

/**
 *
 * @author Jaime
 */
public interface SucursalBancariaService extends GenericService<SucursalBancaria> {
    List<SucursalBancaria> findByName(String nombreSucursal);
}
