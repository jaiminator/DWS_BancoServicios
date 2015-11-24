/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.presentation;

import com.fpmislata.banco.business.domain.EntidadBancaria;
import com.fpmislata.banco.business.domain.SucursalBancaria;
import com.fpmislata.banco.persistence.dao.EntidadBancariaDAO;
import com.fpmislata.banco.persistence.dao.SucursalBancariaDAO;
import com.fpmislata.banco.persistence.dao.impl.jdbc.EntidadBancariaDAOImplJDBC;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author alumno
 */
public class BancoService {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");

//        EntidadBancariaDAO entidadBancariaDAO = context.getBean(EntidadBancariaDAO.class);
//        EntidadBancaria entidadBancaria;
//
//        entidadBancaria = entidadBancariaDAO.get(4);
//
//        System.out.println(entidadBancaria.getIdEntidadBancaria()
//                + " " + entidadBancaria.getNombre()
//                + " " + entidadBancaria.getCodigoEntidad()
//                + " " + entidadBancaria.getFechaCreacion()
//                + " " + entidadBancaria.getDireccion()
//                + " " + entidadBancaria.getCif());
        
        SucursalBancariaDAO sucursalBancariaDAO = context.getBean(SucursalBancariaDAO.class);
        SucursalBancaria sucursalBancaria = new SucursalBancaria();
        
        sucursalBancaria.setIdSucursalBancaria(1);
        sucursalBancaria.setNombreSucursal("Bancaixa");
        sucursalBancaria.setDireccion("C/Pelayo");
        sucursalBancaria.setDirector("Joan Manuel");
        sucursalBancaria.setTelefono("964320058");
        sucursalBancaria.setFechaApertura(null);
        sucursalBancariaDAO.insert(sucursalBancaria);
        

//       List<EntidadBancaria> entidadesBancarias;
//       entidadesBancarias = entidadBancariaDAO.findByName("Caixabank");
//       
//       for (EntidadBancaria entidad : entidadesBancarias) {
//                System.out.println(entidad.getIdEntidadBancaria()+ "  " + entidad.getNombre() +
//                        "  " + entidad.getCodigoEntidad()+ "  " + entidad.getFechaCreacion() +
//                        "  " + entidad.getDireccion() + "  " + entidad.getCif());
//            }
//       EntidadBancaria entidadBancaria = new EntidadBancaria();
//       entidadBancaria.setIdEntidadBancaria(2);
//       entidadBancaria.setNombre("Bankia");
//       entidadBancaria.setCodigoEntidad("778B");
//       entidadBancaria.setFechaCreacion(null);
//       entidadBancaria.setDireccion("C/Juan Varelles");
//       entidadBancaria.setCif("002");
//       
//       entidadBancariaDAO.update(entidadBancaria);
    }
//    
//    private static java.sql.Timestamp getCurrentTimeStamp() {
//
//		java.util.Date today = new java.util.Date();
//		return new java.sql.Timestamp(today.getTime());
//
//	}

}
