/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.usermvc;

import io.github.cdimascio.dotenv.Dotenv;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ajaim
 */
public class ConexionMySQL {
    
    Dotenv dotenv = Dotenv.load();
    private final String URL = dotenv.get("DB_URL");
    private final String USER = dotenv.get("DB_USER");
    private final String PASS = dotenv.get("DB_PASSWORD");
    
    private Connection conn = null;

    public Connection conectarSQL() {
        try {
            conn = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("Conexión exitosa al DB");
        } catch (SQLException e) {
            System.out.println("Error al abrir Conexión: " + e.getMessage());
        }
        return conn;
    }
;
}
