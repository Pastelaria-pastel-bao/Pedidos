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

    public @NotNull Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(@NotNull Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public @NotNull String getEndereco() {
        return endereco;
    }

    public void setEndereco(@NotNull String endereco) {
        this.endereco = endereco;
    }

    public @NotNull Pedidos.FormaPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(@NotNull Pedidos.FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }
}