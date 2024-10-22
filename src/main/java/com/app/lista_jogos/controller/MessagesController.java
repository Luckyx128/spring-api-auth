package com.app.lista_jogos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.lista_jogos.dto.MessagesDTO;
import com.app.lista_jogos.entity.MessagesEntity;
import com.app.lista_jogos.service.MessagesService;

@RestController
@RequestMapping(value = "/messages")
@CrossOrigin
public class MessagesController {
	
	@Autowired
	private MessagesService messagesService;
	
	@GetMapping(value = "/{matricula}")
	public List<MessagesEntity> verMensagens(@PathVariable("matricula") String matricula) {
		return messagesService.verMenssagens(matricula);
//		TODO FInalizar função para ler os as mensagens 
	}
	
	@PostMapping()
	public void enviarMensagem(@RequestBody MessagesDTO messagesDTO) {
		messagesService.enviarMensagens(messagesDTO);
	}
}
	