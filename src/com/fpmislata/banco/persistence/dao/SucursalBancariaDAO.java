/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
