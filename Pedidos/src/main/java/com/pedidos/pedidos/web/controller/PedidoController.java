package com.pedidos.pedidos.web.controller;

import com.pedidos.pedidos.entity.Pedidos;
import com.pedidos.pedidos.service.PedidoService;
import com.pedidos.pedidos.exeptions.ResourceNotFoundException;
import com.pedidos.pedidos.web.dto.PedidoAtualizacaoDTO;
import com.pedidos.pedidos.web.dto.PedidoCriacaoDTO;
import com.pedidos.pedidos.web.dto.PedidoDetalhadoDTO;
import com.pedidos.pedidos.web.models.PedidoMapper;
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
    public ResponseEntity<PedidoDetalhadoDTO> criarPedido(@Valid @RequestBody PedidoCriacaoDTO pedidoCriacaoDTO) {
        Pedidos pedido = PedidoMapper.paraPedido(pedidoCriacaoDTO);
        Pedidos novoPedido = pedidoService.criarPedido(pedido);
        PedidoDetalhadoDTO pedidoDetalhadoDTO = PedidoMapper.paraDetalhadoDTO(novoPedido);
        return ResponseEntity.status(HttpStatus.CREATED).body(pedidoDetalhadoDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoDetalhadoDTO> buscarPedidoPorId(@PathVariable Long id) {
        Pedidos pedido = pedidoService.buscarPedidoPorId(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pedido não encontrado com ID: " + id));
        PedidoDetalhadoDTO pedidoDetalhadoDTO = PedidoMapper.paraDetalhadoDTO(pedido);
        return ResponseEntity.ok(pedidoDetalhadoDTO);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<PedidoDetalhadoDTO> atualizarPedido(@PathVariable Long id, @RequestBody PedidoAtualizacaoDTO pedidoAtualizadoDTO) {
        Pedidos pedidoAtualizado = PedidoMapper.paraPedido(pedidoAtualizadoDTO);
        Pedidos pedido = pedidoService.atualizarPedido(id, pedidoAtualizado);
        PedidoDetalhadoDTO pedidoDetalhadoDTO = PedidoMapper.paraDetalhadoDTO(pedido);
        return ResponseEntity.ok(pedidoDetalhadoDTO);
    }

    @PatchMapping("/situacao/{id}")
    public ResponseEntity<PedidoDetalhadoDTO> atualizarSituacao(@PathVariable Long id, @RequestBody Pedidos.Situacao situacaoAtual) {
        Pedidos pedido = pedidoService.atualizarSituacao(id, situacaoAtual);
        PedidoDetalhadoDTO pedidoDetalhadoDTO = PedidoMapper.paraDetalhadoDTO(pedido);
        return ResponseEntity.ok(pedidoDetalhadoDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPedido(@PathVariable Long id) {
        pedidoService.deletarPedido(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<PedidoDetalhadoDTO>> listarPedidos() {
        List<Pedidos> pedidos = pedidoService.listarPedidos();
        List<PedidoDetalhadoDTO> pedidosDTO = pedidos.stream()
                .map(PedidoMapper::paraDetalhadoDTO)
                .toList();
        return ResponseEntity.ok(pedidosDTO);
    }
}
