/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import dominio.Usuario;
import java.util.List;

/**
 *
 * @author aldom
 */
public interface IUsuariosNegocio {
    public boolean agregar(Usuario usuario);
    public Usuario consultar(String telefono);
    public boolean actualizar(Usuario usuario);
    public List<Usuario> consultarTodos();
}
