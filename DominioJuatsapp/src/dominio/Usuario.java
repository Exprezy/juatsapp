/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;
import org.bson.types.ObjectId;

/**
 *
 * @author aldom
 */
public class Usuario {
    private ObjectId id;
    private String nombre;
    private String telefono;
    private String contraseña;
    private LocalDate fechaNacimiento;
    private Direccion direccion;
    private String sexo;

    public Usuario() {
    }

    public Usuario(String nombre, String telefono, String contraseña, LocalDate fechaNacimiento, Direccion direccion, String sexo) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.contraseña = contraseña;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
        this.sexo = sexo;
    }

    public Usuario(ObjectId id, String nombre, String telefono, String contraseña, LocalDate fechaNacimiento, Direccion direccion, String sexo) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.contraseña = contraseña;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
        this.sexo = sexo;
    }

    public Usuario(ObjectId id, String nombre, String telefono, String contraseña) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.contraseña = contraseña;
    }

    public Usuario(ObjectId id, String contraseña) {
        this.id = id;
        this.contraseña = contraseña;
    }

    
    
    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombre;
    }

    
    
    
    
    
}
