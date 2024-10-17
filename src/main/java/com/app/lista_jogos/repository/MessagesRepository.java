package com.app.lista_jogos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.lista_jogos.entity.MessagesEntity;

public interface MessagesRepository extends JpaRepository<MessagesEntity, Long> {
	
	public List<MessagesEntity> findByMatricula(String matricula);

}
