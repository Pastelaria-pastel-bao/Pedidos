package com.pedidos.pedidos.repository;


import com.pedidos.pedidos.entity.Pedidos;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PedidosRepository extends JpaRepository<Pedidos, Long> {
}
