/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import com.mongodb.client.MongoCollection;
import entidades.Usuario;
import org.bson.types.ObjectId;

/**
 *
 * @author focod
 */
public interface IUsuariosDAO {
    
    public MongoCollection<Usuario> obtenerColeccion();
    
    public boolean agregar(Usuario usuario);
    
    public boolean actualizar(Usuario usuario);
    
    public boolean eliminar(Usuario usuario);
    
    public Usuario consultarPorCelular(String celular);
    
    public Usuario consultarPorID(ObjectId id);
}
