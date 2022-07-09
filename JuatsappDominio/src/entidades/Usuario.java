/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.time.LocalDate;
import java.util.Objects;
import org.bson.types.ObjectId;

/**
 *
 * @author focod
 */
public class Usuario {

    private ObjectId id;
    private String telefono;
    private String contrasena;
    private String sexo;
    private LocalDate fechaNacimiento;
    private Direccion direccion;

    public Usuario() {
    }

    public Usuario(String telefono, String contrasena, String sexo, LocalDate fechaNacimiento, Direccion direccion) {
        this.telefono = telefono;
        this.contrasena = contrasena;
        this.sexo = sexo;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
    }

    public Usuario(ObjectId id, String telefono, String contrasena, String sexo, LocalDate fechaNacimiento, Direccion direccion) {
        this.id = id;
        this.telefono = telefono;
        this.contrasena = contrasena;
        this.sexo = sexo;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefonor(String telefono) {
        this.telefono = telefono;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
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

    public void generarId() {
        this.id = new ObjectId();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.id);
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
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", telefono=" + telefono + ", contrasena=" + contrasena + ", sexo=" + sexo + ", fechaNacimiento=" + fechaNacimiento + ", direccion=" + direccion + '}';
    }

    

}
