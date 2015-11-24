
package com.fpmislata.banco.business.service;

import com.fpmislata.banco.business.domain.Usuario;
import java.util.List;

/**
 *
 * @author alumno
 */
public interface UsuarioService extends GenericService<Usuario> {
    List<Usuario> findByName(String nombreUsuario);
}
