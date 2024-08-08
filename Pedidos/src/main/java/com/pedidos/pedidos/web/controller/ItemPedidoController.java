package com.pedidos.pedidos.web.controller;

import com.pedidos.pedidos.entity.ItemPedido;
import com.pedidos.pedidos.service.ItemPedidoService;
import com.pedidos.pedidos.exeptions.ResourceNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/itens-pedido")
@Validated
@RequiredArgsConstructor
public class ItemPedidoController {

    private final ItemPedidoService itemPedidoService;

    @PostMapping("/pedido/{pedidoId}")
    public ResponseEntity<ItemPedido> adicionarItemPedido(@PathVariable Long pedidoId, @Valid @RequestBody ItemPedido itemPedido) {
        try {
            ItemPedido novoItemPedido = itemPedidoService.adicionarItemPedido(pedidoId, itemPedido);
            return ResponseEntity.status(HttpStatus.CREATED).body(novoItemPedido);
        } catch (ResourceNotFoundException ex) {
            log.error("Pedido não encontrado com ID: {}", pedidoId, ex);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } catch (Exception ex) {
            log.error("Erro inesperado ao adicionar item ao pedido com ID: {}", pedidoId, ex);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
