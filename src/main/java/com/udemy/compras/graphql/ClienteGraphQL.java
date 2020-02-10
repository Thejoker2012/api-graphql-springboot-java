package com.udemy.compras.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
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
    public Cliente saveCliente(Long id, String nome, String email){
        Cliente c = new Cliente();
        c.setId(id);
        c.setNome(nome);
        c.setEmail(email);
        return clienteService.save(c);
    }

    //Deletar Cliente passando id
    //Faz a busca com o findByid se houver o cliente ele exclui e retorna true
    //caso não exista retorna false
    public Boolean deleteCliente(Long id){
        return clienteService.deleteById(id);
    }
}
