
package com.fpmislata.banco.persistence.dao.impl.jdbc;

import com.fpmislata.banco.persistence.jdbc.ConnectionFactory;
import com.fpmislata.banco.business.domain.Usuario;
import com.fpmislata.banco.persistence.dao.UsuarioDAO;
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
public class UsuarioDAOImplJDBC implements UsuarioDAO {
    
    @Autowired
    ConnectionFactory connectionFactory;
    
    @Override
    public List<Usuario> findByName(String nombre) {
        try {
            Connection connection = connectionFactory.getConnection();

            PreparedStatement preparedStatement;

            String selectUsuario = "SELECT idUsuario, nombre, encryptedPassword FROM usuario WHERE nombre = ?";

            List<Usuario> usuarios = new ArrayList<>();

            preparedStatement = connection.prepareStatement(selectUsuario);
            preparedStatement.setString(1, nombre);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                Usuario usuario = new Usuario();

                usuario.setIdUsuario(resultSet.getInt("idUsuario"));
                usuario.setNombre(resultSet.getString("nombre"));
                usuario.setEncryptedPassword(resultSet.getString("encryptedPassword"));

                usuarios.add(usuario);

            }
            connectionFactory.closeConnection(connection);
            return usuarios;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public Usuario get(int id) {
        try {
            Connection connection = connectionFactory.getConnection();
            PreparedStatement preparedStatement;
            String selectUsuario = "SELECT * FROM usuario WHERE idUsuario = ?";
            preparedStatement = connection.prepareStatement(selectUsuario);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            Usuario usuario = new Usuario();

            if (resultSet.next()) {

                usuario.setIdUsuario(resultSet.getInt("idUsuario"));
                usuario.setNombre(resultSet.getString("nombre"));
                usuario.setEncryptedPassword(resultSet.getString("encryptedPassword"));

            }

            connectionFactory.closeConnection(connection);
            return usuario;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public Usuario insert(Usuario usuario) {
        try {

            java.util.Date utilDate = new java.util.Date();
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

            Connection connection = connectionFactory.getConnection();

            PreparedStatement preparedStatement;

            String insertUsuario = "INSERT INTO usuario VALUES (?,?,?)";

            preparedStatement = connection.prepareStatement(insertUsuario);

            preparedStatement.setInt(1, usuario.getIdUsuario());
            preparedStatement.setString(2, usuario.getNombre());
            preparedStatement.setString(3, usuario.getEncryptedPassword());
            
            preparedStatement.executeUpdate();

            System.out.println("Has insertado un nuevo usuario");

            connectionFactory.closeConnection(connection);
            return usuario;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public Usuario update(Usuario usuario) {
        try {
            java.util.Date utilDate = new java.util.Date();
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            
            Connection connection = connectionFactory.getConnection();

            PreparedStatement preparedStatement;

            String updateUsuario = "UPDATE usuario "
                    + "SET nombre = ?, clave = ? WHERE idUsuario = ?";

            preparedStatement = connection.prepareStatement(updateUsuario);
            preparedStatement.setString(1, usuario.getNombre());
            preparedStatement.setString(2, usuario.getEncryptedPassword());
            
            preparedStatement.setInt(3, usuario.getIdUsuario());
            
            preparedStatement.executeUpdate();

            System.out.println("Has modificado el registro correspondiente");

            connectionFactory.closeConnection(connection);
            return usuario;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public boolean delete(int id) {
        try {

            Connection connection = connectionFactory.getConnection();
            String deleteUsuario = "DELETE FROM usuario WHERE idUsuario = ?";
            PreparedStatement preparedStatement;

            preparedStatement = connection.prepareStatement(deleteUsuario);
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
    public List<Usuario> findAll() {
        try {
            Connection connection = connectionFactory.getConnection();

            PreparedStatement preparedStatement;
            String selectAllUsuario = "SELECT * FROM usuario";
            List<Usuario> usuarios = new ArrayList<>();
            preparedStatement = connection.prepareStatement(selectAllUsuario);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                Usuario usuario = new Usuario();

                usuario.setIdUsuario(resultSet.getInt("idUsuario"));
                usuario.setNombre(resultSet.getString("nombre"));
                usuario.setEncryptedPassword(resultSet.getString("encryptedPassword"));

                usuarios.add(usuario);

            }
            connectionFactory.closeConnection(connection);
            return usuarios;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
    
}
