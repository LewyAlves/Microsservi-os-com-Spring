package com.propostaweb.api.service;

import com.propostaweb.api.dto.PropostaRequestDto;
import com.propostaweb.api.dto.PropostaResponseDto;
import com.propostaweb.api.entity.PropostaEntity;
import com.propostaweb.api.mapper.PropostaMapper;
import com.propostaweb.api.repository.PropostaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

    @Value("${rabbitmq.propostapendente.exchange}")
    private String exchange;


    public PropostaResponseDto criarProposta(PropostaRequestDto dto){
        PropostaEntity entity = propostaMapper.dtoToProposta(dto);
        propostaRepository.save(entity);

        PropostaResponseDto response = propostaMapper.entityToResponse(entity);

        notificarRabbitMQ(entity);

        return response;
    }

    private void notificarRabbitMQ(PropostaEntity proposta){
        try {
            notificacaoService.notificar(proposta,exchange);
        } catch (RuntimeException e){
            proposta.setIntegrada(false);
            propostaRepository.save(proposta);
        }
    }

    public List<PropostaResponseDto> obterTodos() {
        List<PropostaEntity> propostas = propostaRepository.findAll();

        return propostaMapper.entityToList(propostas);
    }
}
