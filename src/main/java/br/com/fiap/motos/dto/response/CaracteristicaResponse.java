package br.com.fiap.motos.dto.response;

public class CaracteristicaResponse {

    private String nome;
    private String descricao;
    private Long id;
    private VeiculoResponse veiculo;

    public CaracteristicaResponse(String nome, String descricao, Long id, VeiculoResponse veiculo) {
        this.nome = nome;
        this.descricao = descricao;
        this.id = id;
        this.veiculo = veiculo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public VeiculoResponse getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(VeiculoResponse veiculo) {
        this.veiculo = veiculo;
    }
}
