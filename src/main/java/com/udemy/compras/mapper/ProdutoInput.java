package com.udemy.compras.mapper;


import lombok.Data;

@Data
public class ProdutoInput {

    private Long id;
    private String nome;
    private Double valor;

}
