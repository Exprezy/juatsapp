/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import dominio.Mensaje;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author aldom
 */
public interface IMensajesNegocio {
    public boolean agregar(Mensaje mensaje);
    public List<Mensaje> consultarChat(ObjectId idUsuarioEnvio, ObjectId idUsuarioRecibio);
    public List<Mensaje> consultarMensajes();
}
