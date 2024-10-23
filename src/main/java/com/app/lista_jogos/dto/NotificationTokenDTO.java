package com.app.lista_jogos.dto;

import org.springframework.beans.BeanUtils;

import com.app.lista_jogos.entity.NotificationTokenEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter


public class NotificationTokenDTO {
	
	private String token;
	private String username;
	
	
	public NotificationTokenDTO() {
    	
    }
    
    public NotificationTokenDTO(NotificationTokenEntity notification) {
		BeanUtils.copyProperties(notification, this);
    }

}
