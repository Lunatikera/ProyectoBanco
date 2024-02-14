/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import dto.CuentaDTO;
import entidades.ClienteEntidad;
import entidades.CuentaEntidad;
import java.math.BigDecimal;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import persistencia.Interfaces.ICuentaDAO;
import persistencia.PersistenciaException;

/**
 *
 * @author Usuario
 */
public class CuentaNegocio implements ICuentaNegocio {

    private ICuentaDAO cuentaDAO;

    public CuentaNegocio(ICuentaDAO cuentaDAO) {
        this.cuentaDAO = cuentaDAO;
    }

    @Override
    public void agregarCuenta(CuentaEntidad cuenta, ClienteEntidad cliente) throws NegocioException {

        if (cuenta.getIdCliente() != cliente.getIdCliente()) {
            throw new NegocioException("Error con la cuenta y el cliente");
        }

        this.verificarCamposVaciosCuenta(cuenta);

        this.validacionesCliente(cliente);

        this.saldoPositivo(cuenta);

        try {
            cuentaDAO.agregar(cuenta, cliente);
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al agregar la cuenta", e);
        }

        this.longitudNumeroCuenta(cuenta);

    }

    @Override
    public void cancelarCuenta(CuentaEntidad cuenta) throws NegocioException {

        CuentaDTO cuentaDTO = this.convertirEntidad(cuenta);
        this.saldoNecesario(cuentaDTO);
        existeCuenta(cuenta);

        try {
            cuentaDAO.cancelarCuenta(cuenta);
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al cancelar la cuenta", e);
        }
    }

    @Override
    public void realizarTransferencia(CuentaDTO cuentaOrigen, CuentaDTO cuentaDestino, double monto) throws NegocioException {

        if (cuentaOrigen.getNumeroCuenta().equals(cuentaDestino.getNumeroCuenta())) {
            throw new NegocioException("No se puede transferir fondos a la misma cuenta.");
        }

        if (monto <= 0) {
            throw new NegocioException("El monto de la transferencia debe ser mayor que cero.");
        }

        BigDecimal saldoOrigen;
        try {
            saldoOrigen = cuentaDAO.consultarSaldo(cuentaOrigen);
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al consultar el saldo de la cuenta origen", e);
        }

        if (saldoOrigen.compareTo(BigDecimal.valueOf(monto)) < 0) {
            throw new NegocioException("La cuenta origen no tiene suficientes fondos para realizar la transferencia.");
        }

        try {
            cuentaDAO.transferencia(cuentaOrigen, cuentaDestino, monto);
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al realizar la transferencia", e);
        }
    }

    @Override
    public void generarRetiroSinCuenta(CuentaDTO cuentaOrigen, double monto) throws NegocioException {
        if (monto <= 0) {
            throw new NegocioException("El monto del retiro debe ser mayor que cero.");
        }

        BigDecimal saldoOrigen;
        try {
            saldoOrigen = cuentaDAO.consultarSaldo(cuentaOrigen);
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al consultar el saldo de la cuenta origen", e);
        }

        if (saldoOrigen.compareTo(BigDecimal.valueOf(monto)) < 0) {
            throw new NegocioException("La cuenta origen no tiene suficientes fondos para realizar la transferencia.");
        }
        try {
            cuentaDAO.generarRetiroSinCuenta(cuentaOrigen, monto);
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al generar el retiro sin cuenta", e);
        }
    }

    @Override
    public void disponerDineroRetiro(String folio, String contraseña) throws NegocioException {
        if (folio == null || folio.isEmpty() || contraseña == null || contraseña.isEmpty()) {
            throw new NegocioException("El folio y la contraseña son obligatorios.");
        }

        try {
            if (!cuentaDAO.existeFolio(folio)) {
                throw new NegocioException("El folio proporcionado no existe en el sistema.");
            }
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al verificar la existencia del folio", ex);
        }

        try {
            cuentaDAO.disponerDineroRetiro(folio, contraseña);
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al disponer dinero del retiro sin cuenta", e);
        }
    }

    public List<CuentaEntidad> obtenerTodasLasCuentas(ClienteEntidad cliente) throws NegocioException {
        try {
            List<CuentaEntidad> lista = cuentaDAO.obtenerTodasLasCuentas(cliente);
            if (cliente == null) {
                throw new NegocioException("Credenciales inválidas.");
            }
            return lista;
        } catch (PersistenciaException e) {

            throw new NegocioException("Error al iniciar sesión", e);
        }

    }

      
    private void cuentaUnica(CuentaEntidad cuenta) throws NegocioException {
        try {
            if (cuentaDAO.existeNumeroCuenta(cuenta.getNumeroCuenta())) {
                throw new NegocioException("El número de cuenta ya está en uso por otro cliente.");
            }

        } catch (PersistenciaException e) {
            throw new NegocioException("Error al agregar la cuenta", e);
        }
    }

    private void existeCuenta(CuentaEntidad cuenta) throws NegocioException {
        try {
            if (!cuentaDAO.existeNumeroCuenta(cuenta.getNumeroCuenta())) {
                throw new NegocioException("El número de cuenta No Existe");
            }

        } catch (PersistenciaException e) {
            throw new NegocioException("Error al agregar la cuenta", e);
        }
    }

    private void saldoPositivo(CuentaEntidad cuenta) throws NegocioException {
        if (cuenta.getSaldo().compareTo(BigDecimal.ZERO) < 0) {
            throw new NegocioException("El saldo inicial no puede ser negativo.");
        }
    }

    private void longitudNumeroCuenta(CuentaEntidad cuenta) throws NegocioException {
        int longitudNumeroCuenta = cuenta.getNumeroCuenta().length();
        int longitud = 16;
        if (longitudNumeroCuenta != longitud) {
            throw new NegocioException("El número de cuenta debe tener " + longitud + " caracteres.");
        }
    }

    private void validacionesCliente(ClienteEntidad cliente) throws NegocioException {
        if (cliente.getIdCliente() <= 0) {
            throw new NegocioException("Error con la cuenta");
        }
    }

    private void verificarCamposVaciosCuenta(CuentaEntidad cuenta) throws NegocioException {
        if (cuenta.getIdCliente() <= 0
                || cuenta.getSaldo() == null || cuenta.getNip() == null) {
            throw new NegocioException("Todos los campos de la cuenta son obligatorios.");
        }

    }

    private void saldoNecesario(CuentaDTO cuenta) throws NegocioException {
        try {
            if (cuentaDAO.consultarSaldo(cuenta).compareTo(BigDecimal.ZERO) > 0) {
                throw new NegocioException("Aun Cuenta con dinero en la cuenta");
            }

        } catch (PersistenciaException e) {
            throw new NegocioException("Error al agregar el cliente", e);

        }
    }

    private CuentaDTO convertirEntidad(CuentaEntidad cuenta) {
        CuentaDTO cuentadto = new CuentaDTO();
        // Populate entity fields from DTO
        cuentadto.setIdCliente(cuenta.getIdCliente());
        cuentadto.setNumeroCuenta(cuenta.getNumeroCuenta());
        // Populate other fields as needed
        return cuentadto;
    }
}
