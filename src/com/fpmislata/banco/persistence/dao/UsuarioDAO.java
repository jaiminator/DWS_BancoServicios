
package com.fpmislata.banco.persistence.dao;

import com.fpmislata.banco.business.domain.Usuario;
import java.util.List;

/**
 *
 * @author alumno
 */
public interface UsuarioDAO extends GenericDAO<Usuario> {
    List<Usuario> findByName(String nombre);
}
