package br.com.fiap.motos.service;

import br.com.fiap.motos.dto.request.VeiculoRequest;
import br.com.fiap.motos.dto.response.VeiculoResponse;
import br.com.fiap.motos.entity.Veiculo;
import br.com.fiap.motos.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VeiculoService implements ServiceDTO<Veiculo, VeiculoRequest, VeiculoResponse> {

    @Autowired
    private VeiculoRepository veiculoRepository;

    @Autowired
    private TipoVeiculoService tipoVeiculoService;

    @Autowired
    private FabricanteService fabricanteService;

    @Override
    public Veiculo toEntity(VeiculoRequest request) {
        var tipo = tipoVeiculoService.findById(request.tipo().id());
        var fabricante = fabricanteService.findById(request.fabricante().id());
        return Veiculo.builder()
                .tipo(tipo)
                .fabricante(fabricante)
                .preco(request.preco())
                .modelo(request.modelo())
                .anoDeFabricacao(request.anoDeFabricante())
                .cor(request.cor())
                .palavraDeEfeito(request.palavraDeEfeito())
                .cilindradas(request.cilindradas())
                .nome(request.nome())
                .build();
    }

    @Override
    public VeiculoResponse toResponse(Veiculo entity) {
        var fabricante = fabricanteService.toResponse(entity.getFabricante());
        var tipo = tipoVeiculoService.toResponse(entity.getTipo());
        return VeiculoResponse.builder()
                .id(entity.getId())
                .nome(entity.getNome())
                .modelo(entity.getModelo())
                .anoDeFabricante(entity.getAnoDeFabricacao())
                .preco(entity.getPreco())
                .palavraDeEfeito(entity.getPalavraDeEfeito())
                .fabricante(fabricante)
                .tipo(tipo)
                .cilindradas(entity.getCilindradas())
                .build();
    }

    @Override
    public List<Veiculo> findAll(Example<Veiculo> example) {
        return veiculoRepository.findAll(example);
    }

    @Override
    public Veiculo findById(Long id) {
        return veiculoRepository.findById(id).orElse(null);
    }

    @Override
    public Veiculo save(Veiculo entity) {
        return veiculoRepository.save(entity);
    }
}