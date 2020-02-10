package com.udemy.compras.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.udemy.compras.Cliente;
import com.udemy.compras.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
public class ClienteGraphQL implements GraphQLQueryResolver, GraphQLMutationResolver {

    @Autowired
    private ClienteRepository clienteRepository;

    //Buscar um Cliente passando o id
    public Cliente cliente(Long id){
        return clienteRepository.findById(id).orElse(null);//Sempre que houver retorno Optional usar orElse
    }
    //Buscar Todos os Clientes
    public List<Cliente> clientes(){
        return clienteRepository.findAll();
    }

    //Salvar
    //Atualizar o Cliente passando o Id
    @Transactional
    public Cliente saveCliente(Long id, String nome, String email){
        Cliente c = new Cliente();
        c.setId(id);
        c.setNome(nome);
        c.setEmail(email);
        return clienteRepository.save(c);
    }

    //Deletar Cliente passando id
    //Faz a busca com o findByid se houver o cliente ele exclui e retorna true
    //caso não exista retorna false
    @Transactional
    public Boolean deleteCliente(Long id){
        if (clienteRepository.findById(id).isPresent()){
            clienteRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
