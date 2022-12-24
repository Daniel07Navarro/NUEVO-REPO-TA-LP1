/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biblioteca.modelo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Daniel
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LibroReporte {

    private Integer idLibro;

    private String titulo;

    private int stock;

    private int anio;

    private int idEditorial;

    private int idAutor;

    private String nombreEditorial;

    private String nombreAutor;

    public LibroReporte(Integer idLibro, String titulo, int stock, int anio, String nombreEditorial, String nombreAutor) {
        this.idLibro = idLibro;
        this.titulo = titulo;
        this.stock = stock;
        this.anio = anio;
        this.nombreEditorial = nombreEditorial;
        this.nombreAutor = nombreAutor;
    }

    public LibroReporte(Integer idLibro, String titulo, int stock, int anio, int idEditorial, int idAutor) {
        this.idLibro = idLibro;
        this.titulo = titulo;
        this.stock = stock;
        this.anio = anio;
        this.idEditorial = idEditorial;
        this.idAutor = idAutor;
    }

    @Override
    public String toString() {
        return "Libro{" + "idLibro=" + idLibro + ", titulo=" + titulo + ", stock=" + stock + ", anio=" + anio + ", nombreEditorial=" + nombreEditorial + ", nombreAutor=" + nombreAutor + '}';
    }

}
