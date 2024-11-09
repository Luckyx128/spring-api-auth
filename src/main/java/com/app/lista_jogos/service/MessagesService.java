package com.app.lista_jogos.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.lista_jogos.dto.MessagesDTO;
import com.app.lista_jogos.entity.MessagesEntity;
import com.app.lista_jogos.entity.UserEntity;
import com.app.lista_jogos.repository.MessagesRepository;
import com.app.lista_jogos.repository.UserRepository;

@Service
public class MessagesService {
	@Autowired
	private MessagesRepository messagesRepository;
	@Autowired
	private UserRepository userRepository;
	
	public List<MessagesEntity> verMenssagens(String matricula) {
		Optional<UserEntity> userEntity = userRepository.findByUsername(matricula);
		if(userEntity.isPresent()) {
			Optional<List<MessagesEntity>> messagesOptional = messagesRepository.findByUserEntityOrderByDataenvioDesc(userEntity.get());			
			if(messagesOptional.isPresent()) {
				
				return messagesOptional.get();
			}
		}
		return null;
	}
	
	public void enviarMensagens(MessagesDTO mensagem){
		Optional<UserEntity> user = userRepository.findByUsername(mensagem.getMatricula());
		MessagesEntity messagesEntity = new MessagesEntity(mensagem);
		messagesEntity.setUserEntity(user.get());
		messagesRepository.save(messagesEntity);
	}
	
	

}
