
package com.fpmislata.banco.persistence.jdbc;

import java.sql.Connection;

/**
 *
 * @author alumno
 */
public interface ConnectionFactory {
    Connection getConnection();
    void closeConnection(Connection connection);
}
