package com.app.lista_jogos.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.lista_jogos.entity.RoleEntity;

public interface RoleRepository extends JpaRepository<RoleEntity, Long> {

	Optional<RoleEntity> findById(long i);
	
}
