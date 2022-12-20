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
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Cliente {

    private Integer idCliente;

    private String nomCliente;

    private String correo;

    private String password;
    

    public Cliente(String nomCliente, String correo, String password) {
        this.nomCliente = nomCliente;
        this.correo = correo;
        this.password = password;
    }

    
    
}
