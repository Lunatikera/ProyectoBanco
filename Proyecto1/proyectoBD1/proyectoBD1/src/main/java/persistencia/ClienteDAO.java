/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import persistencia.Interfaces.IClienteDAO;
import entidades.ClienteEntidad;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import persistencia.Interfaces.IConexionBD;

/**
 *
 * @author Usuario
 */
public class ClienteDAO implements IClienteDAO {

    private IConexionBD conexionBD;

    public ClienteDAO(IConexionBD conexion) {
        this.conexionBD = conexion;
    }

    // Método para actualizar un cliente en la base de datos
    @Override
    public void editar(ClienteEntidad cliente) throws PersistenciaException {
        // Definir la consulta SQL para actualizar un cliente en la tabla 'clientes'
        String updateCliente = "UPDATE Clientes SET nombre = ?, contraseña = ?, apellidoPa = ?, apellidoMa = ?, FechaNacimiento = ?, Domicilio = ? WHERE ID = ?";
        try ( Connection conexion = conexionBD.obtenerConexion();  PreparedStatement statement = conexion.prepareStatement(updateCliente)) {

            statement.setString(1, cliente.getNombre());
            statement.setString(2, cliente.getNomUsuario());
            statement.setString(3, cliente.getContraseña());
            statement.setString(4, cliente.getApellidoPa());
            statement.setString(5, cliente.getApellidoMa());
            statement.setDate(6, new java.sql.Date(cliente.getFechaNacimiento().getTime()));
            statement.setString(7, cliente.getDomicilio());
            statement.setInt(8, cliente.getIdCliente());
            int filasAfectadas = statement.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("Cliente actualizado correctamente.");
            } else {
                throw new PersistenciaException("No se encontró el cliente con ID: " + cliente.getIdCliente());
            }
        } catch (SQLException e) {
            throw new PersistenciaException("Error" + e.getMessage());
            // Manejo de errores
        }
    }

    // Método para agregar un cliente en la base de datos
    @Override
    public void agregar(ClienteEntidad cliente) throws PersistenciaException {
        // Definir la consulta SQL para insertar un nuevo cliente en la tabla 'clientes'
        String insertCliente = "INSERT INTO Clientes (nombre, nomUsuario, contraseña, apellidoPa, apellidoMa, fechaNacimiento, domicilio) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try ( Connection conexion = conexionBD.obtenerConexion();  PreparedStatement statement = conexion.prepareStatement(insertCliente)) {

            statement.setString(1, cliente.getNombre());
            statement.setString(2, cliente.getNomUsuario());
            statement.setString(3, cliente.getContraseña());
            statement.setString(4, cliente.getApellidoPa());
            statement.setString(5, cliente.getApellidoMa());
            statement.setDate(6, new java.sql.Date(cliente.getFechaNacimiento().getTime()));
            statement.setString(7, cliente.getDomicilio());

            int filasAfectadas = statement.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("Cliente agregado correctamente.");
            } else {
                System.out.println("No se pudo agregar el cliente.");
            }
        } catch (SQLException e) {
            throw new PersistenciaException("Error" + e.getMessage());
            // Manejo de errores
        }
    }

    @Override
    public ClienteEntidad iniciarSesion(String nombreUsuario, String contraseña) throws PersistenciaException {
        // Consulta SQL para verificar las credenciales de inicio de sesión del cliente
        ClienteEntidad cliente = null;
        String consulta = "SELECT * FROM Clientes WHERE NomUsuario = ? AND Contraseña = ?";
        try ( Connection conexion = conexionBD.obtenerConexion();  PreparedStatement statement = conexion.prepareStatement(consulta)) {
            statement.setString(1, nombreUsuario);
            statement.setString(2, contraseña);
            try ( ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    cliente = this.clienteEntidadDTO(resultSet);
                }
            }
        } catch (SQLException e) {
            throw new PersistenciaException("Error" + e.getMessage());
            // Manejo de errores
        }
        return cliente;

    }

    public boolean existeNombreUsuario(String nombreUsuario) throws PersistenciaException {
        String consulta = "SELECT COUNT(*) AS total FROM Clientes WHERE nomUsuario = ?";
        try ( Connection conexion = conexionBD.obtenerConexion();  PreparedStatement statement = conexion.prepareStatement(consulta)) {
            statement.setString(1, nombreUsuario);
            try ( ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    int total = resultSet.getInt("total");
                    return total > 0;
                }
            }
        } catch (SQLException e) {
            throw new PersistenciaException("Error al verificar el nombre de usuario", e);
        }
        return false;
    }

    private ClienteEntidad clienteEntidadDTO(ResultSet resultado) throws SQLException {
        int idCliente = resultado.getInt("id_Cliente");
        String nombre = resultado.getString("nombre");
        String nomUsuario = resultado.getString("nomUsuario");
        String contraseña = resultado.getString("contraseña");
        String apellidoPa = resultado.getString("apellidoPa");
        String apellidoMa = resultado.getString("apellidoMa");
        Date fechaNacimiento = resultado.getDate("fechaNacimiento");
        String domicilio = resultado.getString("domicilio");
        return new ClienteEntidad(idCliente, nombre, nomUsuario, contraseña, apellidoPa, apellidoMa, fechaNacimiento, domicilio);
    }

}
