package com.pedidos.pedidos.web.dto;

import lombok.Getter;
import lombok.Setter;


public class ItemPedidoDTO {
    private Long id;
    private Long idPastel;
    private int quantidade;

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Long getIdPastel() {
        return idPastel;
    }

    public void setIdPastel(Long idPastel) {
        this.idPastel = idPastel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}