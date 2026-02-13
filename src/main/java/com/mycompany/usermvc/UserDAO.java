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
    // Metodo de listar usuarios.
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
    // Metodo de Guardar Usuarios.
    public boolean guardarUsuario (User usuario){
        //Consulta SQL
        String SQL = "INSERT INTO users_t (name_user, lastN_user, gmail_user, dateCreate_user, dateUpdate_user) VALUES (?, ?, ?, CURRENT_DATE(), CURRENT_DATE())";
        // Llamo la instancia de la clase de conexion a db
        ConexionMySQL con = new ConexionMySQL();
        // Establecer la conexión
        Connection conexion = con.conectarSQL();
        PreparedStatement ps = null;
        try {
            conexion = con.conectarSQL();
            ps = conexion.prepareStatement(SQL);
            
            ps.setString(1, usuario.getName_user());
            ps.setString(2, usuario.getLastN_user());
            ps.setString(3, usuario.getGmail_user());
            
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("Error al guardar: " + e.getMessage());
            return false;
        } finally {
            try {
                if(ps != null) ps.close();
                if(conexion != null) conexion.close();
            } catch (Exception e) {
                System.err.println("Error al cerrar: " + e.getMessage());
            }
        }
    }
    // Metodo Actualizar Usuario.
    public boolean actaulizarUsuario (User usuario){
        //Consulta SQL
        String SQL = "UPDATE users_t SET name_user = ?, lastN_user = ?, gmail_user = ?, dateUpdate_user = CURRENT_DATE() WHERE id_user = ?";
        // Llamo la instancia de la clase de conexion a db
        ConexionMySQL con = new ConexionMySQL();
        // Establecer la conexión
        Connection conexion = null;
        PreparedStatement ps = null;
        try {
            conexion = con.conectarSQL();
            ps = conexion.prepareStatement(SQL);
            
            ps.setString(1, usuario.getName_user());
            ps.setString(2, usuario.getLastN_user());
            ps.setString(3, usuario.getGmail_user());
            ps.setInt(4, usuario.getId_user());

            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("Error al actulizar: " + e.getMessage());
            return false;
        } finally{
            try {
                if(ps != null) ps.close();
                if(conexion != null) conexion.close();
            } catch (Exception e) {
                System.err.println("Error al cerrar: " + e.getMessage());
            }
        }
    }
    
    public boolean eliminarUsuario (User usuario){
        String SQL = "DELETE FROM users_t WHERE id_user = ?";
        // Llamo la instancia de la clase de conexion a db
        ConexionMySQL con = new ConexionMySQL();
        // Establecer la conexión
        Connection conexion = null;
        PreparedStatement ps = null;
        try {
            conexion = con.conectarSQL();
            ps = conexion.prepareStatement(SQL);
            
            ps.setInt(1, usuario.getId_user());

            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("Error al elminar usuario: " + e.getMessage());
            return false;
        } finally{
            try {
                if(ps != null) ps.close();
                if(conexion != null) conexion.close();
            } catch (Exception e) {
                System.err.println("Error al cerrar: " + e.getMessage());
            }
        }
    }
}
