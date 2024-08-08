package com.pedidos.pedidos.web.cpntroller;

import com.pedidos.pedidos.entity.Pedidos;
import com.pedidos.pedidos.service.PedidosService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/api/v1/pasteis")
@Validated
public class PedidosController {

    private final PedidosService pedidosService;

    public PedidosController(PedidosService pasteisService) {
        this.pedidosService = pasteisService;
    }


    @PostMapping
    public ResponseEntity<Pedidos> criar(@Valid @RequestBody Pedidos p) {
        Pedidos pedidos = pedidosService.criar(p);
        return ResponseEntity.status(HttpStatus.CREATED).body(pedidos);
    }


    @GetMapping("/id/{id}")
    public ResponseEntity<Optional<Pedidos>> getById(@PathVariable Long id) {
        return ResponseEntity.ok(pedidosService.getById(id));
    }


    @DeleteMapping("/id/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        pedidosService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}