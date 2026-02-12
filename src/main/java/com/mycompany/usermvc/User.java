/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.usermvc;

/**
 *
 * @author ajaim
 */
public class User {
    // Campos de la tabla Users_T
    private int id_user;
    private String name_user;
    private String lastN_user;
    private String gmail_user;
    private String dateCreate_user;
    private String dateUpdate_user;

    // Getters and Setters tabla Users_T
    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getName_user() {
        return name_user;
    }

    public void setName_user(String name_user) {
        this.name_user = name_user;
    }

    public String getLastN_user() {
        return lastN_user;
    }

    public void setLastN_user(String lastN_user) {
        this.lastN_user = lastN_user;
    }

    public String getGmail_user() {
        return gmail_user;
    }

    public void setGmail_user(String gmail_user) {
        this.gmail_user = gmail_user;
    }

    public String getDateCreate_user() {
        return dateCreate_user;
    }

    public void setDateCreate_user(String dateCreate_user) {
        this.dateCreate_user = dateCreate_user;
    }

    public String getDateUpdate_user() {
        return dateUpdate_user;
    }

    public void setDateUpdate_user(String dateUpdate_user) {
        this.dateUpdate_user = dateUpdate_user;
    }

    public User(){};
    
    public User(int id_user, String name_user, String lastN_user, String gmail_user, String dateCreate_user, String dateUpdate_user) {
        this.id_user = id_user;
        this.name_user = name_user;
        this.lastN_user = lastN_user;
        this.gmail_user = gmail_user;
        this.dateCreate_user = dateCreate_user;
        this.dateUpdate_user = dateUpdate_user;
    }
    
}
