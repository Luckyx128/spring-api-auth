package com.app.lista_jogos.dto;

import org.springframework.beans.BeanUtils;

import com.app.lista_jogos.entity.MessagesEntity;

public class MessagesDTO {
	
	private Long id_messages;
	private String matricula;
	private String data_envio;
	private String motivo;
	private String conteudo;
	
	public MessagesDTO(MessagesEntity messages) {
		BeanUtils.copyProperties(messages, this);
	}
	public MessagesDTO() {
	
	}
	public Long getid_messages() {
		return id_messages;
	}

	public void setid_messages(Long id) {
		this.id_messages = id;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getData_envio() {
		return data_envio;
	}

	public void setData_envio(String data_envio) {
		this.data_envio = data_envio;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}
	
	
}
