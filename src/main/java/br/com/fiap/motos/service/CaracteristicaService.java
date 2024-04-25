package br.com.fiap.motos.service;

import br.com.fiap.motos.dto.request.CaracteristicaRequest;
import br.com.fiap.motos.dto.response.CaracteristicaResponse;
import br.com.fiap.motos.entity.Caracteristica;
import br.com.fiap.motos.repository.CaracteristicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CaracteristicaService implements ServiceDTO<Caracteristica, CaracteristicaRequest, CaracteristicaResponse> {

    @Autowired
    private CaracteristicaRepository caracteristicaRepository;

    @Autowired
    private VeiculoService veiculoService;

    @Override
    public Caracteristica toEntity(CaracteristicaRequest request) {
        var veiculo = veiculoService.findById(request.veiculo().id());
        return Caracteristica.builder()
                .nome(request.nome())
                .descricao(request.descricao())
                .veiculo(veiculo)
                .build();
    }

    @Override
    public CaracteristicaResponse toResponse(Caracteristica entity) {
        var veiculo = veiculoService.toResponse(entity.getVeiculo());
        return CaracteristicaResponse.builder()
                .id(entity.getId())
                .nome(entity.getNome())
                .descricao(entity.getDescricao())
                .veiculo(veiculo)
                .build();
    }

    @Override
    public List<Caracteristica> findAll(Example<Caracteristica> example) {
        return caracteristicaRepository.findAll(example);
    }

    @Override
    public Caracteristica findById(Long id) {
        return caracteristicaRepository.findById(id).orElse(null);
    }

    @Override
    public Caracteristica save(Caracteristica entity) {
        return caracteristicaRepository.save(entity);
    }
}