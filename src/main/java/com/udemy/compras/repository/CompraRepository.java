package com.udemy.compras.repository;

import com.udemy.compras.models.Cliente;
import com.udemy.compras.models.Compra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.stereotype.Repository;

import javax.persistence.QueryHint;
import java.util.List;

@Repository
public interface CompraRepository extends JpaRepository<Compra, Long> {

    //Query customizada
   // @Query("select c from Compra where c.cliente = :cliente");
    @QueryHints({@QueryHint(name = "org.hibernate.cacheable", value = "true")})
    List<Compra> findAllByCliente(Cliente c);

}
