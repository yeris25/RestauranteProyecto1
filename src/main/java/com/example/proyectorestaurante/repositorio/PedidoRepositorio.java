package com.example.proyectorestaurante.repositorio;

import com.example.proyectorestaurante.Utiles.EstadoPedido;
import com.example.proyectorestaurante.entidad.Pedido;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;

@Repository
public interface PedidoRepositorio  extends  JpaRepository<Pedido, Integer> {


    Page<Pedido> findBySedeAndEstado (String sede, EstadoPedido estado, Pageable paginador);
}
