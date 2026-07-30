package com.example.firr.controller;

import com.example.firr.dto.LicencaRequestDTO;
import com.example.firr.model.Licenca;
import com.example.firr.repository.LicencaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/licencas")
public class LicencaController {

    @Autowired
    private LicencaRepository repository;

    // 1. GET /licencas - Listar todas as licenças
    @GetMapping
    public ResponseEntity<List<Licenca>> listarTodas() {
        return ResponseEntity.ok(repository.findAll());
    }

    // 2. POST /licencas - Cadastrar uma nova licença
    @PostMapping
    public ResponseEntity<Licenca> cadastrar(@RequestBody @Valid LicencaRequestDTO dto) {
        Licenca licenca = new Licenca();
        licenca.setNome(dto.getNome());
        licenca.setOrgaoEmissor(dto.getOrgaoEmissor());
        licenca.setDataValidade(dto.getDataValidade());
        licenca.setStatus(dto.getStatus());

        Licenca salva = repository.save(licenca);
        return ResponseEntity.status(HttpStatus.CREATED).body(salva);
    }

    // 3. PUT /licencas/{id} - Atualizar uma licença existente
    @PutMapping("/{id}")
    public ResponseEntity<Licenca> atualizar(@PathVariable Long id, @RequestBody @Valid LicencaRequestDTO dto) {
        return repository.findById(id).map(licenca -> {
            licenca.setNome(dto.getNome());
            licenca.setOrgaoEmissor(dto.getOrgaoEmissor());
            licenca.setDataValidade(dto.getDataValidade());
            licenca.setStatus(dto.getStatus());
            Licenca atualizada = repository.save(licenca);
            return ResponseEntity.ok(atualizada);
        }).orElse(ResponseEntity.notFound().build());
    }

    // 4. DELETE /licencas/{id} - Deletar uma licença
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}