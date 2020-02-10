package com.udemy.compras.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.udemy.compras.mapper.CompraInput;
import com.udemy.compras.models.Compra;
import com.udemy.compras.service.ClienteService;
import com.udemy.compras.service.CompraService;
import com.udemy.compras.service.ProdutoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class CompraGraphQL implements GraphQLQueryResolver, GraphQLMutationResolver {

    @Autowired
    private CompraService service;

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private ClienteService clienteService;

    //Buscar um Compra passando o id
    public Compra compra(Long id){
        return service.findById(id);
    }
    //Buscar Todos os Compras
    public List<Compra> compras(){
        return service.findAll();
    }

    //Salvar ou
    //Atualizar o Compra passando o Id
    public Compra saveCompra(CompraInput input){
//        Compra c = new Compra();
//        c.setId(input.getId());
//        c.setNome(input.getNome());
//        c.setEmail(input.getValor());
        ModelMapper mapper = new ModelMapper();
        Compra c = mapper.map(input, Compra.class);
        c.setData(new Date());
        c.setCliente(clienteService.findById(input.getClienteId()));
        c.setProduto(produtoService.findById(input.getProdutoId()));
        return service.save(c);

    }

    //Deletar Compra passando id
    //Faz a busca com o findByid se houver o compra ele exclui e retorna true
    //caso não exista retorna false
    public Boolean deleteCompra(Long id){
        return service.deleteById(id);
    }
}
