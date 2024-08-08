package com.pedidos.pedidos.service;

import com.pedidos.pedidos.entity.ItemPedido;
import com.pedidos.pedidos.entity.Pedidos;
import com.pedidos.pedidos.exeptions.DatabaseException;
import com.pedidos.pedidos.exeptions.PedidoNaoEncontradoException;
import com.pedidos.pedidos.repository.PedidosRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class PedidoService {

    private final PedidosRepository pedidosRepository;
    @Transactional
    public Pedidos criarPedido(Pedidos pedido) {
        try {
            return pedidosRepository.save(pedido);
        } catch (Exception ex) {
            log.error("Erro inesperado ao criar pedido: {}", pedido, ex);
            throw new DatabaseException("Erro no banco de dados");
        }
    }
    @Transactional
    public Optional<Pedidos> buscarPedidoPorId(Long id) {
        try {
            if (id <= 0) {
                throw new IllegalArgumentException("ID inválido");
            }
            return pedidosRepository.findById(id);
        } catch (Exception ex) {
            log.error("Erro inesperado ao buscar pedido por ID: {}", id, ex);
            throw new DatabaseException("Erro no banco de dados");
        }
    }

    @Transactional
    public Pedidos atualizarPedido(Long id, Pedidos pedidoAtualizado) {
        Pedidos pedidoExistente = buscarPedidoPorId(id)
                .orElseThrow(() -> new PedidoNaoEncontradoException("Pedido não encontrado com ID: " + id));

        // Atualiza os campos do pedido existente com os dados recebidos
        if (pedidoAtualizado.getEndereco() != null) {
            pedidoExistente.setEndereco(pedidoAtualizado.getEndereco());
        }

        // Atualiza os itens do pedido, se presentes
        if (pedidoAtualizado.getItensPedido() != null) {
            pedidoExistente.getItensPedido().clear();
            pedidoExistente.getItensPedido().addAll(pedidoAtualizado.getItensPedido());
        }

        if (pedidoAtualizado.getFormaPagamento() != null) {
            pedidoExistente.setFormaPagamento(pedidoAtualizado.getFormaPagamento());
        }

        // Salva e força a sincronização com o banco de dados
        Pedidos pedidoSalvo = pedidosRepository.save(pedidoExistente);
        pedidosRepository.flush(); // Força a sincronização com o banco de dados

        return pedidoSalvo;
    }



    @Transactional
    public Pedidos atualizarSituacao(Long id, Pedidos.Situacao pedidoAtualizado) {
        try {
            Pedidos pedidoExistente = buscarPedidoPorId(id)
                    .orElseThrow(() -> new PedidoNaoEncontradoException("Pedido não encontrado com ID: " + id));

            if (pedidoAtualizado == Pedidos.Situacao.PAGO) {
                pedidoExistente.setHoraPagamento(LocalDateTime.now());
            }
            if (pedidoAtualizado== Pedidos.Situacao.CONCLUIDO) {
                pedidoExistente.setHoraEntrega(LocalDateTime.now());
            }
            pedidoExistente.setSituacao(pedidoAtualizado);
            return pedidosRepository.save(pedidoExistente);
        } catch (Exception ex) {
            log.error("Erro inesperado ao atualizar pedido com ID: {}", id, ex);
            throw new DatabaseException("Erro no banco de dados");
        }
    }

    @Transactional
    public void deletarPedido(Long id) {
        try {
            if (id <= 0) {
                throw new IllegalArgumentException("ID inválido");
            }
            if (!pedidosRepository.existsById(id)) {
                throw new PedidoNaoEncontradoException("Pedido não encontrado com ID: " + id);
            }
            pedidosRepository.deleteById(id);
        } catch (PedidoNaoEncontradoException ex) {
            log.error("Erro ao deletar pedido por ID: {}", id, ex);
            throw ex;
        } catch (Exception ex) {
            log.error("Erro inesperado ao deletar pedido por ID: {}", id, ex);
            throw new DatabaseException("Erro no banco de dados");
        }
    }

    public  List<Pedidos> listarPedidos() {
        try {
            return pedidosRepository.findAll();
        } catch (Exception ex) {
            log.error("Erro inesperado ao listar pedidos", ex);
            throw new DatabaseException("Erro no banco de dados");
        }
    }
}
