package com.pedidos.pedidos.feing;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@AllArgsConstructor
@NoArgsConstructor
@Getter

public class Pasteis {
    @Id
    private Long id;
    private String sabor;
    private Tamanho tamanho;
    private String descricao;
    private Double preco;

    public enum Tamanho {
        PEQUENO, MEDIO, GRANDE
    }
}