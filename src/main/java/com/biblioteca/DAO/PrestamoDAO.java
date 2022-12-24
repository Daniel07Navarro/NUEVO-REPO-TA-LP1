/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biblioteca.DAO;

import com.biblioteca.conexion.Conexion;
import com.biblioteca.modelo.Prestamo;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author Daniel
 */
public class PrestamoDAO {
    
    private static final String SQL_INSERT = "{CALL insert_prestamo(?,?,?,?,?)}";
    
    public static void insertarPrestamo(Prestamo prestamo){
        Connection cn = Conexion.darConexion();
        try {
            PreparedStatement ps = cn.prepareCall(SQL_INSERT);
            ps.setInt(1, prestamo.getIdCliente());
            ps.setInt(2, prestamo.getIdLibro());
            ps.setString(3, prestamo.getFechaPrestamo());
            ps.setString(4, prestamo.getFechaEntrega());
            ps.setString(5, prestamo.getEstado());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
