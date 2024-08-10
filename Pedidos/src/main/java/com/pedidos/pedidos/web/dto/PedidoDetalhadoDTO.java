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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<ItemPedidoDTO> getItensPedido() {
        return itensPedido;
    }

    public void setItensPedido(List<ItemPedidoDTO> itensPedido) {
        this.itensPedido = itensPedido;
    }

    public LocalDateTime getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Pedidos.FormaPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(Pedidos.FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public Pedidos.Situacao getSituacao() {
        return situacao;
    }

    public void setSituacao(Pedidos.Situacao situacao) {
        this.situacao = situacao;
    }

    public LocalDateTime getHoraEntrega() {
        return horaEntrega;
    }

    public void setHoraEntrega(LocalDateTime horaEntrega) {
        this.horaEntrega = horaEntrega;
    }

    public LocalDateTime getHoraPagamento() {
        return horaPagamento;
    }

    public void setHoraPagamento(LocalDateTime horaPagamento) {
        this.horaPagamento = horaPagamento;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }
}
