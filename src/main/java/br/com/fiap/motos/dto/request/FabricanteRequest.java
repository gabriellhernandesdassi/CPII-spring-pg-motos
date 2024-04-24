package br.com.fiap.motos.dto.request;

import jakarta.validation.constraints.NotNull;

public record FabricanteRequest(

        @NotNull(message = "nome e obrigatorio")
        String nome,

        @NotNull(message = "nome fantasia e obrigatório")
        String nomeFantasia
) {
}
