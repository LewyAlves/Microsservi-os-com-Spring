package com.propostaweb.api.controller;

import com.propostaweb.api.dto.PropostaRequestDto;
import com.propostaweb.api.dto.PropostaResponseDto;
import com.propostaweb.api.service.PropostaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/proposta")
public class PropostaController {

    @Autowired
    private PropostaService service;

    @PostMapping
    public ResponseEntity<PropostaResponseDto> criarProposta(@RequestBody PropostaRequestDto request){
        PropostaResponseDto proposta = service.criarProposta(request);

        return ResponseEntity.status(201).body(proposta);
    }

    @GetMapping
    public ResponseEntity<List<PropostaResponseDto>> retornaTodos(){
        return ResponseEntity.ok(service.obterTodos());
    }
}
