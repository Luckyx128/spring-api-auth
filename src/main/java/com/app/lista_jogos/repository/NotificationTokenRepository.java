package com.app.lista_jogos.repository;


import com.app.lista_jogos.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import com.app.lista_jogos.entity.NotificationTokenEntity;

import java.util.Optional;

public interface NotificationTokenRepository extends JpaRepository<NotificationTokenEntity, Long> {
    public Optional<NotificationTokenEntity> findByUserEntity(UserEntity userEntity);
}