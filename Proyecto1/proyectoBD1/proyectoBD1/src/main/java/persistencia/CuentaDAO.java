/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import dto.CuentaDTO;
import entidades.ClienteEntidad;
import entidades.CuentaEntidad;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import persistencia.Interfaces.ICuentaDAO;

/**
 *
 * @author Usuario
 */
public class CuentaDAO implements ICuentaDAO {

    @Override
    public void agregar(CuentaEntidad cuenta, ClienteEntidad cliente) throws PersistenciaException {
        // Definir la consulta SQL para insertar una nueva cuenta en la tabla 'Cuenta'
        String insertCuenta = "INSERT INTO Cuentas (numeroCuenta, saldo, fechaApertura, Nip, id_Cliente) VALUES (?, ?, ?, ?, ?)";
        ConexionBD conexionBD = new ConexionBD();
        try ( Connection conexion = conexionBD.obtenerConexion();  PreparedStatement statement = conexion.prepareStatement(insertCuenta, Statement.RETURN_GENERATED_KEYS)) {
            // Generar el número de cuenta automáticamente (puedes implementar la lógica para generarlo)
            String numeroCuenta = generarNumeroAleatorio(); // Implementa este método según tu lógica de generación de número de cuenta

            statement.setString(1, numeroCuenta);
            statement.setBigDecimal(2, BigDecimal.ZERO);
            statement.setDate(4, new java.sql.Date(cuenta.getFechaApertura().getTime()));
            statement.setString(5, cuenta.getNip());
            statement.setInt(6, cliente.getIdCliente());
            int filasAfectadas = statement.executeUpdate();
            if (filasAfectadas > 0) {
                System.out.println("Cuenta agregada correctamente.");
            } else {
                System.out.println("No se pudo agregar la cuenta.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Manejo de errores
        }
    }

// Método para generar el número de cuenta automáticamente
    public String generarNumeroAleatorio() {
        // Generar un número aleatorio de 8 dígitos
        Random random = new Random();
        int numeroAleatorio = random.nextInt(90000000) + 10000000; // Genera un número entre 10000000 y 99999999
        return String.valueOf(numeroAleatorio);
    }

    @Override
    public void cancelarCuenta(CuentaEntidad cuenta) throws PersistenciaException {
        // Definir la consulta SQL para actualizar un cliente en la tabla 'clientes'
        String updateCliente = "UPDATE Cuentas SET estado='Cancelada' WHERE numCuenta = ? and Nip= ?";
        ConexionBD conexionBD = new ConexionBD();
        try ( Connection conexion = conexionBD.obtenerConexion();  PreparedStatement statement = conexion.prepareStatement(updateCliente)) {

            statement.setString(1, cuenta.getNumeroCuenta());
            statement.setString(2, cuenta.getNip());

            int filasAfectadas = statement.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("Cliente actualizado correctamente.");
            } else {
                System.out.println("No se encontró el cliente con numero de Cuenta: " + cuenta.getNumeroCuenta());
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Manejo de errores
        }
    }

    public void transaccion(CuentaDTO cuenta1, CuentaDTO cuenta2, double monto) throws PersistenciaException {

        String IniciarTransaccion = "START transaction";
        String SacarDinero = "UPDATE cuentas set saldo= saldo-? WHERE numeroCuenta=? ";
        String ObtenerDinero = "UPDATE cuentas set saldo= saldo+? WHERE numeroCuenta=? ";
        String cancelarTransaccion = "ROLLBACK";
        String finalizarTransaccion = "COMMIT";

        ConexionBD conexionBD = new ConexionBD();
        try ( Connection conexion = conexionBD.obtenerConexion();  PreparedStatement inicio = conexion.prepareStatement(IniciarTransaccion);  PreparedStatement sacar = conexion.prepareStatement(SacarDinero);  PreparedStatement obtener = conexion.prepareStatement(ObtenerDinero);  PreparedStatement finalizar = conexion.prepareStatement(finalizarTransaccion);  PreparedStatement cancelar = conexion.prepareStatement(cancelarTransaccion)) {

            inicio.execute();

            if (consultarSaldo(cuenta1).compareTo(new BigDecimal(monto)) < 0) {
                cancelar.execute();
                throw new PersistenciaException("Saldo insuficiente");
            }

            sacar.setDouble(1, monto);
            sacar.setString(2, cuenta1.getNumeroCuenta());
            sacar.executeUpdate();
            obtener.setDouble(1, monto);
            obtener.setString(2, cuenta2.getNumeroCuenta());
            obtener.executeUpdate();
            finalizar.execute();
        } catch (SQLException e) {
            throw new PersistenciaException("Error" + e.getMessage());
        }
    }

    @Override
    public BigDecimal consultarSaldo(CuentaDTO cuenta) throws PersistenciaException {
        String consultaSaldo = "Select saldo from cuentas where numeroCuenta=?";
        BigDecimal saldoDisponible = null;
        ConexionBD conexionBD = new ConexionBD();
        try ( Connection conexion = conexionBD.obtenerConexion();  PreparedStatement consulta = conexion.prepareStatement(consultaSaldo)) {
            consulta.setString(1, cuenta.getNumeroCuenta());
            ResultSet resultado = consulta.executeQuery();
            if (resultado.next()) {
                saldoDisponible = resultado.getBigDecimal("saldo");
                return saldoDisponible;

            } else {
                throw new PersistenciaException("Hubo un error");
            }
        } catch (SQLException e) {
            throw new PersistenciaException("Error" + e.getMessage());
        }
    }

    public void retiroSinCuenta(CuentaEntidad cuenta1, double monto) {
aaaaaaaa
    }
}
