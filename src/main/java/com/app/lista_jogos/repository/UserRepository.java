package com.app.lista_jogos.repository;

import com.app.lista_jogos.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
	/**
	 * Procura no banco um usuario que contenha o username e password enviados.
	 * @param username
	 * @param password
	 * @return User | null
	 */
    Optional<User> findByUsernameAndPassword(String username,String password);
}
