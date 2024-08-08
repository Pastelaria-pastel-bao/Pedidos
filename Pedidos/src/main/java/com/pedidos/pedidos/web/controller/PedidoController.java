package com.pedidos.pedidos.web.controller;

import com.pedidos.pedidos.entity.Pedidos;
import com.pedidos.pedidos.service.PedidoService;
import com.pedidos.pedidos.exeptions.ResourceNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@Slf4j
@RestController
@RequestMapping("/pedidos")
@Validated
@RequiredArgsConstructor
public class PedidoController {

    private final PedidoService pedidoService;

    @PostMapping
    public ResponseEntity<Pedidos> criarPedido(@Valid @RequestBody Pedidos pedido) {
        Pedidos novoPedido = pedidoService.criarPedido(pedido);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoPedido);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pedidos> buscarPedidoPorId(@PathVariable Long id) {
        Pedidos pedido = pedidoService.buscarPedidoPorId(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pedido não encontrado com ID: " + id));
        return ResponseEntity.ok(pedido);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Pedidos> atualizarPedido(@PathVariable Long id, @RequestBody Pedidos pedidoAtualizado) {
        Pedidos pedido = pedidoService.atualizarPedido(id, pedidoAtualizado);
        return ResponseEntity.ok(pedido);
    }

    @PatchMapping("/situacao/{id}")
    public ResponseEntity<Pedidos> situacao(@PathVariable Long id, @RequestBody Pedidos.Situacao situacaoAtual) {
        Pedidos pedido = pedidoService.atualizarSituacao(id, situacaoAtual);
        return ResponseEntity.ok(pedido);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPedido(@PathVariable Long id) {
        pedidoService.deletarPedido(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Pedidos>> listarPedidos() {
        List<Pedidos> pedidos = pedidoService.listarPedidos();
        return ResponseEntity.ok(pedidos);
    }
}
