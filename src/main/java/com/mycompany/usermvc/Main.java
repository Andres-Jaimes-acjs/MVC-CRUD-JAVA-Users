/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.usermvc;

/**
 *
 * @author ajaim
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {        
        VistaUser v = new VistaUser();
        UserDAO d = new UserDAO();
        UserControler c = new UserControler(v, d);
        
        v.setVisible(true);
        v.setLocationRelativeTo(null);
        
        //c.listar(v.tblUsuarios);        
    }
    
}
