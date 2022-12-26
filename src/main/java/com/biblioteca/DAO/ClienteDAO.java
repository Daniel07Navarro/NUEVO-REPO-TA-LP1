/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biblioteca.DAO;

import com.biblioteca.conexion.Conexion;
import com.biblioteca.modelo.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Daniel
 */
public class ClienteDAO {

    private static final String SQL_INSERT = "INSERT INTO cliente (nomCliente,correo,password) values (?,?,?)";

    private static final String SQL_SELECT_V2 = "SELECT * FROM CLIENTE WHERE CORREO = ?";

    private static final String SQL_SELECT = "SELECT * FROM CLIENTE WHERE CORREO = ? AND PASSWORD = ?";

    public Cliente validarCliente(String correo, String password) {
        Connection cn = Conexion.darConexion();
        try {
            PreparedStatement ps = cn.prepareCall(SQL_SELECT);
            ps.setString(1, correo);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            Cliente cliente = null;
            while (rs.next()) {
                cliente = new Cliente();
                cliente.setIdCliente(rs.getInt("idcliente"));
                cliente.setNomCliente(rs.getString("nomCliente"));
                cliente.setCorreo(rs.getString("correo"));
                cliente.setPassword(rs.getString("password"));
            }
            rs.close();
            ps.close();
            cn.close();
            return cliente;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void registrarCliente(Cliente cliente) {
        Connection cn = Conexion.darConexion();
        try {
            PreparedStatement ps = cn.prepareCall(SQL_INSERT);
            ps.setString(1, cliente.getNomCliente());
            ps.setString(2, cliente.getCorreo());
            ps.setString(3, cliente.getPassword());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Cliente traerCliente(String correo) {
        Connection cn = Conexion.darConexion();
        try {
            PreparedStatement ps = cn.prepareCall(SQL_SELECT_V2);
            ps.setString(1, correo);
            ResultSet rs = ps.executeQuery();
            Cliente cliente = null;
            while (rs.next()) {
                cliente = new Cliente();
                cliente.setIdCliente(rs.getInt("idcliente"));
                cliente.setNomCliente(rs.getString("nomCliente"));
                cliente.setCorreo(rs.getString("correo"));
                cliente.setPassword(rs.getString("password"));
            }
            rs.close();
            ps.close();
            cn.close();
            return cliente;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
