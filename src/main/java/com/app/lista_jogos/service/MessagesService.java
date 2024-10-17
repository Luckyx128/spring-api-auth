package com.app.lista_jogos.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.lista_jogos.dto.MessagesDTO;
import com.app.lista_jogos.entity.MessagesEntity;
import com.app.lista_jogos.repository.MessagesRepository;

@Service
public class MessagesService {
	@Autowired
	private MessagesRepository messagesRepository;
	private List<MessagesDTO> messagesDTO = new ArrayList<>();
	
	public List<MessagesEntity> verMenssagens(String matricula) {
		return messagesRepository.findByMatricula(matricula);
		
	}
	
	public void enviarMensagens(MessagesDTO mensagem){
		MessagesEntity messagesEntity = new MessagesEntity(mensagem);
		messagesRepository.save(messagesEntity);
	}
	
	

}
