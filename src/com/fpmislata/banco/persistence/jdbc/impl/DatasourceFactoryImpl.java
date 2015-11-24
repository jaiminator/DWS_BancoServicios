/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.persistence.jdbc.impl;

import com.fpmislata.banco.persistence.jdbc.DataSourceFactory;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author alumno
 */
public class DatasourceFactoryImpl implements DataSourceFactory {

    @Override
    public DataSource getDataSource() {
        DataSource dataSource;
        try {
            InitialContext initCtx = new InitialContext();
            Context envCtx = (Context) initCtx.lookup("java:comp/env");
            dataSource = (DataSource) envCtx.lookup("jdbc/banco");

            return dataSource;

        } catch (NamingException ex) {
            throw new RuntimeException(ex);

        }
    }
    
}
