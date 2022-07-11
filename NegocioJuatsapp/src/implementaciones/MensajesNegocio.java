/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementaciones;

import dominio.Mensaje;
import excepciones.PersistenciaException;
import interfaces.IMensajesDAO;
import interfaces.IMensajesNegocio;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bson.types.ObjectId;

/**
 *
 * @author aldom
 */
public class MensajesNegocio implements IMensajesNegocio{

    IMensajesDAO mensajesDAO;

    public MensajesNegocio(IMensajesDAO mensajesDAO) {
        this.mensajesDAO = mensajesDAO;
    }
    
    @Override
    public boolean agregar(Mensaje mensaje) {
        try {
            this.mensajesDAO.agregar(mensaje);
            return true;
        } catch (PersistenciaException ex) {
            Logger.getLogger(UsuariosNegocio.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public List<Mensaje> consultarChat(ObjectId idUsuarioEnvio, ObjectId idUsuarioRecibio) {
        try {
            List<Mensaje> chat = new LinkedList<>();
            chat = this.mensajesDAO.consultarChat(idUsuarioEnvio, idUsuarioRecibio);
            return chat;
        } catch (PersistenciaException ex) {
            Logger.getLogger(UsuariosNegocio.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public List<Mensaje> consultarMensajes() {
        try {
            List<Mensaje> chat = new LinkedList<>();
            chat = this.mensajesDAO.consultarMensajes();
            return chat;
        } catch (PersistenciaException ex) {
            Logger.getLogger(UsuariosNegocio.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
}
