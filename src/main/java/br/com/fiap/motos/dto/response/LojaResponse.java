package br.com.fiap.motos.dto.response;

import java.util.Set;

public class LojaResponse {

    private String nome;
    private Set<VeiculoResponse> veiculosComercializados;
    private Long id;

    public LojaResponse(String nome, Set<VeiculoResponse> veiculosComercializados, Long id) {
        this.nome = nome;
        this.veiculosComercializados = veiculosComercializados;
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<VeiculoResponse> getVeiculosComercializados() {
        return veiculosComercializados;
    }

    public void setVeiculosComercializados(Set<VeiculoResponse> veiculosComercializados) {
        this.veiculosComercializados = veiculosComercializados;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}