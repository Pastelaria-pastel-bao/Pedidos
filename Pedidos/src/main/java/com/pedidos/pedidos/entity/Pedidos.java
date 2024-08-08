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

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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

}
