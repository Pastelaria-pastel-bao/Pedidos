package com.pedidos.pedidos.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "itens_pedido")
public class ItemPedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long idPastel;

    @Column
    private int quantidade;

    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private Pedidos pedido;

    public Long getIdPastel() {
        return idPastel;
    }
}
