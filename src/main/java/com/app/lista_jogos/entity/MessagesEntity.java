package com.app.lista_jogos.entity;

import org.springframework.beans.BeanUtils;

import com.app.lista_jogos.dto.MessagesDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
@Table(name = "messages")
public class MessagesEntity {
	@Override
	public String toString() {
		return "MessagesEntity [data_envio=" + data_envio + ", motivo=" + motivo + ", conteudo=" + conteudo + "]";
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
	
	@Column(name = "matricula_destino",nullable = false)
	private String matricula;
	
	@Column(name = "data_envio",nullable = false)
	private String data_envio;
	
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
