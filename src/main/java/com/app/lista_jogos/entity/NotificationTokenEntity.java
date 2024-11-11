package com.app.lista_jogos.entity;

import org.springframework.beans.BeanUtils;

import com.app.lista_jogos.dto.NotificationTokenDTO;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.ForeignKey;


@Getter
@Setter

@Entity
@Table(name="notifications_token")
public class NotificationTokenEntity {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="token",nullable = false)
	private String token;
	
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(unique = true,name = "username",referencedColumnName = "username",foreignKey = @ForeignKey(name = "fk_token_username"))
    private UserEntity userEntity;
    
    
    public NotificationTokenEntity() {
    	
    }
    
    public NotificationTokenEntity(NotificationTokenDTO notification) {
		BeanUtils.copyProperties(notification, this);
    }

	@Override
	public String toString() {
		return "NotificationTokenEntity [id=" + id + ", token=" + token + ", userEntity=" + userEntity + "]";
	}
}
