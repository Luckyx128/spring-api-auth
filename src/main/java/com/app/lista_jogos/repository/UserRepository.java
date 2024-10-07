package com.app.lista_jogos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.lista_jogos.entity.UserEntity;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity,Long> {
	/**
	 * Procura no banco um usuario que contenha o username e password enviados.
	 * @param username
	 * @param password
	 * @return User | null
	 */
	Optional<UserEntity> findByUsername(String username);
}
