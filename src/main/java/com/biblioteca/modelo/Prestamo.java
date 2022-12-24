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
import lombok.ToString;

/**
 *
 * @author Daniel
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Prestamo {

    private int idPrestamo;

    private int idCliente;

    private int idLibro;

    private String fechaPrestamo;

    private String fechaEntrega;

    private String estado;

    public Prestamo(int idCliente, int idLibro, String fechaPrestamo, String fechaEntrega, String estado) {
        this.idCliente = idCliente;
        this.idLibro = idLibro;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaEntrega = fechaEntrega;
        this.estado = estado;
    }

}
