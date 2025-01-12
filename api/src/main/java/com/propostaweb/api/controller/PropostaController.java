package com.propostaweb.api.controller;

import com.propostaweb.api.dto.PropostaRequestDto;
import com.propostaweb.api.dto.PropostaResponseDto;
import com.propostaweb.api.service.PropostaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
