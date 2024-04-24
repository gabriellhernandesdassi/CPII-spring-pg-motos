package br.com.fiap.motos.dto.request;

import jakarta.validation.constraints.NotNull;

public record AcessorioRequest(

        @NotNull(message = "nome é obrigatório")
        String nome,

        @NotNull(message = "preco é obrigatório")
        Double preco
) {
}
