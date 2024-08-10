package com.pedidos.pedidos.feing;

<<<<<<< Updated upstream
import jakarta.persistence.Id;
=======
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
>>>>>>> Stashed changes
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

<<<<<<< Updated upstream
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Getter

public class Pasteis {
    @Id
=======
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Pasteis {
>>>>>>> Stashed changes
    private Long id;
    private String sabor;
    private Tamanho tamanho;
    private String descricao;
    private Double preco;

    public enum Tamanho {
        PEQUENO, MEDIO, GRANDE
    }
}