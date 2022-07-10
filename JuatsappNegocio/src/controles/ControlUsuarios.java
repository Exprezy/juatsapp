/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controles;

import entidades.Usuario;
import interfaces.IDatos;

/**
 *
 * @author focod
 */
public class ControlUsuarios {

    private IDatos datos;
    String control;
    
    protected ControlUsuarios(IDatos datos){
        this.datos = datos;
    }
    
    public boolean guardarUsuario(Usuario usuario){
        return datos.guardarUsuario(usuario);
    }
    
    public Usuario verificarExistencia(String telefono){
        return datos.consultarUsuarioTelefono(telefono);
    }
    
}
