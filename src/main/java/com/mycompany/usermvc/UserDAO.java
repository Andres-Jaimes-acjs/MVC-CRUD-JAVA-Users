/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.usermvc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ajaim
 */
public class UserDAO {
    public List<User> listarUsuarios() {
        // Llamo la instancia de la clase de conexion a db
        ConexionMySQL con = new ConexionMySQL();
        // Establecer la conexión
        Connection conexion = con.conectarSQL();
        PreparedStatement ps = null;
        ResultSet rs = null;
        // Lista para guardar los usuarios
        List<User> lista = new ArrayList<>();
        try {
            //Consulta SQL
            String SQL = "SELECT * FROM users_t";

            //Prepara y ejecuta la consulta SQL
            ps = conexion.prepareStatement(SQL);
            rs = ps.executeQuery();

            while (rs.next()) {
                // Creación objeto User
                User usuario = new User();
                usuario.setId_user(rs.getInt("id_user"));
                usuario.setName_user(rs.getString("name_user"));
                usuario.setLastN_user(rs.getString("lastN_user"));
                usuario.setGmail_user(rs.getString("gmail_user"));
                usuario.setDateCreate_user(rs.getString("dateCreate_user"));
                usuario.setDateUpdate_user(rs.getString("dateUpdate_user"));
                lista.add(usuario);
            }
        } catch (Exception e) {
            System.out.println("Error al listar: " + e.getMessage());
        } finally {
            try {
                if(rs != null) rs.close();
                if(ps != null) ps.close();
                if(conexion != null) conexion.close();
            } catch (Exception e) {
                System.err.println("Error al cerrar: " + e.getMessage());
            }
        }
        return lista;
    }
}
