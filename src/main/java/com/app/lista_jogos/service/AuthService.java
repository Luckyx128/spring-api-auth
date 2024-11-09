package com.app.lista_jogos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.app.lista_jogos.dto.AcessDTO;
import com.app.lista_jogos.dto.AuthenticationDTO;
import com.app.lista_jogos.security.jwt.JwtUtils;

@Service
public class AuthService {
	
	@Autowired
	private AuthenticationManager authenticatioManager;

	@Autowired
    private UserDetailServiceImpl UserDetailServiceImpl;
	
	@Autowired
	private JwtUtils jwtUtils;
	
	public AcessDTO login(AuthenticationDTO authDto) {
		try {
			
		//Cria mecanismo de credencial para o spring
			UsernamePasswordAuthenticationToken userAuth = 
					new UsernamePasswordAuthenticationToken(authDto.getUsername(), authDto.getPassword());
		//Prepara mecanismo para autenticação
			Authentication authentication = authenticatioManager.authenticate(userAuth);
		
		//Busca usuario logado
		UserDetailsImpl userAutenticate = (UserDetailsImpl)authentication.getPrincipal();
		
		String token = jwtUtils.genereteTokenFromUserDetailsImpl(userAutenticate);
		String refreshToken = jwtUtils.generateRefreshToken(userAutenticate);

            return new AcessDTO(token,refreshToken);
		}catch (BadCredentialsException e) {
			throw e;
		}
	}
	public AcessDTO refreshToken(String token) throws UsernameNotFoundException {
		boolean validate = jwtUtils.validateRefreshToken(token);
		if(validate) {
			 String username = jwtUtils.getUsernameFromRefreshToken(token);	
			
			 UserDetailsImpl userDetails = UserDetailServiceImpl.loadUserByUsername(username);
			 String newAcessToken = jwtUtils.genereteTokenFromUserDetailsImpl(userDetails);
			 String refreshToken = jwtUtils.generateRefreshToken(userDetails);

            return new AcessDTO(newAcessToken,refreshToken);
		}
		return null;
		
	}
}

	