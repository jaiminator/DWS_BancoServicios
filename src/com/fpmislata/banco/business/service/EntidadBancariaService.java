
package com.fpmislata.banco.business.service;

import com.fpmislata.banco.business.domain.EntidadBancaria;
import java.util.List;

/**
 *
 * @author alumno
 */
public interface EntidadBancariaService extends GenericService<EntidadBancaria> {
    List<EntidadBancaria> findByName(String nombre);
}
