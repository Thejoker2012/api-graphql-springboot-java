package com.udemy.compras.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.udemy.compras.mapper.ClienteInput;
import com.udemy.compras.models.Cliente;
import com.udemy.compras.service.ClienteService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClienteGraphQL implements GraphQLQueryResolver, GraphQLMutationResolver {

    @Autowired
    private ClienteService service;

    //Buscar um Cliente passando o id
    public Cliente cliente(Long id){
        return service.findById(id);
    }
    //Buscar Todos os Clientes
    public List<Cliente> clientes(){
        return service.findAll();
    }

    //Salvar
    //Atualizar o Cliente passando o Id
    public Cliente saveCliente(ClienteInput input){
//        Cliente c = new Cliente();
//        c.setId(input.getId());
//        c.setNome(input.getNome());
//        c.setEmail(input.getEmail());
        ModelMapper mapper = new ModelMapper();
        Cliente c = mapper.map(input, Cliente.class);
        return service.save(c);

    }

    //Deletar Cliente passando id
    //Faz a busca com o findByid se houver o cliente ele exclui e retorna true
    //caso não exista retorna false
    public Boolean deleteCliente(Long id){
        return service.deleteById(id);
    }
}
