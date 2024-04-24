package br.com.fiap.motos.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record AbstractRequest(

        @Positive(message = "Id tem que ser maior que zero")
        @NotNull(message = "Id obrigatorio")
        Long id

) {
}