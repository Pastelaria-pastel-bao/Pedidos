package com.pedidos.pedidos.web.dto;

import com.pedidos.pedidos.entity.ItemPedido;
import com.pedidos.pedidos.entity.Pedidos;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PedidoAtualizacaoDTO {
    private List<ItemPedidoDTO> itensPedido;
    private String endereco;
    private Pedidos.FormaPagamento formaPagamento;

    public List<ItemPedidoDTO> getItensPedido() {
        return itensPedido;
    }

    public void setItensPedido(List<ItemPedidoDTO> itensPedido) {
        this.itensPedido = itensPedido;
    }

    public Pedidos.FormaPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(Pedidos.FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}

