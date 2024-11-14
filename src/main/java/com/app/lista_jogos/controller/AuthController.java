package com.app.lista_jogos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.lista_jogos.dto.AuthenticationDTO;
import com.app.lista_jogos.service.AuthService;
import com.app.lista_jogos.service.RefreshToken;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {
	
	@Autowired
	private AuthService authService;
	
	@PostMapping(value = "/login")
	public ResponseEntity<?> login(@RequestBody AuthenticationDTO authDto){
		if(authDto.getUsername().isBlank() || authDto.getPassword().isBlank()) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Campos vazios!");
		}
		return ResponseEntity.ok(authService.login(authDto));
	}
	
	@PostMapping("/refresh-token")
	public ResponseEntity<?> refreshToken(@RequestBody RefreshToken refreshToken) {
	    if(authService.refreshToken(refreshToken.getToken()) != null)	{
		
	    	return ResponseEntity.ok(authService.refreshToken(refreshToken.getToken()));
	    } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Refresh token is invalid!");
	    }
	}
}

