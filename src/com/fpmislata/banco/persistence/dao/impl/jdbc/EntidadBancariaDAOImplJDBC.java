
package com.fpmislata.banco.persistence.dao.impl.jdbc;

import com.fpmislata.banco.persistence.jdbc.ConnectionFactory;
import com.fpmislata.banco.business.domain.EntidadBancaria;
import com.fpmislata.banco.persistence.dao.EntidadBancariaDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author alumno
 */
public class EntidadBancariaDAOImplJDBC implements EntidadBancariaDAO {

    @Autowired
    ConnectionFactory connectionFactory;

    @Override
    public EntidadBancaria get(int id) {

        try {
            Connection connection = connectionFactory.getConnection();
            PreparedStatement preparedStatement;
            String selectEntidad = "SELECT * FROM entidadBancaria WHERE idEntidadBancaria = ?";
            preparedStatement = connection.prepareStatement(selectEntidad);
            preparedStatement.setInt(1, id);

            ResultSet rs = preparedStatement.executeQuery();
            EntidadBancaria entidadBancaria = new EntidadBancaria();

            if (rs.next()) {

                entidadBancaria.setIdEntidadBancaria(rs.getInt("idEntidadBancaria"));
                entidadBancaria.setNombre(rs.getString("nombre"));
                entidadBancaria.setCodigoEntidad(rs.getString("codigoEntidad"));
                entidadBancaria.setFechaCreacion(rs.getDate("fechaCreacion"));
                entidadBancaria.setDireccion(rs.getString("direccion"));
                entidadBancaria.setCif(rs.getString("cif"));

            } else {
                entidadBancaria = null;
            }

            connectionFactory.closeConnection(connection);
            return entidadBancaria;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

    }

    @Override
    public EntidadBancaria insert(EntidadBancaria entidadBancaria) {
        try {

            java.util.Date utilDate = new java.util.Date();
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

            Connection connection = connectionFactory.getConnection();

            PreparedStatement preparedStatement;

            String insertEntidad = "INSERT INTO entidadBancaria VALUES (?,?,?,?,?,?)";

            preparedStatement = connection.prepareStatement(insertEntidad);

            preparedStatement.setInt(1, entidadBancaria.getIdEntidadBancaria());
            preparedStatement.setString(2, entidadBancaria.getNombre());
            preparedStatement.setString(3, entidadBancaria.getCodigoEntidad());
            preparedStatement.setDate(4, sqlDate);
            preparedStatement.setString(5, entidadBancaria.getDireccion());
            preparedStatement.setString(6, entidadBancaria.getCif());

            preparedStatement.executeUpdate();

            System.out.println("Has insertado fila nueva de banco");

            connectionFactory.closeConnection(connection);
            return entidadBancaria;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public EntidadBancaria update(EntidadBancaria entidadBancaria) {
        try {
            Connection connection = connectionFactory.getConnection();

            PreparedStatement preparedStatement;

            String updateEntidad = "UPDATE entidadBancaria "
                    + "SET nombre = ?, codigoEntidad = ?,"
                    + "fechaCreacion = ?, direccion = ?, cif = ?"
                    + " WHERE idEntidadBancaria = ?";

            preparedStatement = connection.prepareStatement(updateEntidad);
            preparedStatement.setString(1, entidadBancaria.getNombre());
            preparedStatement.setString(2, entidadBancaria.getCodigoEntidad());
            preparedStatement.setTimestamp(3, getCurrentTimeStamp());
            preparedStatement.setString(4, entidadBancaria.getDireccion());
            preparedStatement.setString(5, entidadBancaria.getCif());
            preparedStatement.setInt(6, entidadBancaria.getIdEntidadBancaria());
            preparedStatement.executeUpdate();

            System.out.println("Has modificado el registro correspondiente");

            connectionFactory.closeConnection(connection);
            return entidadBancaria;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

    }

    @Override
    public boolean delete(int id) {
        try {

            Connection connection = connectionFactory.getConnection();
            String deleteEntidad = "DELETE FROM entidadBancaria WHERE idEntidadBancaria = ?";
            PreparedStatement preparedStatement;

            preparedStatement = connection.prepareStatement(deleteEntidad);
            preparedStatement.setInt(1, id);
            int rowsDeleted = preparedStatement.executeUpdate();

            preparedStatement.close();
            connectionFactory.closeConnection(connection);

            if (rowsDeleted == 0) {
                return false;
            } else if (rowsDeleted == 1) {
                return true;
            } else if (rowsDeleted > 1) {
                throw new RuntimeException("Demasiadas filas borradas" + rowsDeleted);
            } else {
                throw new RuntimeException("Soy un paranoico" + rowsDeleted);
            }

        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

    }

    @Override
    public List<EntidadBancaria> findAll() {
        try {
            Connection connection = connectionFactory.getConnection();

            PreparedStatement preparedStatement;
            String selectAllEntidad = "SELECT * FROM entidadBancaria";
            List<EntidadBancaria> entidadesBancarias = new ArrayList<>();
            preparedStatement = connection.prepareStatement(selectAllEntidad);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {

                EntidadBancaria entidadBancaria = new EntidadBancaria();

                entidadBancaria.setIdEntidadBancaria(rs.getInt("idEntidadBancaria"));
                entidadBancaria.setNombre(rs.getString("nombre"));
                entidadBancaria.setCodigoEntidad(rs.getString("codigoEntidad"));
                entidadBancaria.setFechaCreacion(rs.getTimestamp("fechaCreacion"));
                entidadBancaria.setDireccion(rs.getString("direccion"));
                entidadBancaria.setCif(rs.getString("cif"));

                entidadesBancarias.add(entidadBancaria);

            }
            connectionFactory.closeConnection(connection);
            return entidadesBancarias;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public List<EntidadBancaria> findByName(String nombre) {
        try {
            Connection connection = connectionFactory.getConnection();

            PreparedStatement preparedStatement;

            String selectEntidad = "SELECT idEntidadBancaria, nombre, codigoEntidad, fechaCreacion, direccion, cif FROM entidadBancaria WHERE nombre = ?";

            List<EntidadBancaria> entidadesBancarias = new ArrayList<>();

            preparedStatement = connection.prepareStatement(selectEntidad);
            preparedStatement.setString(1, nombre);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {

                EntidadBancaria entidadBancaria = new EntidadBancaria();

                entidadBancaria.setIdEntidadBancaria(rs.getInt("idEntidadBancaria"));
                entidadBancaria.setNombre(rs.getString("nombre"));
                entidadBancaria.setCodigoEntidad(rs.getString("codigoEntidad"));
                entidadBancaria.setFechaCreacion(rs.getTimestamp("fechaCreacion"));
                entidadBancaria.setDireccion(rs.getString("direccion"));
                entidadBancaria.setCif(rs.getString("cif"));

                entidadesBancarias.add(entidadBancaria);

            }
            connectionFactory.closeConnection(connection);
            return entidadesBancarias;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

    }

    private static java.sql.Timestamp getCurrentTimeStamp() {

        java.util.Date today = new java.util.Date();
        return new java.sql.Timestamp(today.getTime());

    }

}
