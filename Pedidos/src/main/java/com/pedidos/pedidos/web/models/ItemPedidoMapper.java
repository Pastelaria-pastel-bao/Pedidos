package com.pedidos.pedidos.web.models;

import com.pedidos.pedidos.entity.ItemPedido;
import com.pedidos.pedidos.web.dto.ItemPedidoDTO;
import com.pedidos.pedidos.web.dto.ItemPedidoAtualizacaoDTO;
import org.modelmapper.ModelMapper;

public class ItemPedidoMapper {

    private static final ModelMapper modelMapper = new ModelMapper();

    public static ItemPedido paraItemPedido(ItemPedidoDTO dto) {
        return modelMapper.map(dto, ItemPedido.class);
    }
    
    public static ItemPedidoDTO paraItemPedidoDTO(ItemPedido itemPedido) {
        return modelMapper.map(itemPedido, ItemPedidoDTO.class);
    }

    public static ItemPedido paraItemPedido(ItemPedidoAtualizacaoDTO dto) {
        return modelMapper.map(dto, ItemPedido.class);
    }
}
