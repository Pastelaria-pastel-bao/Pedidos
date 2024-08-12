package com.pedidos.pedidos.swagger;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import com.pedidos.pedidos.entity.Pedidos;
import com.pedidos.pedidos.web.dto.ItemPedidoDTO;
import com.pedidos.pedidos.web.dto.PedidoAtualizacaoDTO;
import com.pedidos.pedidos.web.dto.PedidoCriacaoDTO;
import com.pedidos.pedidos.web.dto.PedidoDetalhadoDTO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = "Pedido", description = "Endpoints para o gerenciamento de Pedidos")
public interface PedidoSwagger {

    @Operation(summary = "Cria Pedido", description = "Cria um Pedido",
    tags = {"Pedido"},
    responses = {
        @ApiResponse(description = "Criado", responseCode = "201",
        content = {
            @Content(
                mediaType = "application/json",
                array = @ArraySchema(schema = @Schema(implementation = PedidoDetalhadoDTO.class)) 
            )
        }),
        @ApiResponse(description = "Unprocessable Entity", responseCode = "422", content = @Content),
        @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
    })
    ResponseEntity<PedidoDetalhadoDTO> criarPedido(@Valid @RequestBody PedidoCriacaoDTO pedidoCriacaoDTO);


    @Operation(summary = "Busca Pedido pelo Id", description = "Busca um Pedido pelo Id",
    tags = {"Pedido"},
    responses = {
        @ApiResponse(description = "Ok", responseCode = "200",
        content = {
            @Content(
                mediaType = "application/json",
                array = @ArraySchema(schema = @Schema(implementation = PedidoDetalhadoDTO.class)) 
            )
        }),
        @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
        @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
    })
    ResponseEntity<PedidoDetalhadoDTO> buscarPedidoPorId(@PathVariable Long id);


    @Operation(summary = "Atualiza Pedido pelo Id", description = "Atualiza um Pedido pelo seu Id",
    tags = {"Pedido"},
    responses = {
        @ApiResponse(description = "Ok", responseCode = "200",
        content = {
            @Content(
                mediaType = "application/json",
                array = @ArraySchema(schema = @Schema(implementation = PedidoDetalhadoDTO.class)) 
            )
        }),
        @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
        @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
    })
    ResponseEntity<PedidoDetalhadoDTO> atualizarPedido(@PathVariable Long id, @RequestBody PedidoAtualizacaoDTO pedidoAtualizadoDTO);


    @Operation(summary = "Atualiza a Situação do Pedido pelo Id", description = "Atualiza a Situação de um Pedido pelo seu Id",
    tags = {"Pedido"},
    responses = {
        @ApiResponse(description = "Ok", responseCode = "200",
        content = {
            @Content(
                mediaType = "application/json",
                array = @ArraySchema(schema = @Schema(implementation = PedidoDetalhadoDTO.class)) 
            )
        }),
        @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
        @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
    })
    ResponseEntity<PedidoDetalhadoDTO> atualizarSituacao(@PathVariable Long id, @RequestBody Pedidos.Situacao situacaoAtual);


    @Operation(summary = "Deleta Pedido pelo Id", description = "Deleta um Pedido pelo seu Id",
    tags = {"Pedido"},
    responses = {
        @ApiResponse(description = "Ok", responseCode = "200"),
        @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
        @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
    })
    ResponseEntity<Void> deletarPedido(@PathVariable Long id);


    @Operation(summary = "Lista Pedidos", description = "Lista todos os Pedidos",
    tags = {"Pedido"},
    responses = {
        @ApiResponse(description = "Ok", responseCode = "200",
        content = {
            @Content(
                mediaType = "application/json",
                array = @ArraySchema(schema = @Schema(implementation = List.class)) 
            )
        }),
        @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
    })
    ResponseEntity<List<PedidoDetalhadoDTO>> listarPedidos();
}
