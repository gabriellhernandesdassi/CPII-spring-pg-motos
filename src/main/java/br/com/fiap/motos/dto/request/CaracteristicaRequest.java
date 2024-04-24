package br.com.fiap.motos.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record CaracteristicaRequest(

        @Valid
        @NotNull(message = "veiculo e obrigatório")
        AbstractRequest veiculo,

        @NotNull(message = "nome e obrigatório")
        String nome,

        @NotNull(message = "descricao e obrigatório")
        String descricao
) {

}
