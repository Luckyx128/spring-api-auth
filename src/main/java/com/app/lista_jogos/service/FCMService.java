package com.app.lista_jogos.service;

import com.app.lista_jogos.entity.NotificationTokenEntity;
import com.app.lista_jogos.repository.NotificationTokenRepository;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;
import com.google.firebase.messaging.FirebaseMessagingException;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FCMService {

	@Autowired
	NotificationTokenRepository notificationTokenRepository;
	
    public void sendNotification() throws FirebaseMessagingException {
        
    	List<NotificationTokenEntity>optionalNotification = notificationTokenRepository.findAll();
    	
    	NotificationTokenEntity notificationTokenEntity = optionalNotification.get(0);
    	String token = notificationTokenEntity.getToken();
    	String title = "Nova mensagem para você!";
    	String body  = "Venha conferir as ultimas atualizações!";
    	Message message = Message.builder()
            .setToken(token)
            .setNotification(Notification.builder()
                .setTitle(title)
                .setBody(body)
                .build())
            .build();

        String response = FirebaseMessaging.getInstance().send(message);
        System.out.println("Mensagem enviada com sucesso: " + response);
    }
}

