package br.com.fiap.motos.service;

import br.com.fiap.motos.dto.request.AcessorioRequest;
import br.com.fiap.motos.dto.response.AcessorioResponse;
import br.com.fiap.motos.entity.Acessorio;
import br.com.fiap.motos.repository.AcessorioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AcessorioService implements ServiceDTO<Acessorio, AcessorioRequest, AcessorioResponse> {

    @Autowired
    private AcessorioRepository acessorioRepository;

    @Override
    public Acessorio toEntity(AcessorioRequest request) {
        return Acessorio.builder()
                .nome(request.nome())
                .preco(request.preco())
                .build();
    }

    @Override
    public AcessorioResponse toResponse(Acessorio entity) {
        return AcessorioResponse.builder()
                .id(entity.getId())
                .nome(entity.getNome())
                .preco(entity.getPreco())
                .build();
    }

    @Override
    public List<Acessorio> findAll(Example<Acessorio> example) {
        return acessorioRepository.findAll(example);
    }

    @Override
    public Acessorio findById(Long id) {
        return acessorioRepository.findById(id).orElse(null);
    }

    @Override
    public Acessorio save(Acessorio entity) {
        return acessorioRepository.save(entity);
    }
}