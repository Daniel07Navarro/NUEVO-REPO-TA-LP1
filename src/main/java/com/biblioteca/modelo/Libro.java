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
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Libro {
    
    private Integer idLibro;
    
    private String titulo;
    
    private int stock;
    
    private int anio;
    
    private int idEditorial;
    
    private int idAutor;
    

    
}
