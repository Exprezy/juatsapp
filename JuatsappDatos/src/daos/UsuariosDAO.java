/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.regex;
import entidades.Usuario;
import interfaces.IConexionBD;
import interfaces.IUsuariosDAO;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

/**
 *
 * @author focod
 */
public class UsuariosDAO implements IUsuariosDAO {

    private final IConexionBD conexionBD;
    private final MongoDatabase baseDatos;

    public UsuariosDAO(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
        this.baseDatos = conexionBD.crearConexion();
    }

    @Override
    public MongoCollection<Usuario> obtenerColeccion() {
        return this.baseDatos.getCollection("usuarios", Usuario.class);
    }

    @Override
    public boolean agregar(Usuario usuario) {
        try {
            MongoCollection<Usuario> coleccion = this.obtenerColeccion();
            coleccion.insertOne(usuario);
            return true;
        } catch (Exception e) {
            System.err.println(e);
            return false;
        }
    }

    @Override
    public boolean eliminar(Usuario usuario) {
        try {
            MongoCollection<Usuario> coleccion = this.obtenerColeccion();
            Bson query = eq("_id", usuario.getId());
            coleccion.deleteOne(query);
            return true;
        } catch (Exception e) {
            System.err.println(e);
            return false;
        }
    }

    @Override
    public Usuario consultarPorCelular(String celular) {
        FindIterable<Usuario> registros = this.obtenerColeccion().find(regex("celular", "^" + celular + "$", "i"));
        Usuario usuario = registros.first();
        return usuario;
    }

    @Override
    public boolean actualizar(Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Usuario consultarPorID(ObjectId id) {
        FindIterable<Usuario> registros = this.obtenerColeccion().find(regex("celular", "^" + id + "$", "i"));
        Usuario usuario = registros.first();
        return usuario;
    }
    
    
}
