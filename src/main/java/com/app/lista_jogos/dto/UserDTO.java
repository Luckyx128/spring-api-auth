package com.app.lista_jogos.dto;

import org.springframework.beans.BeanUtils;

import com.app.lista_jogos.entity.UserEntity;

public class UserDTO {
	
	private String name;	
	private String username;	
	private String password;
	private String phone_number;
	private String email;
	private String   role;
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public UserDTO(UserEntity usuario) {
		BeanUtils.copyProperties(usuario, this);
		this.setRole(usuario.getRole());
	}
	public UserDTO() {
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
