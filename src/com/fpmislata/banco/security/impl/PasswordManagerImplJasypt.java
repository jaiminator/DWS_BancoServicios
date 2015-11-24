/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.security.impl;

import com.fpmislata.banco.security.PasswordManager;
import org.jasypt.util.password.BasicPasswordEncryptor;
import org.jasypt.util.password.StrongPasswordEncryptor;

/**
 *
 * @author alumno
 */
public class PasswordManagerImplJasypt implements PasswordManager {

    @Override
    public String encrypt(String plain) {
        BasicPasswordEncryptor basicPasswordEncryptor = new BasicPasswordEncryptor();
        String encryptedPassword = basicPasswordEncryptor.encryptPassword(plain);

        return encryptedPassword;
    }

    @Override
    public boolean check(String plain, String encrypt) {
        StrongPasswordEncryptor strongPasswordEncryptor = new StrongPasswordEncryptor();
        
        if (strongPasswordEncryptor.checkPassword(plain, encrypt)) {
          return true;
        } else {
          return false;
        }
    }
    
}
