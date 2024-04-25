package br.com.fiap.motos.dto.response;

public class FabricanteResponse {

    private Long id;
    private String nome;
    private String nomeFantasia;

    public FabricanteResponse(Long id, String nome, String nomeFantasia) {
        this.id = id;
        this.nome = nome;
        this.nomeFantasia = nomeFantasia;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }
}
