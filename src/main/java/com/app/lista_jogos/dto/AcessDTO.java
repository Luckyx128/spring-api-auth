package com.app.lista_jogos.dto;

public class AcessDTO {
	private String token;

	//TODO implementar retorna o usuario e liberacoes ( O que o token libera)
	public AcessDTO(String token) {
		super();
		this.token = token;
	}
	
	public String getToken() {
		return token;
	}


	public void setToken(String token) {
		this.token = token;
	}
	
}
