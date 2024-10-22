package com.app.lista_jogos.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.lista_jogos.dto.NotificationTokenDTO;
import com.app.lista_jogos.entity.NotificationTokenEntity;
import com.app.lista_jogos.entity.UserEntity;
import com.app.lista_jogos.repository.NotificationTokenRepository;
import com.app.lista_jogos.repository.UserRepository;

@Service
public class NotificationTokenService {

	@Autowired
	private NotificationTokenRepository notificationTokenRepository;
	@Autowired
	private UserRepository userRepository;
	
	
	public void saveNotificationToken(NotificationTokenDTO notificationTokenDTO) {
		NotificationTokenEntity notificationTokenEntity = new NotificationTokenEntity(notificationTokenDTO);
		Optional<UserEntity> optional = userRepository.findById(notificationTokenDTO.getUser_id());
		notificationTokenEntity.setUserEntity(optional.get());
		notificationTokenRepository.save(notificationTokenEntity);
	}
	
}
