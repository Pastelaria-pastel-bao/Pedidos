package com.pedidos.pedidos.web.models;

import com.pedidos.pedidos.entity.Pedidos;
import com.pedidos.pedidos.entity.ItemPedido;
import com.pedidos.pedidos.web.dto.ItemPedidoDTO;
import com.pedidos.pedidos.web.dto.PedidoAtualizacaoDTO;
import com.pedidos.pedidos.web.dto.PedidoCriacaoDTO;
import com.pedidos.pedidos.web.dto.PedidoDetalhadoDTO;
import org.modelmapper.ModelMapper;

import java.util.List;

public class PedidoMapper {

    private static final ModelMapper modelMapper = new ModelMapper();

    public static Pedidos paraPedido(PedidoCriacaoDTO dto) {
        return modelMapper.map(dto, Pedidos.class);
    }

    public static Pedidos paraPedido(PedidoAtualizacaoDTO dto) {
        Pedidos pedido = modelMapper.map(dto, Pedidos.class);
        if (dto.getItensPedido() != null) {
            List<ItemPedido> itensPedido = dto.getItensPedido().stream()
                    .map(itemDto -> modelMapper.map(itemDto, ItemPedido.class))
                    .toList();
            pedido.setItensPedido(itensPedido);
        }
        return pedido;
    }

    public static PedidoDetalhadoDTO paraDetalhadoDTO(Pedidos pedido) {
        PedidoDetalhadoDTO dto = modelMapper.map(pedido, PedidoDetalhadoDTO.class);
        List<ItemPedidoDTO> itensPedidoDTO = pedido.getItensPedido().stream()
                .map(item -> modelMapper.map(item, ItemPedidoDTO.class))
                .toList();
        dto.setItensPedido(itensPedidoDTO);
        return dto;
    }
}

