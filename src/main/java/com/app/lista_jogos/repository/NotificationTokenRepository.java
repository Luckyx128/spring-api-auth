package com.app.lista_jogos.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.app.lista_jogos.entity.NotificationTokenEntity;

public interface NotificationTokenRepository extends JpaRepository<NotificationTokenEntity, Long> {
}
