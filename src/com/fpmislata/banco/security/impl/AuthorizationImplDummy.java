/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
