package com.app.lista_jogos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.lista_jogos.dto.NotificationTokenDTO;
import com.app.lista_jogos.service.FCMService;
import com.app.lista_jogos.service.NotificationTokenService;
import com.google.firebase.messaging.FirebaseMessagingException;

@RestController
@RequestMapping("/notification")
@CrossOrigin	
public class NotificationTokenController {
	
	@Autowired
	private NotificationTokenService notificationTokenService;
	@Autowired
	private FCMService fcmService;
	
	
	@PostMapping(value = "/save")
	public void save_token(@RequestBody NotificationTokenDTO notificationTokenDTO) {
		notificationTokenService.saveNotificationToken(notificationTokenDTO);

	}
	@GetMapping()
	public void send_notification() throws FirebaseMessagingException {
		// TODO Auto-generated method stub
		fcmService.sendNotification();
	}
	}
