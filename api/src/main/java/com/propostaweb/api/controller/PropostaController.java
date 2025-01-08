package com.propostaweb.api.controller;

import com.propostaweb.api.dto.PropostaRequestDto;
import com.propostaweb.api.dto.PropostaResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/proposta")
public class PropostaController {

    @PostMapping
    public ResponseEntity<PropostaResponseDto> criarProposta(@RequestBody PropostaRequestDto request){
        return null;
    }
}
