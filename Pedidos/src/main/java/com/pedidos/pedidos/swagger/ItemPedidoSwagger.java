package com.pedidos.pedidos.swagger;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import com.pedidos.pedidos.web.dto.ItemPedidoAtualizacaoDTO;
import com.pedidos.pedidos.web.dto.ItemPedidoDTO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "ItemPedido", description = "Endpoints para gerenciamento de usuario")
public interface ItemPedidoSwagger {

    @Operation(summary = "Cria ItemPedido", description = "Cria um Item Pedido",
    tags = {"ItemPedido"},
    responses = {
        @ApiResponse(description = "Criado", responseCode = "201",
        content = {
            @Content(
                mediaType = "application/json",
                array = @ArraySchema(schema = @Schema(implementation = ItemPedidoDTO.class)) 
            )
        }),
        @ApiResponse(description = "Unprocessable Entity", responseCode = "422", content = @Content),
        @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
    })
    ResponseEntity<ItemPedidoDTO> adicionarItemPedido(@PathVariable Long pedidoId, @RequestBody ItemPedidoDTO itemPedidoDTO);


    @Operation(summary = "Busca ItemPedido pelo Id", description = "Busca um Item Pedido pelo seu Id",
    tags = {"ItemPedido"},
    responses = {
        @ApiResponse(description = "Ok", responseCode = "200",
        content = {
            @Content(
                mediaType = "application/json",
                array = @ArraySchema(schema = @Schema(implementation = ItemPedidoDTO.class)) 
            )
        }),
        @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
        @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
    })
    ResponseEntity<ItemPedidoDTO> buscarItemPedidoPorId(@PathVariable Long id);


    @Operation(summary = "Atualiza ItemPedido pelo Id", description = "Atualiza um ItemPedido pelo seu Id",
    tags = {"ItemPedido"},
    responses = {
        @ApiResponse(description = "Ok", responseCode = "200",
        content = {
            @Content(
                mediaType = "application/json",
                array = @ArraySchema(schema = @Schema(implementation = ItemPedidoDTO.class)) 
            )
        }),
        @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
        @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
    })
    ResponseEntity<ItemPedidoDTO> atualizarItemPedido(@PathVariable Long id, @RequestBody ItemPedidoAtualizacaoDTO itemPedidoAtualizacaoDTO);


    @Operation(summary = "Deleta ItemPedido pelo Id", description = "Deleta um ItemPedido pelo seu Id",
    tags = {"ItemPedido"},
    responses = {
        @ApiResponse(description = "No Content", responseCode = "204"),
        @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
        @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
    })
    ResponseEntity<Void> deletarItemPedido(@PathVariable Long id);
}
