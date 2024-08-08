package com.pedidos.pedidos.web.controller;

import com.pedidos.pedidos.entity.ItemPedido;
import com.pedidos.pedidos.service.ItemPedidoService;
import com.pedidos.pedidos.web.dto.ItemPedidoDTO;
import com.pedidos.pedidos.web.dto.ItemPedidoAtualizacaoDTO;
import com.pedidos.pedidos.web.models.ItemPedidoMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/item-pedido")
@Validated
@RequiredArgsConstructor
public class ItemPedidoController {

    private final ItemPedidoService itemPedidoService;

    @PostMapping("/{pedidoId}")
    public ResponseEntity<ItemPedidoDTO> adicionarItemPedido(@PathVariable Long pedidoId, @RequestBody ItemPedidoDTO itemPedidoDTO) {
        ItemPedido itemPedido = ItemPedidoMapper.paraItemPedido(itemPedidoDTO);
        ItemPedido novoItemPedido = itemPedidoService.adicionarItemPedido(pedidoId, itemPedido);
        ItemPedidoDTO novoItemPedidoDTO = ItemPedidoMapper.paraItemPedidoDTO(novoItemPedido);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoItemPedidoDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemPedidoDTO> buscarItemPedidoPorId(@PathVariable Long id) {
        ItemPedido itemPedido = itemPedidoService.buscarItemPedidoPorId(id);
        ItemPedidoDTO itemPedidoDTO = ItemPedidoMapper.paraItemPedidoDTO(itemPedido);
        return ResponseEntity.ok(itemPedidoDTO);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ItemPedidoDTO> atualizarItemPedido(@PathVariable Long id, @RequestBody ItemPedidoAtualizacaoDTO itemPedidoAtualizacaoDTO) {
        ItemPedido itemAtualizado = itemPedidoService.atualizarItemPedido(id, ItemPedidoMapper.paraItemPedido(itemPedidoAtualizacaoDTO));
        ItemPedidoDTO itemPedidoDTO = ItemPedidoMapper.paraItemPedidoDTO(itemAtualizado);
        return ResponseEntity.ok(itemPedidoDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarItemPedido(@PathVariable Long id) {
        itemPedidoService.deletarItemPedido(id);
        return ResponseEntity.noContent().build();
    }
}
