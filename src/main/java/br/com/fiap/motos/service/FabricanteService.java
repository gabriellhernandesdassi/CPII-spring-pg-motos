package br.com.fiap.motos.service;

import br.com.fiap.motos.dto.request.FabricanteRequest;
import br.com.fiap.motos.dto.response.FabricanteResponse;
import br.com.fiap.motos.entity.Fabricante;
import br.com.fiap.motos.repository.FabricanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FabricanteService implements ServiceDTO<Fabricante, FabricanteRequest, FabricanteResponse> {

    @Autowired
    private FabricanteRepository fabricanteRepository;

    @Override
    public Fabricante toEntity(FabricanteRequest request) {
        return Fabricante.builder()
                .nome(request.nome())
                .nomeFantasia(request.nomeFantasia())
                .build();
    }

    @Override
    public FabricanteResponse toResponse(Fabricante entity) {
        return FabricanteResponse.builder()
                .id(entity.getId())
                .nome(entity.getNome())
                .nomeFantasia(entity.getNomeFantasia())
                .build();
    }

    @Override
    public List<Fabricante> findAll(Example<Fabricante> example) {
        return fabricanteRepository.findAll(example);
    }

    @Override
    public Fabricante findById(Long id) {
        return fabricanteRepository.findById(id).orElse(null);
    }

    @Override
    public Fabricante save(Fabricante entity) {
        return fabricanteRepository.save(entity);
    }
}