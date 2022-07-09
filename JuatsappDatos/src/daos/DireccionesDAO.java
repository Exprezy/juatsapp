/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import entidades.Direccion;
import entidades.Usuario;
import interfaces.IConexionBD;
import interfaces.IDireccionesDAO;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;
import org.bson.conversions.Bson;

/**
 *
 * @author focod
 */
public class DireccionesDAO implements IDireccionesDAO {

    private final IConexionBD conexionBD;
    private final MongoDatabase baseDatos;

    public DireccionesDAO(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
        this.baseDatos = conexionBD.crearConexion();
    }

    @Override
    public MongoCollection<Direccion> obtenerColeccion() {
        return this.baseDatos.getCollection("direcciones", Direccion.class);
    }

    @Override
    public boolean agregar(Direccion direccion) {
        try {
            MongoCollection<Direccion> coleccion = this.obtenerColeccion();
            coleccion.insertOne(direccion);
            return true;
        } catch (Exception e) {
            System.err.println(e);
            return false;
        }
    }

    @Override
    public boolean eliminar(Direccion direccion) {
        try {
            MongoCollection<Direccion> coleccion = this.obtenerColeccion();
            Bson query = eq("_id", direccion.getId());
            coleccion.deleteOne(query);
            return true;
        } catch (Exception e) {
            System.err.println(e);
            return false;
        }
    }

    @Override
    public List<Direccion> consultarPorDireccion(Usuario usuario) {
        MongoCollection<Direccion> coleccion = this.obtenerColeccion();
        Bson query = eq("usuario._id", usuario.getId());
        FindIterable<Direccion> iterable = coleccion.find(query);
        List<Direccion> listaDireccionesUsuario = new LinkedList<>();
        iterable.forEach((Consumer<Direccion>) (Direccion direccion) -> {
            listaDireccionesUsuario.add(direccion);
        });

        return listaDireccionesUsuario;
    }

}
