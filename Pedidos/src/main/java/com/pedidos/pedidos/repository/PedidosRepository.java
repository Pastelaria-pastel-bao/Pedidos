package com.pedidos.pedidos.repository;

import com.pedidos.pedidos.entity.ItemPedido;
import com.pedidos.pedidos.entity.Pedidos;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PedidosRepository extends JpaRepository<Pedidos, Long> {
}
