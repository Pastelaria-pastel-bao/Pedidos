package com.pedidos.pedidos.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

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
    private String endereco;

    @Column
    private LocalDateTime horaPagamento;

    @Column
    private LocalDateTime horaEntrega;

    @Enumerated(EnumType.STRING)
    private Situacao situacao;

    @Enumerated(EnumType.STRING)
    private FormaPagamento formaPagamento;

    public enum Situacao {
       PAGAMENTO_PENDENTE, PAGO, EM_ANDAMENTO, PRONTO_RETIRADA, SAIU_ENTREGA, CONCLUIDO;
    }

    public enum FormaPagamento {
       PIX, DINHEIRO, CARTAO;
    }

}
