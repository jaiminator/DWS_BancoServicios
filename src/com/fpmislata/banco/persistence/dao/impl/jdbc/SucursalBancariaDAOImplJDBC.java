
package com.fpmislata.banco.persistence.dao.impl.jdbc;

import com.fpmislata.banco.persistence.jdbc.ConnectionFactory;
import com.fpmislata.banco.business.domain.SucursalBancaria;
import com.fpmislata.banco.persistence.dao.SucursalBancariaDAO;
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
public class SucursalBancariaDAOImplJDBC implements SucursalBancariaDAO {
    
    @Autowired
    ConnectionFactory connectionFactory;

    @Override
    public SucursalBancaria get(int id) {
        try {
            Connection connection = connectionFactory.getConnection();
            PreparedStatement preparedStatement;
            String selectSucursal = "SELECT * FROM sucursalBancaria WHERE idSucursalBancaria = ?";
            preparedStatement = connection.prepareStatement(selectSucursal);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            SucursalBancaria sucursalBancaria = new SucursalBancaria();

            if (resultSet.next()) {

                sucursalBancaria.setIdSucursalBancaria(resultSet.getInt("idSucursalBancaria"));
                sucursalBancaria.setNombreSucursal(resultSet.getString("nombreSucursal"));
                sucursalBancaria.setDireccion(resultSet.getString("direccion"));
                sucursalBancaria.setDirector(resultSet.getString("director"));
                sucursalBancaria.setTelefono(resultSet.getString("telefono"));
                sucursalBancaria.setFechaApertura(resultSet.getDate("fechaApertura"));

            }

            connectionFactory.closeConnection(connection);
            return sucursalBancaria;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public SucursalBancaria insert(SucursalBancaria sucursalBancaria) {
        try {

            java.util.Date utilDate = new java.util.Date();
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

            Connection connection = connectionFactory.getConnection();

            PreparedStatement preparedStatement;

            String insertSucursal = "INSERT INTO sucursalbancaria VALUES (?,?,?,?,?,?)";

            preparedStatement = connection.prepareStatement(insertSucursal);

            preparedStatement.setInt(1, sucursalBancaria.getIdSucursalBancaria());
            preparedStatement.setString(2, sucursalBancaria.getNombreSucursal());
            preparedStatement.setString(3, sucursalBancaria.getDireccion());
            preparedStatement.setString(4, sucursalBancaria.getDirector());
            preparedStatement.setString(5, sucursalBancaria.getTelefono());
            preparedStatement.setDate(6, sqlDate);
            
            preparedStatement.executeUpdate();

            System.out.println("Has insertado fila nueva de sucursal");

            connectionFactory.closeConnection(connection);
            return sucursalBancaria;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public SucursalBancaria update(SucursalBancaria sucursalBancaria) {
        try {
            java.util.Date utilDate = new java.util.Date();
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            
            Connection connection = connectionFactory.getConnection();

            PreparedStatement preparedStatement;

            String updateSucursal = "UPDATE sucursalBancaria "
                    + "SET nombreSucursal = ?, direccion = ?,"
                    + "director = ?, telefono = ?, fechaApertura = ?"
                    + " WHERE idSucursalBancaria = ?";

            preparedStatement = connection.prepareStatement(updateSucursal);
            preparedStatement.setString(1, sucursalBancaria.getNombreSucursal());
            preparedStatement.setString(2, sucursalBancaria.getDireccion());
            
            preparedStatement.setString(3, sucursalBancaria.getDirector());
            preparedStatement.setString(4, sucursalBancaria.getTelefono());
            preparedStatement.setDate(5, sqlDate);
            preparedStatement.setInt(6, sucursalBancaria.getIdSucursalBancaria());
            
            preparedStatement.executeUpdate();

            System.out.println("Has modificado el registro correspondiente");

            connectionFactory.closeConnection(connection);
            return sucursalBancaria;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public boolean delete(int id) {
        try {

            Connection connection = connectionFactory.getConnection();
            String deleteSucursal = "DELETE FROM sucursalBancaria WHERE idSucursalBancaria = ?";
            PreparedStatement preparedStatement;

            preparedStatement = connection.prepareStatement(deleteSucursal);
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
    public List<SucursalBancaria> findAll() {
        try {
            Connection connection = connectionFactory.getConnection();

            PreparedStatement preparedStatement;
            String selectAllSucursal = "SELECT * FROM sucursalBancaria";
            List<SucursalBancaria> sucursalesBancarias = new ArrayList<>();
            preparedStatement = connection.prepareStatement(selectAllSucursal);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {

                SucursalBancaria sucursalBancaria = new SucursalBancaria();

                sucursalBancaria.setIdSucursalBancaria(rs.getInt("idSucursalBancaria"));
                sucursalBancaria.setNombreSucursal(rs.getString("nombreSucursal"));
                sucursalBancaria.setDireccion(rs.getString("direccion"));
                sucursalBancaria.setDirector(rs.getString("director"));
                sucursalBancaria.setTelefono(rs.getString("telefono"));
                sucursalBancaria.setFechaApertura(rs.getDate("fechaApertura"));

                sucursalesBancarias.add(sucursalBancaria);

            }
            connectionFactory.closeConnection(connection);
            return sucursalesBancarias;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public List<SucursalBancaria> findByName(String nombreSucursal) {
        try {
            Connection connection = connectionFactory.getConnection();

            PreparedStatement preparedStatement;

            String selectSucursal = "SELECT idSucursalBancaria, nombreSucursal, direccion, director, telefono, fechaApertura FROM sucursalbancaria WHERE nombreSucursal = ?";

            List<SucursalBancaria> sucursalesBancarias = new ArrayList<>();

            preparedStatement = connection.prepareStatement(selectSucursal);
            preparedStatement.setString(1, nombreSucursal);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {

                SucursalBancaria sucursalBancaria = new SucursalBancaria();

                sucursalBancaria.setIdSucursalBancaria(rs.getInt("idSucursalBancaria"));
                sucursalBancaria.setNombreSucursal(rs.getString("nombreSucursal"));
                sucursalBancaria.setDireccion(rs.getString("direccion"));
                sucursalBancaria.setDirector(rs.getString("director"));
                sucursalBancaria.setTelefono(rs.getString("telefono"));
                sucursalBancaria.setFechaApertura(rs.getDate("fechaApertura"));

                sucursalesBancarias.add(sucursalBancaria);

            }
            connectionFactory.closeConnection(connection);
            return sucursalesBancarias;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
    
}
