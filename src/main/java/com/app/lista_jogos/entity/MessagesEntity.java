package com.app.lista_jogos.entity;

import org.springframework.beans.BeanUtils;

import com.app.lista_jogos.dto.MessagesDTO;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
@Table(name = "messages")
public class MessagesEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "username",referencedColumnName = "username",foreignKey = @ForeignKey(name = "fk_messages_users"))
    private UserEntity userEntity;
	
	@Column(name = "data_envio",nullable = false)
	private String dataenvio;
	
	@Column(name = "motivo",nullable = false)
	private String motivo;
	
	@Column(name = "conteudo",nullable = false)
	private String conteudo;
	
	public MessagesEntity(MessagesDTO messagesDTO) {
		BeanUtils.copyProperties(messagesDTO, this);
	}
	public MessagesEntity() {
		
	}
	
}
