/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controles;

import entidades.Direccion;
import interfaces.IDatos;

/**
 *
 * @author focod
 */
public class ControlDirecciones {
    private IDatos datos;
    
    protected ControlDirecciones(IDatos datos){
        this.datos = datos;
    }
    
    public boolean guardarDireccion(Direccion direccion){
        return datos.guardarDireccion(direccion);
    }
    
    public boolean eliminarDireccion(Direccion direccion) {
        return datos.eliminarDireccion(direccion);
    }
    
}
