package com.udemy.compras.mapper;


import lombok.Getter;

@Getter
public class CompraInput {

    private Long id;
    private Integer quantidade;
    private String status;

    private Long clienteId;

    private Long produtoId;

}
