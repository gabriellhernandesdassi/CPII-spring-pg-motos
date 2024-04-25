package br.com.fiap.motos.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.time.Year;


public record VeiculoRequest (

        @NotNull(message = "preco é obrigatório")
        Double preco,

        @NotNull(message = "modelo é obrigatório")
        String modelo,

        @NotNull(message = "ano de fabricacao é obrigatório")
        Year anoDeFabricante,

        @NotNull(message = "cor é obrigatório")
        String cor,

        @NotNull(message = "nome é obrigatório")
        String nome,

        @Valid
        @NotNull(message = "tipo é obrigatório")
        AbstractRequest tipo,

        @Valid
        @NotNull(message = "fabricante é obrigatório")
        AbstractRequest fabricante,


        @NotNull(message = "cilindrada é obrigatório")
        Short cilindradas
) {
}