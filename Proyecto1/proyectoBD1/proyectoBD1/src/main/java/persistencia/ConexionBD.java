/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import persistencia.Interfaces.IConexionBD;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Usuario
 */
public class ConexionBD implements IConexionBD {
  private static final String URL_CONEXION = "jdbc:mysql://localhost:3306/bancodb";
    private static final String USUARIO = "root";
    private static final String CONTRASENA = "Soleyne1804"; 
    
    public ConexionBD() {
    }
    // Método para obtener la conexión
  @Override
    public  Connection obtenerConexion() throws SQLException {
        return DriverManager.getConnection(URL_CONEXION, USUARIO, CONTRASENA);
    }
    // Puedes agregar otros métodos relacionados con la gestión de la conexión si es necesario
}
