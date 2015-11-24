
package com.fpmislata.banco.security;

/**
 *
 * @author alumno
 */
public interface PasswordManager {
    String encrypt(String plain);
    boolean check(String plain, String encrypt);
}
