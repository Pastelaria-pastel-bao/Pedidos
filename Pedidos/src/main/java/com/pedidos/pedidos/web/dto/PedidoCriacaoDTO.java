package com.pedidos.pedidos.web.dto;

import com.pedidos.pedidos.entity.Pedidos;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PedidoCriacaoDTO {
    @NotNull
    private Long idUsuario;
    @NotNull
    private String endereco;
    @NotNull
    private Pedidos.FormaPagamento formaPagamento;
}