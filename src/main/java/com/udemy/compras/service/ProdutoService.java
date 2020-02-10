package com.udemy.compras.service;

import com.udemy.compras.models.Produto;
import com.udemy.compras.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    //Buscar um Produto passando o id
    public Produto findById(Long id){
        return repository.findById(id).orElse(null);//Sempre que houver retorno Optional usar orElse
    }
    //Buscar Todos os Produtos
    public List<Produto> findAll(){
        return repository.findAll();
    }

    //Salvar
    //Atualizar o Produto passando o Id
    @Transactional
    public Produto save(Produto produto){
        return repository.save(produto);
    }

    //Deletar Produto passando id
    //Faz a busca com o findByid se houver o produto ele exclui e retorna true
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
