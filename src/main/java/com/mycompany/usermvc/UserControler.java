/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.usermvc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ajaim
 */
public class UserControler implements ActionListener {
    private UserDAO dao;
    private User user;
    private VistaUser vista;
    
    DefaultTableModel modelo = new DefaultTableModel();
    
    public UserControler (VistaUser v, UserDAO d){
        this.vista = v;
        this.dao = d;
     
        // Llama la accion de los botones en la visual grafica
        this.vista.btnListar.addActionListener(this);
        this.vista.btnGuardar.addActionListener(this);        
        this.vista.btnActualizar.addActionListener(this);        
        this.vista.btnEliminar.addActionListener(this);
        
        this.vista.tblUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                rellenarCampos(); // Llamamos a un método que crearemos ahora
            }
        });
    }
    
    public void rellenarCampos() {
        
        int fila = vista.tblUsuarios.getSelectedRow();
        
        if (fila == -1) {
            System.out.println("No se ha seleccionado ninguna fila.");
        } else {
            int id = Integer.parseInt(vista.tblUsuarios.getValueAt(fila, 0).toString());
            String nom = (String) vista.tblUsuarios.getValueAt(fila, 1);
            String ape = (String) vista.tblUsuarios.getValueAt(fila, 2);
            String correo = (String) vista.tblUsuarios.getValueAt(fila, 3);
            
            vista.txtIdUser.setText(String.valueOf(id)); 
            vista.txtNombre.setText(nom);
            vista.txtApellido.setText(ape);
            vista.txtCorreo.setText(correo);
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == vista.btnListar) {
            listar(vista.tblUsuarios);
        } else if (e.getSource() == vista.btnGuardar) {
            guardar();
        } else if (e.getSource() == vista.btnGuardar) {
            actulizar();
        } else if (e.getSource() == vista.btnActualizar) {
            actulizar();
        } else if (e.getSource() == vista.btnEliminar) {
            eliminar();
        }
    }
    // Metodo Listar
    public void listar (JTable tabla){
        modelo = (DefaultTableModel) tabla.getModel();
        modelo.setRowCount(0);
        
        List<User> lista = dao.listarUsuarios();
        
        Object[] objeto = new Object[6];
        
        for (int i = 0; i < lista.size() ; i++) {
            objeto[0] = lista.get(i).getId_user();
            objeto[1] = lista.get(i).getName_user();
            objeto[2] = lista.get(i).getLastN_user();
            objeto[3] = lista.get(i).getGmail_user();
            objeto[4] = lista.get(i).getDateCreate_user();
            objeto[5] = lista.get(i).getDateUpdate_user();
            
            modelo.addRow(objeto);
        }
        tabla.setModel(modelo);
    }
    
    // Metodo Guardar
    public void guardar(){
        String nomb = vista.txtNombre.getText();
        String apel = vista.txtApellido.getText();
        String mail = vista.txtCorreo.getText();
        
        User u = new User();
        u.setName_user(nomb);
        u.setLastN_user(apel);
        u.setGmail_user(mail);
        
        boolean exito = dao.guardarUsuario(u);
        
        if (exito) {
            System.out.println("Usuario Guardado!");
            
            // Muestra el dato creado en la tabla
            listar(vista.tblUsuarios);
            
            // Limpiamos los campos
            vista.txtNombre.setText("");
            vista.txtApellido.setText("");
            vista.txtCorreo.setText("");
        } else {
            System.out.println("Hubo un error al guardar.");
        }  
    }
    // Metodo Actualizar
    public void actulizar() {
        int idUs = Integer.parseInt(vista.txtIdUser.getText());
        String nomb = vista.txtNombre.getText();
        String apel = vista.txtApellido.getText();
        String mail = vista.txtCorreo.getText();

        User u = new User();
        u.setId_user(idUs);
        u.setName_user(nomb);
        u.setLastN_user(apel);
        u.setGmail_user(mail);

        boolean exito = dao.actaulizarUsuario(u);
        if (exito) {
            System.out.println("¡Usuario actualizado con éxito!");
            listar(vista.tblUsuarios);

            // Limpiamos las cajas
            vista.txtIdUser.setText("");
            vista.txtNombre.setText("");
            vista.txtApellido.setText("");
            vista.txtCorreo.setText("");
        } else {
            System.out.println("Hubo un error al actualizar.");
        }
    }
    // Metodo Eliminar
    public void eliminar(){
        int idUs = Integer.parseInt(vista.txtIdUser.getText());
        User u = new User();
        u.setId_user(idUs);
        boolean exito = dao.eliminarUsuario(u);
        if (exito) {
            System.out.println("¡Usuario Eliminado con éxito!");
            listar(vista.tblUsuarios);

            // Limpiamos las cajas
            vista.txtIdUser.setText("");
            vista.txtNombre.setText("");
            vista.txtApellido.setText("");
            vista.txtCorreo.setText("");
        } else {
            System.out.println("Hubo un error al actualizar.");
        }
    }
}
