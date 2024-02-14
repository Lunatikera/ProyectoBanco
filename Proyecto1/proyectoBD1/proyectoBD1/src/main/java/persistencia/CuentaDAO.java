/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import dto.CuentaDTO;
import dto.TransaccionDTO;
import entidades.ClienteEntidad;
import entidades.CuentaEntidad;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import persistencia.Interfaces.IConexionBD;
import persistencia.Interfaces.ICuentaDAO;

/**
 *
 * @author Usuario
 */
public class CuentaDAO implements ICuentaDAO {

    private IConexionBD conexionBD;
    private static final Set<String> numerosGenerados = new HashSet<>();

    public CuentaDAO(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }

    @Override
    public void agregar(CuentaEntidad cuenta, ClienteEntidad cliente) throws PersistenciaException {
        // Definir la consulta SQL para insertar una nueva cuenta en la tabla 'Cuenta'
        String insertCuenta = "INSERT INTO Cuentas (numeroCuenta, saldo, Nip, id_Cliente) VALUES (?, ?, ?, ?, ?)";
        try ( Connection conexion = conexionBD.obtenerConexion();  PreparedStatement statement = conexion.prepareStatement(insertCuenta)) {
            // Generar el número de cuenta automáticamente (puedes implementar la lógica para generarlo)
            String numeroCuenta = generarNumeroAleatorioUnico(); // Implementa este método según tu lógica de generación de número de cuenta
            statement.setString(1, numeroCuenta);
            statement.setBigDecimal(2,  cuenta.getSaldo());
            statement.setString(5, cuenta.getNip());
            statement.setInt(6, cliente.getIdCliente());
            int filasAfectadas = statement.executeUpdate();
            if (filasAfectadas > 0) {
                System.out.println("Cuenta agregada correctamente.");
            } else {
                System.out.println("No se pudo agregar la cuenta.");
            }
        } catch (SQLException e) {
            throw new PersistenciaException("Error" + e.getMessage());
            // Manejo de errores
        }
    }

// Método para generar el número de cuenta automáticamente
     private static String generarNumeroAleatorioUnico() {
    Random random = new Random();
    StringBuilder numeroAleatorioBuilder = new StringBuilder();
    
    for (int i = 0; i < 16; i++) {
        int digito = random.nextInt(10); // Genera un dígito aleatorio entre 0 y 9
        numeroAleatorioBuilder.append(digito);
    }
    
    String numeroAleatorio = numeroAleatorioBuilder.toString();
    
    if (numerosGenerados.contains(numeroAleatorio)) {
        // Si el número generado ya existe, llama recursivamente al método para generar uno nuevo
        return generarNumeroAleatorioUnico();
    } else {
        numerosGenerados.add(numeroAleatorio);
        return numeroAleatorio;
    }
}

    @Override
    public void cancelarCuenta(CuentaEntidad cuenta) throws PersistenciaException {
        // Definir la consulta SQL para actualizar un cliente en la tabla 'clientes'
        String updateCliente = "UPDATE Cuentas SET estado='Cancelada' WHERE numCuenta = ? and Nip= ?";
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
            throw new PersistenciaException("Error" + e.getMessage());
            // Manejo de errores
        }
    }

    @Override
    public void transferencia(CuentaDTO cuenta1, CuentaDTO cuenta2, double monto) throws PersistenciaException {

        String IniciarTransaccion = "START transaction";
        String SacarDinero = "UPDATE cuentas set saldo= saldo-? WHERE numeroCuenta=? ";
        String ObtenerDinero = "UPDATE cuentas set saldo= saldo+? WHERE numeroCuenta=? ";
        String cancelarTransaccion = "ROLLBACK";
        String finalizarTransaccion = "COMMIT";

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
            agregarTransferencia(cuenta1, cuenta2, monto);
        } catch (SQLException e) {
            throw new PersistenciaException("Error" + e.getMessage());
        }
    }

    private void agregarTransferencia(CuentaDTO cuenta1, CuentaDTO cuenta2, double monto) throws PersistenciaException {
        String anadirTransaccion = "INSERT INTO transacciones(monto, id_CuentaOrigen) values (?,?)";
        String anadirTransferencia = "INSERT INTO transferencias(id_transaccion, id_CuentaDestino) values (LAST_INSERT_ID(), ?)";
        try ( Connection conexion = conexionBD.obtenerConexion();  PreparedStatement transaccion = conexion.prepareStatement(anadirTransaccion);  PreparedStatement transferencia = conexion.prepareStatement(anadirTransferencia)) {
            transaccion.setDouble(1, monto);
            transaccion.setInt(2, cuenta1.getIdCliente());
            transferencia.setInt(1, cuenta2.getIdCliente());
            if (consultarSaldo(cuenta1).compareTo(new BigDecimal(monto)) < 0) {
                throw new PersistenciaException("Saldo insuficiente");
            }
            int filasAfectadas = transaccion.executeUpdate();
            if (filasAfectadas > 0) {
                System.out.println("Cuenta agregada correctamente.");
            } else {
                throw new PersistenciaException("error");
            }
            int filasAfectadas2 = transferencia.executeUpdate();
            if (filasAfectadas2 > 0) {
                System.out.println("Cuenta agregada correctamente.");
            } else {
                throw new PersistenciaException("error");
            }
        } catch (SQLException e) {
            throw new PersistenciaException("Error" + e.getMessage());
            // Manejo de errores
        }
    }

    @Override
    public BigDecimal consultarSaldo(CuentaDTO cuenta) throws PersistenciaException {
        String consultaSaldo = "Select saldo from cuentas where numeroCuenta=?";
        BigDecimal saldoDisponible = null;
        try ( Connection conexion = conexionBD.obtenerConexion();  PreparedStatement consulta = conexion.prepareStatement(consultaSaldo)) {
            consulta.setString(1, cuenta.getNumeroCuenta());
            ResultSet resultado = consulta.executeQuery();
            if (resultado.next()) {
                saldoDisponible = resultado.getBigDecimal("saldo");
                return saldoDisponible;

            } else {
                throw new PersistenciaException("No hay");
            }
        } catch (SQLException e) {
            throw new PersistenciaException("Error" + e.getMessage());
        }
    }

    public void generarRetiroSinCuenta(CuentaDTO cuenta1, double monto) throws PersistenciaException {
        String insertarTransaccion = "INSERT INTO Transacciones(monto, id_CuentaOrigen) values (?,?)";
        String insertarRetiro = "INSERT INTO RetiroSinCuentas(id_Transaccion) values(LAST_INSERT_ID())";
        try ( Connection conexion = conexionBD.obtenerConexion();  PreparedStatement transaccion = conexion.prepareStatement(insertarTransaccion);  PreparedStatement retiro = conexion.prepareStatement(insertarRetiro)) {
            transaccion.setDouble(1, monto);
            transaccion.setInt(2, cuenta1.getIdCliente());

            int filasAfectadas = transaccion.executeUpdate();
            if (filasAfectadas > 0) {
                System.out.println("Cuenta agregada correctamente.");
            } else {
                throw new PersistenciaException("error");
            }
            int filasAfectadas2 = retiro.executeUpdate();
            if (filasAfectadas2 > 0) {
                System.out.println("Cuenta agregada correctamente.");
            } else {
                throw new PersistenciaException("error");
            }
        } catch (SQLException ex) {
            throw new PersistenciaException("Error" + ex.getMessage());
        }
    }

    public void disponerDineroRetiro(String folio, String contraseña) throws PersistenciaException {
        String iniciarTransaccion = "START transaction";
        String cambiarEstado = "UPDATE RetiroSinCuentas SET estado=?, fechaCobro= NOW() WHERE id_Transaccion=? and contraseña=? ";
        String sacarDinero = "UPDATE cuentas set saldo= saldo-? WHERE numeroCuenta=? ";
        String cancelarTransaccion = "ROLLBACK";
        String finalizarTransaccion = "COMMIT";
        try ( Connection conexion = conexionBD.obtenerConexion();  PreparedStatement inicio = conexion.prepareStatement(iniciarTransaccion);  PreparedStatement sacar = conexion.prepareStatement(sacarDinero);  PreparedStatement finalizar = conexion.prepareStatement(finalizarTransaccion);  PreparedStatement cancelar = conexion.prepareStatement(cancelarTransaccion);  PreparedStatement cambiar = conexion.prepareStatement(cambiarEstado)) {
            inicio.execute();
            TransaccionDTO datos = obtenerDatos(folio, contraseña);
            cambiar.setString(1, "COBRADO");
            cambiar.setInt(2, datos.getIdTransaccion());
            cambiar.setString(3, contraseña);
            cambiar.executeUpdate();
            sacar.setBigDecimal(1, datos.getMonto());
            sacar.setInt(2, datos.getIdCuentaOrigen());
            sacar.executeUpdate();
            finalizar.execute();
        } catch (SQLException ex) {
            throw new PersistenciaException("Error" + ex.getMessage());
        }
    }

    public TransaccionDTO obtenerDatos(String folio, String contraseña) throws PersistenciaException {
        String consultarRetiro = "SELECT id_Transaccion, monto,id_CuentaOrigen FROM Transacciones WHERE folio = ?";
        try ( Connection conexion = conexionBD.obtenerConexion();  PreparedStatement retiro = conexion.prepareStatement(consultarRetiro)) {

            retiro.setString(1, folio);

            try ( ResultSet resultSet = retiro.executeQuery()) {
                if (resultSet.next()) {
                    int idTransaccion = resultSet.getInt("id_Transaccion");
                    BigDecimal monto = resultSet.getBigDecimal("monto");
                    int IdCuentaOrigen = resultSet.getInt("id_CuentaOrigen");
                    return new TransaccionDTO(idTransaccion, monto, folio, IdCuentaOrigen);
                } else {
                    throw new PersistenciaException("No se encontró un retiro sin cuenta con el folio y contraseña proporcionados.");
                }

            }
        } catch (SQLException ex) {
            throw new PersistenciaException("Error al obtener los datos del retiro sin cuenta: " + ex.getMessage());
        }
    }
    
    public boolean existeNumeroCuenta(String numeroCuenta) throws PersistenciaException {
    String consulta = "SELECT COUNT(*) AS cuenta FROM Cuentas WHERE numeroCuenta = ?";
    
    try (Connection conexion = conexionBD.obtenerConexion();
         PreparedStatement statement = conexion.prepareStatement(consulta)) {
        
        statement.setString(1, numeroCuenta);
        ResultSet resultSet = statement.executeQuery();
        
        if (resultSet.next()) {
            int cuenta = resultSet.getInt("cuenta");
            return cuenta > 0;
        } else {
            return false;
        }
    } catch (SQLException e) {
        throw new PersistenciaException("Error al verificar la existencia del número de cuenta: " + e.getMessage());
    }
}
    
    public boolean existeFolio(String folio) throws PersistenciaException {
    String consultaFolio = "SELECT COUNT(*) AS total FROM Transacciones WHERE folio = ?";
    try (Connection conexion = conexionBD.obtenerConexion();
         PreparedStatement statement = conexion.prepareStatement(consultaFolio)) {
        statement.setString(1, folio);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            int total = resultSet.getInt("total");
            return total > 0; // Si el total es mayor que cero, significa que el folio existe
        } else {
            throw new PersistenciaException("Error al verificar la existencia del folio.");
        }
    } catch (SQLException e) {
        throw new PersistenciaException("Error al verificar la existencia del folio: " + e.getMessage());
    }
}

}
