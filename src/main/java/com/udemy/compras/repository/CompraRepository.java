package com.udemy.compras.repository;

import com.udemy.compras.models.Cliente;
import com.udemy.compras.models.Compra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompraRepository extends JpaRepository<Compra, Long> {

    //Query customizada
   // @Query("select c from Compra where c.cliente = :cliente");
    List<Compra> findAllByCliente(Cliente c);

}
