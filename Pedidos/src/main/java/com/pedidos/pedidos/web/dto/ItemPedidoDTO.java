package com.pedidos.pedidos.web.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemPedidoDTO {
    private Long id;
    private Long idPastel;
    private int quantidade;
}