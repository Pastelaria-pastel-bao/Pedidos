package com.pedidos.pedidos.service;

import com.pedidos.pedidos.entity.ItemPedido;
import com.pedidos.pedidos.entity.Pedidos;
import com.pedidos.pedidos.exeptions.DatabaseException;
import com.pedidos.pedidos.exeptions.PedidoNaoEncontradoException;
import com.pedidos.pedidos.repository.ItemPedidoRepository;
import com.pedidos.pedidos.repository.PedidosRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class ItemPedidoService {

    private final ItemPedidoRepository itemPedidoRepository;
    private final PedidosRepository pedidosRepository;

    public ItemPedido adicionarItemPedido(Long pedidoId, ItemPedido itemPedido) {
        try {
            Pedidos pedido = pedidosRepository.findById(pedidoId)
                    .orElseThrow(() -> new PedidoNaoEncontradoException("Pedido não encontrado com ID: " + pedidoId));

            itemPedido.setPedido(pedido);
            return itemPedidoRepository.save(itemPedido);
        } catch (Exception ex) {
            log.error("Erro inesperado ao adicionar item ao pedido com ID: {}", pedidoId, ex);
            throw new DatabaseException("Erro no banco de dados");
        }
    }

    public ItemPedido buscarItemPedidoPorId(Long id) {
        return itemPedidoRepository.findById(id)
                .orElseThrow(() -> new PedidoNaoEncontradoException("ItemPedido não encontrado com ID: " + id));
    }

    public ItemPedido atualizarItemPedido(Long id, ItemPedido itemAtualizado) {
        try {
            ItemPedido itemExistente = buscarItemPedidoPorId(id);

            if (itemAtualizado.getIdPastel() != null) {
                itemExistente.setIdPastel(itemAtualizado.getIdPastel());
            }
            if (itemAtualizado.getQuantidade() > 0) {
                itemExistente.setQuantidade(itemAtualizado.getQuantidade());
            }

            return itemPedidoRepository.save(itemExistente);
        } catch (Exception ex) {
            log.error("Erro inesperado ao atualizar item do pedido com ID: {}", id, ex);
            throw new DatabaseException("Erro no banco de dados");
        }
    }

    public void deletarItemPedido(Long id) {
        try {
            ItemPedido itemPedido = buscarItemPedidoPorId(id);
            itemPedidoRepository.delete(itemPedido);
        } catch (Exception ex) {
            log.error("Erro inesperado ao deletar item do pedido com ID: {}", id, ex);
            throw new DatabaseException("Erro no banco de dados");
        }
    }
}
