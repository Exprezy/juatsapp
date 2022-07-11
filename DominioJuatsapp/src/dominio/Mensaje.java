/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Objects;
import org.bson.types.ObjectId;

/**
 *
 * @author aldom
 */
public class Mensaje {
    private ObjectId id;
    private String texto;
    private ObjectId usuarioEnvio;
    private ObjectId usuarioRecibio;
    private LocalDateTime fechaMensaje;

    public Mensaje() {
    }

    public Mensaje(String texto, ObjectId usuarioEnvio, ObjectId usuarioRecibio, LocalDateTime fechaMensaje) {
        this.texto = texto;
        this.usuarioEnvio = usuarioEnvio;
        this.usuarioRecibio = usuarioRecibio;
        this.fechaMensaje = fechaMensaje;
    }

    public Mensaje(ObjectId id, String texto, ObjectId usuarioEnvio, ObjectId usuarioRecibio, LocalDateTime fechaMensaje) {
        this.id = id;
        this.texto = texto;
        this.usuarioEnvio = usuarioEnvio;
        this.usuarioRecibio = usuarioRecibio;
        this.fechaMensaje = fechaMensaje;
    }

    public Mensaje(String texto) {
        this.texto = texto;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public ObjectId getUsuarioEnvio() {
        return usuarioEnvio;
    }

    public void setUsuarioEnvio(ObjectId usuarioEnvio) {
        this.usuarioEnvio = usuarioEnvio;
    }

    public ObjectId getUsuarioRecibio() {
        return usuarioRecibio;
    }

    public void setUsuarioRecibio(ObjectId usuarioRecibio) {
        this.usuarioRecibio = usuarioRecibio;
    }

    public LocalDateTime getFechaMensaje() {
        return fechaMensaje;
    }

    public void setFechaMensaje(LocalDateTime fechaMensaje) {
        this.fechaMensaje = fechaMensaje;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.id);
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
        final Mensaje other = (Mensaje) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Mensaje{" + "texto=" + texto + ", usuarioEnvio=" + usuarioEnvio + ", usuarioRecibio=" + usuarioRecibio + '}'+"\n";
    }

    
    
    
    
    
}
