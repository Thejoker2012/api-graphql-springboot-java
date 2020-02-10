package com.udemy.compras.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.udemy.compras.mapper.ProdutoInput;
import com.udemy.compras.models.Produto;
import com.udemy.compras.service.ProdutoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProdutoGraphQL implements GraphQLQueryResolver, GraphQLMutationResolver {

    @Autowired
    private ProdutoService service;

    //Buscar um Produto passando o id
    public Produto produto(Long id){
        return service.findById(id);
    }
    //Buscar Todos os Produtos
    public List<Produto> produtos(){
        return service.findAll();
    }

    //Salvar ou
    //Atualizar o Produto passando o Id
    public Produto saveProduto(ProdutoInput input){
//        Produto c = new Produto();
//        c.setId(input.getId());
//        c.setNome(input.getNome());
//        c.setEmail(input.getValor());
        ModelMapper mapper = new ModelMapper();
        Produto c = mapper.map(input, Produto.class);
        return service.save(c);

    }

    //Deletar Produto passando id
    //Faz a busca com o findByid se houver o produto ele exclui e retorna true
    //caso não exista retorna false
    public Boolean deleteProduto(Long id){
        return service.deleteById(id);
    }
}
