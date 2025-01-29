package com.propostaweb.api.repository;

import com.propostaweb.api.entity.PropostaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PropostaRepository extends JpaRepository<PropostaEntity, Long> {

    List<PropostaEntity> findAllByIntegradaIsFalse();
}
