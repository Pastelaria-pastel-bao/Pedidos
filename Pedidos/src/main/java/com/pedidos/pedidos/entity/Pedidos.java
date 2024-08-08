package com.pedidos.pedidos.entity;

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

    @Column
    private Long idUsuario;

    @Column(nullable = false)
    @NotNull
    private String endereco;

    @Column
    private LocalDateTime horaPagamento;

    @Column
    private LocalDateTime horaEntrega;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    private List<ItemPedido> itensPedido = new ArrayList<>();


    @Enumerated(EnumType.STRING)
    @NotNull
    private Situacao situacao = Situacao.PAGAMENTO_PENDENTE;

    @Enumerated(EnumType.STRING)
    private FormaPagamento formaPagamento;

    @Column(updatable = false)
    private LocalDateTime dataCriacao;

    @Column
    private LocalDateTime dataAtualizacao;

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
