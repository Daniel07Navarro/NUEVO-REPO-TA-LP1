/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biblioteca.DAO;

import com.biblioteca.conexion.Conexion;
import com.biblioteca.modelo.Libro;
import com.biblioteca.modelo.LibroReporte;
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
public class LibroDAO {

    private static final String SQL_SELECT = "select l.idlibro,l.titulo,l.stock,l.anio,e.nomEditorial,a.nomCompleto \n"
            + "from libro l, editorial e, autor a where e.ideditorial = l.ideditorial and a.idautor = l.idautor order by idlibro";

    private static final String SQL_SELECT_V2 = "select l.idlibro,l.titulo,l.stock,l.anio,e.nomEditorial,a.nomCompleto \n"
            + "from libro l, editorial e, autor a where e.ideditorial = l.ideditorial and a.idautor = l.idautor and l.titulo like  ? order by idlibro";

    private static final String SQL_SELECT_V3 = "select l.idlibro,l.titulo,l.stock,l.anio,e.nomEditorial,a.nomCompleto \n"
            + "from libro l, editorial e, autor a where e.ideditorial = l.ideditorial and a.idautor = l.idautor and a.nomCompleto like ? order by idlibro";

    private static final String SQL_ID = "select * from libro where idlibro = ?";

    public static List<LibroReporte> listarLibros() {
        Connection cn = Conexion.darConexion();
        LibroReporte libro;
        try {
            PreparedStatement ps = cn.prepareCall(SQL_SELECT);
            ResultSet rs = ps.executeQuery();
            List<LibroReporte> libros = new ArrayList<>();
            while (rs.next()) {
                libro = new LibroReporte(rs.getInt("idlibro"), rs.getString("titulo"), rs.getInt("stock"), rs.getInt("anio"), rs.getString("e.nomEditorial"), rs.getString("a.nomCompleto"));
                libros.add(libro);
            }
            return libros;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static List<LibroReporte> listarLibrosByTitulo(String titulo) {
        Connection cn = Conexion.darConexion();
        LibroReporte libro;
        try {
            PreparedStatement ps = cn.prepareCall(SQL_SELECT_V2);
            ps.setString(1, titulo + "%");
            ResultSet rs = ps.executeQuery();
            List<LibroReporte> libros = new ArrayList<>();
            while (rs.next()) {
                libro = new LibroReporte(rs.getInt("idlibro"), rs.getString("titulo"), rs.getInt("stock"), rs.getInt("anio"), rs.getString("e.nomEditorial"), rs.getString("a.nomCompleto"));
                libros.add(libro);
            }
            return libros;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static List<LibroReporte> listarLibrosByNombreAutor(String nombre) {
        Connection cn = Conexion.darConexion();
        LibroReporte libro;
        try {
            PreparedStatement ps = cn.prepareCall(SQL_SELECT_V3);
            ps.setString(1, nombre + "%");
            ResultSet rs = ps.executeQuery();
            List<LibroReporte> libros = new ArrayList<>();
            while (rs.next()) {
                libro = new LibroReporte(rs.getInt("idlibro"), rs.getString("titulo"), rs.getInt("stock"), rs.getInt("anio"), rs.getString("e.nomEditorial"), rs.getString("a.nomCompleto"));
                libros.add(libro);
            }
            return libros;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static Libro darLibro(int id) {
        Connection cn = Conexion.darConexion();
        Libro libro = null;
        try {
            PreparedStatement ps = cn.prepareCall(SQL_ID);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                libro = new Libro();
                libro.setIdLibro(rs.getInt("idlibro"));
                libro.setTitulo(rs.getString("titulo"));
                libro.setStock(rs.getInt("stock"));
                libro.setAnio(rs.getInt("anio"));
                libro.setIdEditorial(rs.getInt("ideditorial"));
                libro.setIdAutor(rs.getInt("idautor"));
            }
            return libro;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static void reducirStock(int idLibro) {
        Connection cn = Conexion.darConexion();
        String callSP = "{CALL reducir_stock(?)}";
        try {
            CallableStatement cs = cn.prepareCall(callSP);
            cs.setInt(1, idLibro);
            cs.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {

        Libro libro = LibroDAO.darLibro(1);
        System.out.println("libro = " + libro);
    }

}
