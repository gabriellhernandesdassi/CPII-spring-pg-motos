package br.com.fiap.motos.resource;

import br.com.fiap.motos.dto.request.FabricanteRequest;
import br.com.fiap.motos.dto.response.FabricanteResponse;
import br.com.fiap.motos.entity.Fabricante;
import br.com.fiap.motos.service.FabricanteService;
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
@RequestMapping(value = "/fabricantes")
public class FabricanteResource implements ResourceDTO<Fabricante, FabricanteRequest, FabricanteResponse> {

    @Autowired
    private FabricanteService fabricanteService;

    @GetMapping
    public ResponseEntity<Collection<FabricanteResponse>> findAll(
            @RequestParam(name="nome", required = false) String nome,
            @RequestParam(name="nomeFantasia", required = false) String nomeFantasia
    ) {
        var fabricante = Fabricante.builder()
                .nome(nome)
                .nomeFantasia(nomeFantasia)
                .build();

        ExampleMatcher matcher = ExampleMatcher.matchingAll()
                .withIgnoreNullValues()
                .withIgnoreCase();
        Example<Fabricante> example = Example.of(fabricante, matcher);

        var encontrados = fabricanteService.findAll(example);

        if (encontrados.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        var resposta = encontrados.stream()
                .map(fabricanteService::toResponse)
                .toList();

        return ResponseEntity.ok(resposta);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<FabricanteResponse> findById(@PathVariable Long id) {
        var encontrado = fabricanteService.findById(id);
        if (encontrado == null) {
            return ResponseEntity.notFound().build();
        }
        var resposta = fabricanteService.toResponse(encontrado);
        return ResponseEntity.ok(resposta);
    }

    @Override
    @PostMapping
    @Transactional
    public ResponseEntity<FabricanteResponse> save(@RequestBody @Valid FabricanteRequest request) {
        var entity = fabricanteService.toEntity(request);
        var saved = fabricanteService.save(entity);
        var resposta = fabricanteService.toResponse(saved);

        var uri = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(saved.getId())
                .toUri();

        return ResponseEntity.created(uri).body(resposta);
    }
}
