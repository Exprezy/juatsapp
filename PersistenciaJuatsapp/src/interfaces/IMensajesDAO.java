/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import dominio.Mensaje;
import excepciones.PersistenciaException;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author aldom
 */
public interface IMensajesDAO {
    public void agregar(Mensaje mensaje) throws PersistenciaException;
    public List<Mensaje> consultarChat(ObjectId idUsuarioEnvio, ObjectId idUsuarioRecibio)throws PersistenciaException;
    public List<Mensaje> consultarMensajes() throws PersistenciaException;
}
