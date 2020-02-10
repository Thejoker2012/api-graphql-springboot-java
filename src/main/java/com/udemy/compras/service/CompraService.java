package com.udemy.compras.service;

import com.udemy.compras.models.Cliente;
import com.udemy.compras.models.Compra;
import com.udemy.compras.repository.CompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CompraService {

    @Autowired
    private CompraRepository repository;

    //Buscar um Compra passando o id
    public Compra findById(Long id){
        return repository.findById(id).orElse(null);//Sempre que houver retorno Optional usar orElse
    }
    //Buscar Todos os Compras
    public List<Compra> findAll(){
        return repository.findAll();
    }

    //Salvar
    //Atualizar o Compra passando o Id
    @Transactional
    public Compra save(Compra compra){
        return repository.save(compra);
    }

    //Deletar Compra passando id
    //Faz a busca com o findByid se houver o compra ele exclui e retorna true
    //caso não exista retorna false
    @Transactional
    public Boolean deleteById(Long id){
        if (repository.findById(id).isPresent()){
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Compra> findAllByCliente(Cliente c) {
        return repository.findAllByCliente(c);
    }
}
