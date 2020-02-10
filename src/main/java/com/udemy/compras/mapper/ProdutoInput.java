package com.udemy.compras.mapper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoInput {

    private Long id;
    private String nome;
    private Double valor;

}
