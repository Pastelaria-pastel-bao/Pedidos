package com.pedidos.pedidos.repository;

import com.pedidos.pedidos.entity.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Long> {
}