package com.pedidos.pedidos.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name= "pedidos")
public class Pedidos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long idUsuario;

    @Column(nullable = false)
    @NotNull
    private String endereco;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private FormaPagamento formaPagamento;

    //--------------------------------------------

    @Column
    private LocalDateTime horaPagamento;

    @Column
    private LocalDateTime horaEntrega;

    @Column(updatable = false)
    private LocalDateTime dataCriacao;

    @Column
    private LocalDateTime dataAtualizacao;

    //--------------------------------------------

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<ItemPedido> itensPedido = new ArrayList<>();


    @Enumerated(EnumType.STRING)
    @NotNull
    private Situacao situacao = Situacao.PAGAMENTO_PENDENTE;

    @PrePersist
    protected void onCreate() {
        dataCriacao = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        dataAtualizacao = LocalDateTime.now();
    }

    public enum Situacao {
       PAGAMENTO_PENDENTE, PAGO, EM_ANDAMENTO, PRONTO_RETIRADA, SAIU_ENTREGA, CONCLUIDO;
    }

    public enum FormaPagamento {
       PIX, DINHEIRO, CARTAO;
    }

    public Pedidos(Long id, Situacao situacao, List<ItemPedido> itensPedido, LocalDateTime dataAtualizacao, LocalDateTime dataCriacao, LocalDateTime horaEntrega, FormaPagamento formaPagamento, String endereco, Long idUsuario, LocalDateTime horaPagamento) {
        this.id = id;
        this.situacao = situacao;
        this.itensPedido = itensPedido;
        this.dataAtualizacao = dataAtualizacao;
        this.dataCriacao = dataCriacao;
        this.horaEntrega = horaEntrega;
        this.formaPagamento = formaPagamento;
        this.endereco = endereco;
        this.idUsuario = idUsuario;
        this.horaPagamento = horaPagamento;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public FormaPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public @NotNull String getEndereco() {
        return endereco;
    }

    public void setEndereco(@NotNull String endereco) {
        this.endereco = endereco;
    }

    public LocalDateTime getHoraPagamento() {
        return horaPagamento;
    }

    public void setHoraPagamento(LocalDateTime horaPagamento) {
        this.horaPagamento = horaPagamento;
    }

    public LocalDateTime getHoraEntrega() {
        return horaEntrega;
    }

    public void setHoraEntrega(LocalDateTime horaEntrega) {
        this.horaEntrega = horaEntrega;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public List<ItemPedido> getItensPedido() {
        return itensPedido;
    }

    public void setItensPedido(List<ItemPedido> itensPedido) {
        this.itensPedido = itensPedido;
    }

    public @NotNull Situacao getSituacao() {
        return situacao;
    }

    public void setSituacao(@NotNull Situacao situacao) {
        this.situacao = situacao;
    }

    public LocalDateTime getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    public Pedidos() {
    }
}
