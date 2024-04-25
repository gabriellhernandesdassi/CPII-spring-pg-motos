package br.com.fiap.motos.dto.response;

import java.time.Year;

public class VeiculoResponse {

    private Double preco;
    private String modelo;
    private String cor;
    private Year anoDeFabricante;
    private Short cilindradas;
    private String nome;
    private TipoVeiculoResponse tipo;
    private FabricanteResponse fabricante;
    private Long id;

    public VeiculoResponse(Double preco, String modelo, String cor, Year anoDeFabricante, Short cilindradas, String nome, TipoVeiculoResponse tipo, FabricanteResponse fabricante, Long id) {
        this.preco = preco;
        this.modelo = modelo;
        this.cor = cor;
        this.anoDeFabricante = anoDeFabricante;
        this.cilindradas = cilindradas;
        this.nome = nome;
        this.tipo = tipo;
        this.fabricante = fabricante;
        this.id = id;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public Year getAnoDeFabricante() {
        return anoDeFabricante;
    }

    public void setAnoDeFabricante(Year anoDeFabricante) {
        this.anoDeFabricante = anoDeFabricante;
    }

    public Short getCilindradas() {
        return cilindradas;
    }

    public void setCilindradas(Short cilindradas) {
        this.cilindradas = cilindradas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoVeiculoResponse getTipo() {
        return tipo;
    }

    public void setTipo(TipoVeiculoResponse tipo) {
        this.tipo = tipo;
    }

    public FabricanteResponse getFabricante() {
        return fabricante;
    }

    public void setFabricante(FabricanteResponse fabricante) {
        this.fabricante = fabricante;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
