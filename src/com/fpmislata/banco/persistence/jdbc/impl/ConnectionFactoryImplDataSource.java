/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.persistence.jdbc.impl;

import com.fpmislata.banco.persistence.jdbc.ConnectionFactory;
import java.sql.Connection;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

/**
 *
 * @author alumno
 */
public class ConnectionFactoryImplDataSource implements ConnectionFactory{

    @Override
    public Connection getConnection() {
        
        Connection connection;
            try {
                InitialContext initCtx = new InitialContext();;
                Context envCtx = (Context) initCtx.lookup("java:comp/env");
                DataSource dataSource = (DataSource)envCtx.lookup("jdbc/banco");
                
                connection = dataSource.getConnection();
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
            
            return connection;
    }

    @Override
    public void closeConnection(Connection connection) {
        
        try {
            connection.close();
        } catch (Exception ex) {
            throw new RuntimeException (ex);
        }
    }
    
}
