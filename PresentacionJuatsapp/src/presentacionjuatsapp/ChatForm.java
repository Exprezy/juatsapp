/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacionjuatsapp;

import dominio.Mensaje;
import dominio.Usuario;
import excepciones.PersistenciaException;
import implementaciones.ConexionBD;
import implementaciones.MensajesDAO;
import implementaciones.MensajesNegocio;
import implementaciones.UsuariosDAO;
import implementaciones.UsuariosNegocio;
import interfaces.IConexionBD;
import interfaces.IMensajesDAO;
import interfaces.IMensajesNegocio;
import interfaces.IUsuariosDAO;
import interfaces.IUsuariosNegocio;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

/**
 *
 * @author aldom
 */
public class ChatForm extends javax.swing.JFrame {

    IConexionBD conexionDB = new ConexionBD();
    private IUsuariosDAO usuarios = new UsuariosDAO(conexionDB);
    private IUsuariosNegocio negocio = new UsuariosNegocio(usuarios);
    private IMensajesDAO mensajes = new MensajesDAO(conexionDB);
    private IMensajesNegocio mensajesNegocio = new MensajesNegocio(mensajes);
    
    
    
    public String chat="";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RESET = "\u001B[0m";
    private int i;
    
    private Usuario usuario;
    private Usuario usuarioSeleccionadoPrevio;
    private Usuario usuarioElegido;
    private String msj = "";
    DateFormat dateFormat = new SimpleDateFormat("HH:mm");
    Date date = new Date();
    
    List<Mensaje> listaMensajes = new LinkedList<>();
    /**
     * Creates new form ChatForm
     */
    public ChatForm(Usuario usuario) {
        initComponents();
        usuarioElegido = new Usuario();
        usuarioSeleccionadoPrevio = new Usuario();
        this.usuario = usuario;
        setLocationRelativeTo(null);
        setVisible(true);
        generarComboboxUsuarios();
    }

    private void generarComboboxUsuarios(){
        
        List<Usuario> usuarios = negocio.consultarTodos();
        
        for (Usuario user : usuarios) {
            if(usuario.getId().toString().equalsIgnoreCase(user.getId().toString())){
            }else{
                cbxUsuario.addItem(user.getNombre());
            }
            
        }
    }

    public Date convertToDateViaSqlTimestamp(LocalDateTime dateToConvert) {
    return java.sql.Timestamp.valueOf(dateToConvert);
}

    public void generarChats(Usuario usuarioRecibido){
        //hora msj
        DateFormat dateFormat = new SimpleDateFormat("HH:mm");
        Date date = new Date();
        
        String nombreUsuarioEnvio = usuario.getNombre();
        String nombreUsuarioRecibido = usuarioRecibido.getNombre();
  
        this.listaMensajes = mensajesNegocio.consultarChat(this.usuario.getId(), usuarioRecibido.getId());
        List<Mensaje> chats = new LinkedList<>();
        
        for (Mensaje chat1 : listaMensajes) {
            if(usuario.getId().toString().equalsIgnoreCase(chat1.getUsuarioEnvio().toString())
                    || usuario.getId().toString().equalsIgnoreCase(chat1.getUsuarioRecibio().toString())
                    || usuarioRecibido.getId().toString().equalsIgnoreCase(chat1.getUsuarioEnvio().toString())
                    || usuarioRecibido.getId().toString().equalsIgnoreCase(chat1.getUsuarioRecibio().toString())){
                chats.add(chat1);
            }
        }
        
        chats = mensajesNegocio.consultarChat(this.usuario.getId(), usuarioRecibido.getId());
        String agregar="";
        
        
        for (Mensaje mensaje : chats) {
            if (mensaje.getUsuarioEnvio().equals(usuario.getId())) {
                
                dateFormat = new SimpleDateFormat("HH:mm");
                Date date1 = convertToDateViaSqlTimestamp(mensaje.getFechaMensaje());
                
                System.out.println("aa "+ mensaje);
                StyledDocument styledDocument = JPaneChat.getStyledDocument();
                SimpleAttributeSet right = new SimpleAttributeSet();
                StyleConstants.setAlignment(right, StyleConstants.ALIGN_RIGHT);
                styledDocument.setParagraphAttributes(0, styledDocument.getLength(), right, false);
                
                msj = mensaje.getTexto();
                agregar = this.usuario.getNombre()+": "+msj+"    "+dateFormat.format(date1)+"\n"+"\n";
                chat =chat+agregar;
            }
            if (mensaje.getUsuarioRecibio().equals(usuario.getId())) {
                
                dateFormat = new SimpleDateFormat("HH:mm");
                Date date1 = convertToDateViaSqlTimestamp(mensaje.getFechaMensaje());
                
                System.out.println("bb "+ mensaje);
                StyledDocument styledDocument = JPaneChat.getStyledDocument();
                SimpleAttributeSet right = new SimpleAttributeSet();
                StyleConstants.setAlignment(right, StyleConstants.ALIGN_RIGHT);
                styledDocument.setParagraphAttributes(0, styledDocument.getLength(), right, false);
                
                msj = mensaje.getTexto();
                agregar = usuarioRecibido.getNombre()+": "+msj+"    "+dateFormat.format(date1)+"\n"+"\n";
                chat =chat+agregar;
            }
            
            JPaneChat.setText(chat);
            
        }
    }

    public LocalDateTime convertToLocalDateTimeViaMilisecond(Date dateToConvert) {
        return Instant.ofEpochMilli(dateToConvert.getTime())
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        JPaneChat = new javax.swing.JTextPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txtMsj = new javax.swing.JTextField();
        btn = new javax.swing.JButton();
        cbxUsuario = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnConfiguración = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnEmpezar1 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("JautsApp | Chats");
        setAutoRequestFocus(false);
        setBackground(new java.awt.Color(153, 153, 153));
        setResizable(false);

        JPaneChat.setEditable(false);
        JPaneChat.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(JPaneChat);

        jPanel1.setBackground(new java.awt.Color(41, 171, 142));

        jLabel9.setText("JuatsApp");
        jLabel9.setFont(new java.awt.Font("Segoe UI Emoji", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 235, 235));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addContainerGap())
        );

        txtMsj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMsjActionPerformed(evt);
            }
        });
        txtMsj.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtMsjKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMsjKeyReleased(evt);
            }
        });

        btn.setText("Enviar");
        btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActionPerformed(evt);
            }
        });

        cbxUsuario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona" }));
        cbxUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxUsuarioActionPerformed(evt);
            }
        });

        jLabel1.setText("Usuarios");
        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(92, 92, 92));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Selecciona un usuario");
        jLabel2.setForeground(new java.awt.Color(124, 120, 120));

        btnConfiguración.setText("Configuración");
        btnConfiguración.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfiguraciónActionPerformed(evt);
            }
        });

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Y empieza una conversación...");
        jLabel3.setForeground(new java.awt.Color(124, 120, 120));

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Da clic en empezar");
        jLabel4.setForeground(new java.awt.Color(124, 120, 120));

        btnEmpezar1.setText("Empezar");
        btnEmpezar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmpezar1ActionPerformed(evt);
            }
        });

        jSeparator1.setBackground(new java.awt.Color(136, 136, 136));
        jSeparator1.setForeground(new java.awt.Color(136, 136, 136));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(100, 100, 100))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGap(59, 59, 59)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGap(56, 56, 56)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 15, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnConfiguración, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnEmpezar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbxUsuario, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addGap(45, 45, 45))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtMsj, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(btnEmpezar1)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator1)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMsj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn)
                    .addComponent(btnConfiguración))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtMsjActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMsjActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtMsjActionPerformed

    
    public boolean validacionesEnviar(){
        if(cbxUsuario.getSelectedItem().toString().equalsIgnoreCase("Selecciona")){
            JOptionPane.showMessageDialog(null, "Para poder mandar mensajes, seleccione un usuario y da clic en empezar", "Error", JOptionPane.ERROR_MESSAGE);
            return true;
        }
        if(txtMsj.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "No se permiten mensajes en blanco", "Error", JOptionPane.ERROR_MESSAGE);
            return true;
        }
        if(usuarioElegido.getNombre() == null){
            JOptionPane.showMessageDialog(null, "Has clic en Empezar y podrás mandar tu mensaje", "Error", JOptionPane.ERROR_MESSAGE);
            return true;
        }
        if(!cbxUsuario.getSelectedItem().toString().equalsIgnoreCase(usuarioSeleccionadoPrevio.getNombre())){
            JOptionPane.showMessageDialog(null, "Ha seleccionado un usuario diferente y no dio clic en Empezar", "Error", JOptionPane.ERROR_MESSAGE);
            return true;
        }
        return false;
        
        
    }
    public void enviarAlmacenarMensaje(){
        if(validacionesEnviar() == true){
            return;
        }
        
        DateFormat dateFormat = new SimpleDateFormat("HH:mm");
        Date date = new Date();

        String nombre = usuario.getNombre();
        String msj = txtMsj.getText();
        String agregar = nombre+": "+msj+"    "+dateFormat.format(date)+"\n";

        chat =chat+agregar;

        JPaneChat.setText(chat);

        LocalDateTime fechaMensaje = convertToLocalDateTimeViaMilisecond(date);
        Mensaje mensaje = new Mensaje(msj, usuario.getId(), usuarioElegido.getId(), fechaMensaje);
        mensajesNegocio.agregar(mensaje);
        
        StyledDocument styledDocument = JPaneChat.getStyledDocument();
        SimpleAttributeSet right = new SimpleAttributeSet();
        StyleConstants.setAlignment(right, StyleConstants.ALIGN_RIGHT);
        styledDocument.setParagraphAttributes(0, styledDocument.getLength(), right, false);

        if(i==2){JPaneChat.setForeground(Color.red);};

        txtMsj.setText("");
        usuarioSeleccionadoPrevio = usuarioElegido;
    }
    
    private void btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActionPerformed
        enviarAlmacenarMensaje();
    }//GEN-LAST:event_btnActionPerformed

    private void btnConfiguraciónActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfiguraciónActionPerformed
        // TODO add your handling code here:
        new ActualizarUsuarioForm(this.usuario);
        dispose();
    }//GEN-LAST:event_btnConfiguraciónActionPerformed

    private void btnEmpezar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmpezar1ActionPerformed
        // TODO add your handling code here:
       List<Usuario> usuarios = negocio.consultarTodos();
        for (Usuario user : usuarios) {
            if(!usuario.getId().toString().equalsIgnoreCase(user.getId().toString())){
                if(cbxUsuario.getSelectedItem().toString().equalsIgnoreCase(user.getNombre())){
                    usuarioElegido = user;
                    usuarioSeleccionadoPrevio = usuarioElegido;
                    break;
                }
            }
        }
        if(cbxUsuario.getSelectedItem().toString().equalsIgnoreCase("Selecciona")){
            JOptionPane.showMessageDialog(null, "Para poder mandar mensajes, selecciona un usuario y da clic en empezar", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        chat=" ";
        JPaneChat.setText(chat);
        
        generarChats(usuarioElegido);
        
    }//GEN-LAST:event_btnEmpezar1ActionPerformed

    private void cbxUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxUsuarioActionPerformed

    private void txtMsjKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMsjKeyPressed
        
    }//GEN-LAST:event_txtMsjKeyPressed

    private void txtMsjKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMsjKeyReleased
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            enviarAlmacenarMensaje();
        }
    }//GEN-LAST:event_txtMsjKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextPane JPaneChat;
    private javax.swing.JButton btn;
    private javax.swing.JButton btnConfiguración;
    private javax.swing.JButton btnEmpezar1;
    private javax.swing.JComboBox<String> cbxUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField txtMsj;
    // End of variables declaration//GEN-END:variables
}
