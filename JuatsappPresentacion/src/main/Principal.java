/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import daos.ConexionBD;
import daos.UsuariosDAO;
import entidades.Usuario;
import interfaces.IConexionBD;
import interfaces.IUsuariosDAO;
import java.time.LocalDate;



/**
 *
 * @author focod
 */
public class Principal {

    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        LocalDate fecha = LocalDate.parse("2001-11-05");
        
        IConexionBD conexionBD = new ConexionBD();
        IUsuariosDAO usuariosDAO = new UsuariosDAO(conexionBD);
        
//        Usuario usuario = new Usuario("daniel", fecha);
//        usuariosDAO.agregar(usuario);

//          Usuario usuario = new Usuario("")
        
    }
    
}
