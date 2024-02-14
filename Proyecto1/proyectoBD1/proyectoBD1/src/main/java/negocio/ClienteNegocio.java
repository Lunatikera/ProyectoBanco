/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import entidades.ClienteEntidad;
import persistencia.Interfaces.IClienteDAO;
import persistencia.PersistenciaException;

/**
 *
 * @author Usuario
 */
public class ClienteNegocio implements IClienteNegocio {

    private IClienteDAO clienteDAO;

    public ClienteNegocio(IClienteDAO clienteDAO) {
        this.clienteDAO = clienteDAO;
    }

    @Override
    public void actualizarCliente(ClienteEntidad cliente) throws NegocioException {
        this.verificarCamposVacios(cliente);
        this.verificarTextoCliente(cliente);
        this.edadMinima(cliente);
        try {
            clienteDAO.editar(cliente);
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al actualizar el cliente", e);
        }
    }

    private void verificarCamposVacios(ClienteEntidad cliente) throws NegocioException {
        if (cliente.getNombre() == null || cliente.getNombre().isEmpty() || cliente.getApellidoMa() == null || cliente.getApellidoMa().isEmpty()
                || cliente.getApellidoPa() == null || cliente.getApellidoPa().isEmpty() || cliente.getContraseña() == null || cliente.getContraseña().isEmpty()
                || cliente.getFechaNacimiento() == null || cliente.getDomicilio() == null || cliente.getDomicilio().isEmpty()) {
            throw new NegocioException("Todos los campos son obligatorios.");
        }
    }

    private void edadMinima(ClienteEntidad cliente) throws NegocioException {
        int edadMinima = 18;
        if (cliente.getEdad() < edadMinima) {
            throw new NegocioException("No cumples con la edad necesaria");
        }
    }

    private void verificarTextoCliente(ClienteEntidad cliente) throws NegocioException {
        int maxLongitudTexto = 30;
        int maxLongitudDomicilio = 100;
        if (cliente.getNombre().length() > maxLongitudTexto) {
            throw new NegocioException("El nombre no puede exceder " + maxLongitudTexto + " caracteres.");
        }
        if (cliente.getApellidoPa().length() > maxLongitudTexto) {
            throw new NegocioException("El apellido paterno no puede exceder " + maxLongitudTexto + " caracteres.");
        }
        if (cliente.getApellidoMa().length() > maxLongitudTexto) {
            throw new NegocioException("El apellido materno no puede exceder " + maxLongitudTexto + " caracteres.");
        }
        if (cliente.getContraseña().length() > maxLongitudTexto) {
            throw new NegocioException("La Contraseña no puede exceder " + maxLongitudTexto + " caracteres.");
        }
        if (cliente.getDomicilio().length() > maxLongitudDomicilio) {
            throw new NegocioException("El Domicilio no puede exceder " + maxLongitudDomicilio + " caracteres.");
        }
    }

    private void nombreUsuarioNoRepetido(ClienteEntidad cliente) throws NegocioException {
        try {
            if (clienteDAO.existeNombreUsuario(cliente.getNomUsuario())) {
                throw new NegocioException("Nombre de usuario ya esta en uso");

            }
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al agregar el cliente", e);

        }
    }

    @Override
    public void agregarCliente(ClienteEntidad cliente) throws NegocioException {
        this.verificarCamposVacios(cliente);
        this.verificarTextoCliente(cliente);
        this.edadMinima(cliente);
        this.nombreUsuarioNoRepetido(cliente);
        try {
            clienteDAO.agregar(cliente);
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al agregar el cliente", e);
        }
    }

    private void validacionIniciarSesion(String nombreUsuario, String contraseña) throws NegocioException {
        if (nombreUsuario == null || nombreUsuario.isEmpty() || contraseña == null || contraseña.isEmpty()) {
            throw new NegocioException("El nombre de usuario y la contraseña son obligatorios.");
        }
    }

    @Override
    public ClienteEntidad iniciarSesion(String nombreUsuario, String contraseña) throws NegocioException {
        this.validacionIniciarSesion(nombreUsuario, contraseña);
        try {
            ClienteEntidad cliente = clienteDAO.iniciarSesion(nombreUsuario, contraseña);
            if (cliente == null) {
                throw new NegocioException("Credenciales de inicio de sesión inválidas.");
            }
            return cliente;
        } catch (PersistenciaException e) {

            throw new NegocioException("Error al iniciar sesión", e);
        }

    }
}
