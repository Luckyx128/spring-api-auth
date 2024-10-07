package com.app.lista_jogos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.app.lista_jogos.dto.AcessDTO;
import com.app.lista_jogos.dto.AuthenticationDTO;
import com.app.lista_jogos.security.jwt.JwtUtils;

@Service
public class AuthService {
	
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtUtils jwtUtils;
	public AcessDTO login(AuthenticationDTO authDto) {
		try {
			
		//Cria mecanismo de credencial para o spring
		UsernamePasswordAuthenticationToken userAuth =
				new UsernamePasswordAuthenticationToken(authDto.getUsername(), authDto.getPassword());
		//Prepara mecanismo para autenticação
		Authentication authentication = authenticationManager.authenticate(userAuth);
		
		//Busca usuario logado
		UserDetailsImpl userAutenticate = (UserDetailsImpl)authentication.getPrincipal();
		
		String token = jwtUtils.genereteTokenFromUserDetailsImpl(userAutenticate);
		
		AcessDTO acessDTO = new AcessDTO(token);
		
		return acessDTO;
		}catch (BadCredentialsException e) {
			// TODO: Login ou senha invalida
		}
		return null;
	}
}
