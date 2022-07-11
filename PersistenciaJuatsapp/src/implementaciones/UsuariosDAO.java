/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementaciones;

import com.mongodb.DB;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import excepciones.PersistenciaException;
import interfaces.IConexionBD;
import interfaces.IUsuariosDAO;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import dominio.Usuario;
import org.bson.Document;

/**
 *
 * @author aldom
 */
public class UsuariosDAO implements IUsuariosDAO{

    private IConexionBD conexionBD;

    public UsuariosDAO(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }
    
    @Override
    public void agregar(Usuario usuario) throws PersistenciaException {
        try {
            MongoDatabase baseDatos = conexionBD.crearConexion();
            MongoCollection<Usuario> coleccion = baseDatos.getCollection("usuarios", Usuario.class);
            coleccion.insertOne(usuario);
        } catch (Exception ex) {
            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenciaException("No se pudo agregar al usuario");
        }
    }

    
    @Override
    public void actualizar(Usuario usuario) throws PersistenciaException {
        try {
            MongoDatabase baseDatos = conexionBD.crearConexion();
            MongoCollection<Usuario> coleccion = baseDatos.getCollection("usuarios", Usuario.class);
            
            Document updateFilter = new Document("_id", usuario.getId());
            Document changes = new Document();
            changes.append("$set", new Document()
                .append("nombre", usuario.getNombre())
                .append("telefono", usuario.getTelefono())
                .append("contraseña", usuario.getContraseña())
                .append("direccion", usuario.getDireccion())
                .append("fechaNacimiento", usuario.getFechaNacimiento())
                .append("sexo", usuario.getSexo())
            );
            coleccion.updateOne(updateFilter, changes);
        } catch (Exception ex) {
            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenciaException("No se pudo actualizar al usuario");
        }
    }       

    public Usuario consultar(String telefono) throws PersistenciaException {
        try {
            MongoDatabase baseDatos = conexionBD.crearConexion();
            MongoCollection<Usuario> coleccion = baseDatos.getCollection("usuarios", Usuario.class);
            Document updateFilter = new Document().append("telefono", telefono);
            FindIterable<Usuario> usuarios = coleccion.find(updateFilter);
            Usuario usuario = usuarios.first();
            return usuario;
        } catch (Exception ex) {
            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenciaException("No se pudo consultar al usuario");
        }
    }

    @Override
    public List<Usuario> consultarTodos() throws PersistenciaException {
        try {
            MongoDatabase baseDatos = conexionBD.crearConexion();
            MongoCollection<Usuario> coleccion = baseDatos.getCollection("usuarios", Usuario.class);
            FindIterable<Usuario> usuarios = coleccion.find();
            List<Usuario> listaUsuarios = new LinkedList<>();
            usuarios.into(listaUsuarios); 
            return listaUsuarios;
            
        } catch (Exception ex) {
            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenciaException("No se pudo consultar al usuario");
        }
    }
}
