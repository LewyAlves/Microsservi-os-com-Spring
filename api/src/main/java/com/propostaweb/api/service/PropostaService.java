package com.propostaweb.api.service;

import com.propostaweb.api.dto.PropostaRequestDto;
import com.propostaweb.api.dto.PropostaResponseDto;
import com.propostaweb.api.entity.PropostaEntity;
import com.propostaweb.api.mapper.PropostaMapper;
import com.propostaweb.api.repository.PropostaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropostaService {

    @Autowired
    private PropostaRepository propostaRepository;

    @Autowired
    private PropostaMapper propostaMapper;

    @Autowired
    private NotificacaoService notificacaoService;


    public PropostaResponseDto criarProposta(PropostaRequestDto dto){
        PropostaEntity entity = propostaMapper.dtoToProposta(dto);
        PropostaEntity entitySave = propostaRepository.save(entity);

        PropostaResponseDto response = propostaMapper.entityToResponse(entitySave);
        notificacaoService.notificar(response,"proposta-pendente.ex");

        return response;
    }

    public List<PropostaResponseDto> obterTodos() {
        List<PropostaEntity> propostas = propostaRepository.findAll();

        return propostaMapper.entityToList(propostas);
    }
}
