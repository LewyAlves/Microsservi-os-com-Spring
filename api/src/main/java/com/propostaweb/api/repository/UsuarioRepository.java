package com.propostaweb.api.repository;

import com.propostaweb.api.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository  extends JpaRepository<UsuarioEntity, Long> {
}
