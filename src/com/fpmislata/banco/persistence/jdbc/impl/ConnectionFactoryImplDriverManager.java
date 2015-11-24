/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.persistence.jdbc.impl;

import com.fpmislata.banco.persistence.jdbc.ConnectionFactory;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alumno
 */
public class ConnectionFactoryImplDriverManager implements ConnectionFactory {

    @Override
    public Connection getConnection() {
            
            Connection conn;
            try {
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/banco", "root", "root");
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
            
        return conn;
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
