package com.pedidos.pedidos.feing;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
@FeignClient(name = "cadastrousuarios", url = "${usuarios.api.url}")
public interface UsuariosClient {
    @GetMapping("/id/{id}")
    Usuarios getById(@PathVariable("id") Long id);

}