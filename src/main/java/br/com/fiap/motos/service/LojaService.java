package br.com.fiap.motos.service;

import br.com.fiap.motos.dto.request.LojaRequest;
import br.com.fiap.motos.dto.response.LojaResponse;
import br.com.fiap.motos.entity.Loja;
import br.com.fiap.motos.repository.LojaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LojaService implements ServiceDTO<Loja, LojaRequest, LojaResponse> {

    @Autowired
    private LojaRepository lojaRepository;

    @Override
    public Loja toEntity(LojaRequest request) {
        return Loja.builder()
                .nome(request.nome())
                .build();
    }

    @Override
    public LojaResponse toResponse(Loja entity) {
        return LojaResponse.builder()
                .id(entity.getId())
                .nome(entity.getNome())
                .build();
    }

    @Override
    public List<Loja> findAll(Example<Loja> example) {
        return lojaRepository.findAll(example);
    }

    @Override
    public Loja findById(Long id) {
        return lojaRepository.findById(id).orElse(null);
    }

    @Override
    public Loja save(Loja entity) {
        return lojaRepository.save(entity);
    }
}