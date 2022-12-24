/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biblioteca.conexion;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Daniel
 */
public class Conexion {
    
    private static final String url = "jdbc:mysql://localhost:3306/biblioteca";

    private static final String user = "root";

    private static final String password = "admin";//VARIA 
    //CONTRASEÑA DANIEL : ADMIN


    public static Connection darConexion() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection cn = DriverManager.getConnection(url, user, password);
            return cn;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
}
