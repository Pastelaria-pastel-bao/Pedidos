package com.pedidos.pedidos.service;

import com.pedidos.pedidos.entity.Pedidos;
import com.pedidos.pedidos.exeptions.DatabaseException;
import com.pedidos.pedidos.exeptions.InvalidInputException;
import com.pedidos.pedidos.exeptions.PedidoNaoEncontradoException;
import com.pedidos.pedidos.repository.PedidosRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

import static org.hibernate.query.sqm.tree.SqmNode.log;

@Slf4j
@Service
@RequiredArgsConstructor
public class PedidosService {

    private final PedidosRepository pedidosRepository;


    public PedidosService(PedidosRepository pedidosRepository) {
        this.pedidosRepository = pedidosRepository;
    }

    @Transactional
    public Pedidos criar(Pedidos pedidos) {
        try {
            return pedidosRepository.save(pedidos);
        } catch (InvalidInputException ex) {
            log.error("Erro ao criar pedido: {}", pedidos, ex);
            throw ex;
        } catch (Exception ex) {
            log.error("Erro inesperado ao criar pedido: {}", pedidos, ex);
            throw new DatabaseException("Erro no banco de dados");
        }
    }

    @Transactional
    public Optional<Pedidos> getById(Long id) {
        try {
            if (id <= 0) {
                throw new InvalidInputException("ID inválido");
            }
            return Optional.ofNullable(pedidosRepository.findById(id)
                    .orElseThrow(() -> new PedidoNaoEncontradoException("Pedido não encontrado")));
        } catch (PedidoNaoEncontradoException | InvalidInputException ex) {
            log.error("Erro ao buscar pedido por ID: {}", id, ex);
            throw ex;
        } catch (Exception ex) {
            log.error("Erro inesperado ao buscar pedido por ID: {}", id, ex);
            throw new DatabaseException("Erro no banco de dados");
        }
    }


    @Transactional
    public void deleteById(Long id) {
        try {
            if (id <= 0) {
                throw new InvalidInputException("ID inválido");
            }
            if (!pedidosRepository.existsById(id)) {
                throw new PedidoNaoEncontradoException("Pedido não encontrado");
            }
            pedidosRepository.deleteById(id);
        } catch (PedidoNaoEncontradoException | InvalidInputException ex) {
            log.error("Erro ao deletar pedido por ID: {}", id, ex);
            throw ex;
        } catch (Exception ex) {
            log.error("Erro inesperado ao deletar pedido por ID: {}", id, ex);
            throw new DatabaseException("Erro no banco de dados");
        }
    }


}
