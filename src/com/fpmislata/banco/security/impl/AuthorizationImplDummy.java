
package com.fpmislata.banco.security.impl;

import com.fpmislata.banco.business.domain.Usuario;
import com.fpmislata.banco.security.Authorization;

/**
 *
 * @author alumno
 */
public class AuthorizationImplDummy implements Authorization {

    @Override
    public boolean isAutorizedURL(Usuario usuario, String url) {
        
        if (usuario != null) {
            return true;
        } else {
            return false;
        }
    }
       
}
