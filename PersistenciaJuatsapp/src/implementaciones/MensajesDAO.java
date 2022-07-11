/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementaciones;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.gt;
import static com.mongodb.client.model.Filters.or;
import excepciones.PersistenciaException;
import interfaces.IConexionBD;
import interfaces.IMensajesDAO;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import dominio.Mensaje;
import dominio.Usuario;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

/**
 *
 * @author aldom
 */
public class MensajesDAO implements IMensajesDAO {

    private IConexionBD conexionBD;

    public MensajesDAO(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }
    
    @Override
    public void agregar(Mensaje mensaje) throws PersistenciaException {
        try {
            MongoDatabase baseDatos = conexionBD.crearConexion();
            MongoCollection<Mensaje> coleccion = baseDatos.getCollection("mensajes", Mensaje.class);
            coleccion.insertOne(mensaje);
        } catch (Exception ex) {
            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenciaException("No se pudo agregar el mensaje");
        }
    }
    
//    //List<Document> direcciones = new LinkedList<>();
//        direcciones.add(new Document("calle", "Palo Alto").append("numero", "1534").append("colonia", "Santa Clara"));
//        direcciones.add(new Document("calle", "Cactus St.").append("numero", "210").append("colonia", "Mountain View"));

    @Override
    public List<Mensaje> consultarChat(ObjectId idUsuarioEnvio, ObjectId idUsuarioRecibio) throws PersistenciaException {
        try {
            MongoDatabase baseDatos = conexionBD.crearConexion();
            MongoCollection<Mensaje> coleccion = baseDatos.getCollection("mensajes", Mensaje.class);
 
            
            List<Mensaje> listaMensajes = new LinkedList<>();
            
            Bson filtro1 = eq("usuarioEnvio", idUsuarioEnvio);
            Bson filtro2 = eq("usuarioRecibio", idUsuarioRecibio);
            
            Bson filtros1 = and(filtro1, filtro2);
            
            Bson filtro3 = eq("usuarioEnvio", idUsuarioRecibio);
            Bson filtro4 = eq("usuarioRecibio", idUsuarioEnvio);
            
            Bson filtros12 = and(filtro3, filtro4);
            
            Bson filtros = or(filtros1, filtros12);
            
            coleccion.find(filtros).into(listaMensajes);
            
            return listaMensajes;
        } catch (Exception ex) {
            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenciaException("No se pudo consultar el chat");
        }
    }
    
    public List<Mensaje> consultarMensajes() throws PersistenciaException{
        try {
            MongoDatabase baseDatos = conexionBD.crearConexion();
            MongoCollection<Mensaje> coleccion = baseDatos.getCollection("mensajes", Mensaje.class);
 
            FindIterable<Mensaje> mensajes = coleccion.find();
            List<Mensaje> listaMensajes = new LinkedList<>();
            mensajes.into(listaMensajes); 
            return listaMensajes;
        } catch (Exception ex) {
            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenciaException("No se pudo consultar la lista de mensajes");
        }
        
    }
    
}
