package com.udemy.compras.graphql;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.udemy.compras.Cliente;
import com.udemy.compras.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClienteGraphQL implements GraphQLQueryResolver {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente cliente(Long id){
        return clienteRepository.findById(id).orElse(null);//Sempre que houver retorno Optional usar orElse
    }

    public List<Cliente> clientes(){
        return clienteRepository.findAll();
    }

}
