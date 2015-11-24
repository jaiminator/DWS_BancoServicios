
package com.fpmislata.banco.security;

import com.fpmislata.banco.business.domain.Usuario;

/**
 *
 * @author alumno
 */
public interface Authorization {
    boolean isAutorizedURL(Usuario usuario, String url);
}
