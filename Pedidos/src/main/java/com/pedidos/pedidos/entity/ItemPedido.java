package com.pedidos.pedidos.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


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

<<<<<<< Updated upstream
    public Long getIdPastel() {
        return idPastel;
    }
=======
    public ItemPedido(Long idPastel, int quantidade, Pedidos pedido, Long id) {
        this.idPastel = idPastel;
        this.quantidade = quantidade;
        this.pedido = pedido;
        this.id = id;
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

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Pedidos getPedido() {
        return pedido;
    }

    public void setPedido(Pedidos pedido) {
        this.pedido = pedido;
    }

    public ItemPedido() {
    }
>>>>>>> Stashed changes
}
