/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import com.mongodb.DB;
import dominio.Usuario;
import excepciones.PersistenciaException;
import java.util.List;

/**
 *
 * @author aldom
 */
public interface IUsuariosDAO {
    public void agregar(Usuario usuario) throws PersistenciaException;
    public Usuario consultar(String telefono) throws PersistenciaException;
    public void actualizar(Usuario usuario) throws PersistenciaException;
    public List<Usuario> consultarTodos() throws PersistenciaException;
}
