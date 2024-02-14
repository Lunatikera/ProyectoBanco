/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

/**
 *
 * @author Usuario
 */
public class ClienteEntidad {

    private int idCliente;
    private String nombre;
    private String nomUsuario;
    private String contraseña;
    private String apellidoPa;
    private String apellidoMa;
    private LocalDate fechaNacimiento;
    private String domicilio;

    // Constructor
    public ClienteEntidad(int idCliente, String nombre, String nomUsuario, String contraseña, String apellidoPa,
            String apellidoMa, LocalDate fechaNacimiento, String domicilio) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.nomUsuario = nomUsuario;
        this.contraseña = contraseña;
        this.apellidoPa = apellidoPa;
        this.apellidoMa = apellidoMa;
        this.fechaNacimiento = fechaNacimiento;
        this.domicilio = domicilio;
    }

    public ClienteEntidad(String nombre, String nomUsuario, String contraseña, String apellidoPa, String apellidoMa,LocalDate fechaNacimiento,String domicilio) {
        this.nombre = nombre;
        this.nomUsuario = nomUsuario;
        this.contraseña = contraseña;
        this.apellidoPa = apellidoPa;
        this.apellidoMa = apellidoMa;
        this.fechaNacimiento=fechaNacimiento;
        this.domicilio = domicilio;
    }
   

    public ClienteEntidad() {
    }

    // Getters and Setters
    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNomUsuario() {
        return nomUsuario;
    }

    public void setNomUsuario(String nomUsuario) {
        this.nomUsuario = nomUsuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getApellidoPa() {
        return apellidoPa;
    }

    public void setApellidoPa(String apellidoPa) {
        this.apellidoPa = apellidoPa;
    }

    public String getApellidoMa() {
        return apellidoMa;
    }

    public void setApellidoMa(String apellidoMa) {
        this.apellidoMa = apellidoMa;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public int getEdad() {
        LocalDate fechaActual = LocalDate.now();
        Period periodo = Period.between(fechaNacimiento, fechaActual);
        int edad= periodo.getYears();
        return edad;
    }

    @Override
    public String toString() {
        return "ClienteEntidad{" + "idCliente=" + idCliente + ", nombre=" + nombre + ", nomUsuario=" + nomUsuario + ", contrase\u00f1a=" + contraseña + ", apellidoPa=" + apellidoPa + ", apellidoMa=" + apellidoMa + ", fechaNacimiento=" + fechaNacimiento + ", domicilio=" + domicilio + '}';
    }
    
    
}
