package com.pedidos.pedidos.web.dto;

import lombok.Getter;
import lombok.Setter;


public class ItemPedidoAtualizacaoDTO {
    private Long idPastel;
    private int quantidade;

    public Long getIdPastel() {
        return idPastel;
    }

    public void setIdPastel(Long idPastel) {
        this.idPastel = idPastel;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
