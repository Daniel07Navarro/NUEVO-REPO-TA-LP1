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
public class PrestamoReporte {

    private int idPrestamo;

    private int idLibro;

    private String fechaPrestamo;

    private String fechaEntrega;

    private String estado; 
    
    private String nombreLibro;

    public PrestamoReporte(String fechaPrestamo, String fechaEntrega, String estado, String nombreLibro) {
        this.fechaPrestamo = fechaPrestamo;
        this.fechaEntrega = fechaEntrega;
        this.estado = estado;
        this.nombreLibro = nombreLibro;
    }
    
    

}
