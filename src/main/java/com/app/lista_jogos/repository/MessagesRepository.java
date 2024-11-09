package com.app.lista_jogos.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.lista_jogos.entity.MessagesEntity;
import com.app.lista_jogos.entity.UserEntity;

public interface MessagesRepository extends JpaRepository<MessagesEntity, Long> {
  public Optional<List<MessagesEntity>> findByUserEntityOrderByDataenvioDesc(UserEntity userEntity);
}
