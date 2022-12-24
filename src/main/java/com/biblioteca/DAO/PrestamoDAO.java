/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biblioteca.DAO;

import com.biblioteca.conexion.Conexion;
import com.biblioteca.modelo.Prestamo;
import com.biblioteca.modelo.PrestamoReporte;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Daniel
 */
public class PrestamoDAO {

    private static final String SQL_INSERT = "{CALL insert_prestamo(?,?,?,?,?)}";

    private static final String SQL_SELECT = "select p.idprestamo,l.titulo,p.fechaPrestamo, p.fechaEntrega,estado from libro l , prestamo p , cliente c \n"
            + "where l.idlibro = p.idlibro and p.idcliente= c.idcliente and c.idcliente = ?";

    public static void insertarPrestamo(Prestamo prestamo) {
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

    public static List<PrestamoReporte> listarPrestamosReporte(int idCliente) {
        Connection cn = Conexion.darConexion();
        PrestamoReporte prestamo = null;
        try {
            PreparedStatement ps = cn.prepareCall(SQL_SELECT);
            ps.setInt(1, idCliente);
            ResultSet rs = ps.executeQuery();
            List<PrestamoReporte> prestamos = new ArrayList<>();
            while (rs.next()) {
                prestamo = new PrestamoReporte(rs.getInt("idprestamo"), rs.getString("fechaPrestamo"), rs.getString("fechaEntrega"), rs.getString("estado"), rs.getString("titulo"));
                prestamos.add(prestamo);
            }
            return prestamos;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static void devolverPrestamo(int idPedido) {
        Connection cn = Conexion.darConexion();
        String callSP = "{CALL actualizar_general(?)}";
        try {
            CallableStatement cs = cn.prepareCall(callSP);
            cs.setInt(1, idPedido);
            cs.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
