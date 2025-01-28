package com.propostaweb.api.mapper;

import com.propostaweb.api.dto.PropostaRequestDto;
import com.propostaweb.api.dto.PropostaResponseDto;
import com.propostaweb.api.entity.PropostaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.data.domain.Page;

import java.text.NumberFormat;
import java.util.List;


@Mapper(componentModel = "spring")
public interface PropostaMapper {

    @Mapping(target = "usuario.nome", source = "nome")
    @Mapping(target = "usuario.sobrenome", source = "sobrenome")
    @Mapping(target = "usuario.cpf", source = "cpf")
    @Mapping(target = "usuario.telefone", source = "telefone")
    @Mapping(target = "usuario.renda", source = "renda")
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "aprovada", ignore = true)
    @Mapping(target = "integrada", constant = "true")
    @Mapping(target = "observacao", ignore = true)
    PropostaEntity dtoToProposta(PropostaRequestDto request);

    @Mapping(target = "nome", source = "usuario.nome")
    @Mapping(target = "sobrenome", source = "usuario.sobrenome")
    @Mapping(target = "telefone", source = "usuario.telefone")
    @Mapping(target = "cpf", source = "usuario.cpf")
    @Mapping(target = "renda", source = "usuario.renda")
    @Mapping(target = "valorSolicitadoFmt", expression = "java(setValorSolicitadoFmt(proposta))")
    PropostaResponseDto entityToResponse(PropostaEntity proposta);

    default List<PropostaResponseDto> entityToList(List<PropostaEntity> entities) {
        return entities.stream().map(this::entityToResponse).toList();
    }

    default String setValorSolicitadoFmt(PropostaEntity entity){
        return NumberFormat.getCurrencyInstance().format(entity.getValorSolicitado());
    }
}
