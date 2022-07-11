/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementaciones;

import excepciones.PersistenciaException;
import interfaces.IConexionBD;
import interfaces.IUsuariosDAO;
import interfaces.IUsuariosNegocio;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import dominio.Usuario;
import java.util.LinkedList;

/**
 *
 * @author aldom
 */
public class UsuariosNegocio implements IUsuariosNegocio{
    IUsuariosDAO usuariosDAO;

    public UsuariosNegocio(IUsuariosDAO usuariosDAO) {
        this.usuariosDAO = usuariosDAO;
    }
    
    
    @Override
    public boolean agregar(Usuario usuario) {
        try {
            this.usuariosDAO.agregar(usuario);
            return true;
        } catch (PersistenciaException ex) {
            Logger.getLogger(UsuariosNegocio.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public Usuario consultar(String telefono) {
        try {
            Usuario usuario = this.usuariosDAO.consultar(telefono);
            return usuario;
        } catch (PersistenciaException ex) {
            Logger.getLogger(UsuariosNegocio.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public boolean actualizar(Usuario usuario) {
        try {
            this.usuariosDAO.actualizar(usuario);
            return true;
        } catch (PersistenciaException ex) {
            Logger.getLogger(UsuariosNegocio.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public List<Usuario> consultarTodos() {
        try {
            List<Usuario> listaUsuarios = new LinkedList<>();
            listaUsuarios = this.usuariosDAO.consultarTodos();
            return listaUsuarios;
        } catch (PersistenciaException ex) {
            Logger.getLogger(UsuariosNegocio.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
}
