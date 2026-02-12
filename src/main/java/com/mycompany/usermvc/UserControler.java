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
        
        this.vista.btnListar.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnListar) {
            listar(vista.tblUsuarios);
        }
    }
    
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
}
