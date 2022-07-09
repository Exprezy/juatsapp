/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import com.mongodb.client.MongoCollection;
import entidades.Direccion;
import entidades.Usuario;
import java.util.List;

/**
 *
 * @author focod
 */
public interface IDireccionesDAO {
    public MongoCollection<Direccion> obtenerColeccion();
    
    public boolean agregar(Direccion direccion);
    
    public boolean eliminar(Direccion direccion);
    
    public List<Direccion> consultarPorDireccion(Usuario usuario);
}
