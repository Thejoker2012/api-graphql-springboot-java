package com.udemy.compras.graphql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    //Buscar um Cliente passando o id
    public Cliente findById(Long id){
        return repository.findById(id).orElse(null);//Sempre que houver retorno Optional usar orElse
    }
    //Buscar Todos os Clientes
    public List<Cliente> findAll(){
        return repository.findAll();
    }

    //Salvar
    //Atualizar o Cliente passando o Id
    @Transactional
    public Cliente save(Cliente cliente){
        return repository.save(cliente);
    }

    //Deletar Cliente passando id
    //Faz a busca com o findByid se houver o cliente ele exclui e retorna true
    //caso não exista retorna false
    @Transactional
    public Boolean deleteById(Long id){
        if (repository.findById(id).isPresent()){
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
