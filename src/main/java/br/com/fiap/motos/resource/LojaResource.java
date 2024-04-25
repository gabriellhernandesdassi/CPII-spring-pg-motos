package br.com.fiap.motos.resource;

import br.com.fiap.motos.dto.request.LojaRequest;
import br.com.fiap.motos.dto.request.VeiculoRequest;
import br.com.fiap.motos.dto.response.LojaResponse;
import br.com.fiap.motos.dto.response.VeiculoResponse;
import br.com.fiap.motos.entity.Loja;
import br.com.fiap.motos.entity.Veiculo;
import br.com.fiap.motos.service.LojaService;
import br.com.fiap.motos.service.VeiculoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.Collection;

@RestController
@RequestMapping("/loja")
public class LojaResource implements ResourceDTO<Loja, LojaRequest, LojaResponse> {

    @Autowired
    private LojaService lojaService;

    @Autowired
    private VeiculoService veiculoService;

    @GetMapping
    public ResponseEntity<Collection<LojaResponse>> findAll(
            @RequestParam(name="nome", required = false) String nome
    ) {
        var loja = Loja.builder()
                .nome(nome)
                .build();

        ExampleMatcher matcher = ExampleMatcher.matchingAll()
                .withIgnoreNullValues()
                .withIgnoreCase();

        Example<Loja> example = Example.of(loja, matcher);

        var encontrados = lojaService.findAll(example);

        if (encontrados.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        var resposta = encontrados.stream()
                .map(lojaService::toResponse)
                .toList();

        return ResponseEntity.ok(resposta);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<LojaResponse> findById(@PathVariable Long id) {
        var encontrado = lojaService.findById(id);
        if (encontrado == null) {
            return ResponseEntity.notFound().build();
        }
        var resposta = lojaService.toResponse(encontrado);
        return ResponseEntity.ok(resposta);
    }

    @Override
    @PostMapping
    @Transactional
    public ResponseEntity<LojaResponse> save(@RequestBody @Valid LojaRequest r) {
        var entity = lojaService.toEntity(r);
        var saved = lojaService.save(entity);
        var resposta = lojaService.toResponse(saved);

        var uri = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(saved.getId())
                .toUri();

        return ResponseEntity.created(uri).body(resposta);
    }

    @PostMapping("/{id}/veiculos")
    @Transactional
    public ResponseEntity<LojaResponse> saveVeiculo(@RequestBody @Valid VeiculoRequest r, @PathVariable Long id) {
        var loja = lojaService.findById(id);
        if (loja == null) {
            return ResponseEntity.notFound().build();
        }

        Veiculo veiculo = veiculoService.toEntity(r);
        var veiculos = loja.getVeiculosComercializados();
        veiculos.add(veiculo);
        loja.setVeiculosComercializados(veiculos);

        var saved = lojaService.save(loja);
        var resposta = lojaService.toResponse(saved);

        var uri = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(saved.getId())
                .toUri();

        return ResponseEntity.created(uri).body(resposta);
    }

    @GetMapping("/{id}/veiculos")
    public ResponseEntity<Collection<VeiculoResponse>> findVeiculos(@PathVariable Long id) {
        var loja = lojaService.findById(id);
        if (loja == null) {
            return ResponseEntity.notFound().build();
        }

        var veiculos = loja.getVeiculosComercializados();
        if (veiculos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        var resposta = veiculos.stream()
                .map(veiculoService::toResponse)
                .toList();

        return ResponseEntity.ok(resposta);
    }
}
