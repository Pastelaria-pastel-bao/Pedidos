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
public class Usuarios {

    @Id
    private Long id;
    private String nome;
    private String email;
    private String cpf;
    private String telefone;
    private String endereco;
    private String senha;

}
