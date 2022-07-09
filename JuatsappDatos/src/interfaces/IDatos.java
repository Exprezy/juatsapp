/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import entidades.Direccion;
import entidades.Usuario;
import java.util.List;

/**
 *
 * @author focod
 */
public interface IDatos {

    boolean guardarUsuario(Usuario usuario);
    
    boolean eliminarUsuario(Usuario usuario);
    
    Usuario consultarUsuarioTelefono(String telefono);
    
    boolean guardarDireccion(Direccion direccion);
    
    boolean eliminarDireccion(Direccion direccion);
    
}
