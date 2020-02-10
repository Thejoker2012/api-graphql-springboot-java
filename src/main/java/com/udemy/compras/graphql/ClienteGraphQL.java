package com.udemy.compras.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClienteGraphQL implements GraphQLQueryResolver, GraphQLMutationResolver {

    @Autowired
    private ClienteService clienteService;

    //Buscar um Cliente passando o id
    public Cliente cliente(Long id){
        return clienteService.findById(id);
    }
    //Buscar Todos os Clientes
    public List<Cliente> clientes(){
        return clienteService.findAll();
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
        return clienteService.save(c);

    }

    //Deletar Cliente passando id
    //Faz a busca com o findByid se houver o cliente ele exclui e retorna true
    //caso não exista retorna false
    public Boolean deleteCliente(Long id){
        return clienteService.deleteById(id);
    }
}
