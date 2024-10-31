package com.app.lista_jogos.dto;

import org.springframework.beans.BeanUtils;

import com.app.lista_jogos.entity.MessagesEntity;

public class MessagesDTO {
	
	private Long id_messages;
	private String matricula;
	private String dataenvio;
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

	public String getDataenvio() {
		return dataenvio;
	}

	public void setDataenvio(String data_envio) {
		this.dataenvio = data_envio;
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
