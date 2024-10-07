package com.app.lista_jogos.service;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.app.lista_jogos.entity.UserEntity;

public class UserDetailsImpl implements UserDetails {

	private Long id;
	
	private String name;
	
	private String username;
	
	private String email;
	
	private String password;
	
	public static UserDetailsImpl build(UserEntity user) {
		return new UserDetailsImpl(user.getId(),
								   user.getName(),
								   user.getUsername(),
								   user.getEmail(),
								   new ArrayList<>());
	}
	
	public UserDetailsImpl(Long id, String name, String username, String email,
			Collection<? extends GrantedAuthority> authorities) {
		super();
		this.id = id;
		this.name = name;
		this.username = username;
		this.email = email;
		this.authorities = authorities;
	}

	private Collection<? extends GrantedAuthority> authorities;
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		
		return username;
	}
	
	@Override
	public boolean isCredentialsNonExpired() {
		
		return true;
	}
	
	@Override
	public boolean isAccountNonExpired() {
	
		return true;
	}
	
	@Override
	public boolean isAccountNonLocked() {
		
		return true;
	}
	
	@Override
	public boolean isEnabled() {	
		return true;
	}

}
