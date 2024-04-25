package br.com.fiap.motos.service;

import br.com.fiap.motos.dto.request.TipoVeiculoRequest;
import br.com.fiap.motos.dto.response.TipoVeiculoResponse;
import br.com.fiap.motos.entity.TipoVeiculo;
import br.com.fiap.motos.repository.TipoVeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoVeiculoService implements ServiceDTO<TipoVeiculo, TipoVeiculoRequest, TipoVeiculoResponse> {

    @Autowired
    private TipoVeiculoRepository tipoVeiculoRepository;

    @Override
    public TipoVeiculo toEntity(TipoVeiculoRequest request) {
        return TipoVeiculo.builder()
                .nome(request.nome())
                .build();
    }

    @Override
    public TipoVeiculoResponse toResponse(TipoVeiculo entity) {
        return TipoVeiculoResponse.builder()
                .id(entity.getId())
                .nome(entity.getNome())
                .build();
    }

    @Override
    public List<TipoVeiculo> findAll(Example<TipoVeiculo> example) {
        return tipoVeiculoRepository.findAll(example);
    }

    @Override
    public TipoVeiculo findById(Long id) {
        return tipoVeiculoRepository.findById(id).orElse(null);
    }

    @Override
    public TipoVeiculo save(TipoVeiculo entity) {
        return tipoVeiculoRepository.save(entity);
    }
}
