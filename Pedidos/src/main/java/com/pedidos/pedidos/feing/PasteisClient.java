package com.pedidos.pedidos.feing;

import org.springframework.cloud.openfeign.FeignClient;
<<<<<<< Updated upstream
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
@FeignClient(name = "cadastramento", url = "${cadastramento.api.url}")
public interface PasteisClient {
=======
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "cadastramento", url = "${pasteis.api.url}")
 public interface PasteisClient {
>>>>>>> Stashed changes

    @GetMapping("/id/{id}")
    Pasteis getById(@PathVariable("id") Long id);

<<<<<<< Updated upstream

=======
>>>>>>> Stashed changes
}