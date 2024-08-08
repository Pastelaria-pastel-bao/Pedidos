package com.pedidos.pedidos.web.dto;

import com.pedidos.pedidos.entity.ItemPedido;
import com.pedidos.pedidos.entity.Pedidos;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PedidoDetalhadoDTO {
    private Long id;
    private Long idUsuario;
    private String endereco;
    private LocalDateTime horaPagamento;
    private LocalDateTime horaEntrega;
    private Pedidos.Situacao situacao;
    private Pedidos.FormaPagamento formaPagamento;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataAtualizacao;
    private List<ItemPedidoDTO> itensPedido; // Usando DTO específico para ItemPedido
}
