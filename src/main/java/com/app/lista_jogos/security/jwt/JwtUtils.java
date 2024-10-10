package com.app.lista_jogos.security.jwt;

import java.security.Key;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.app.lista_jogos.service.UserDetailsImpl;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtils {
	
	@Value("${projeto.jwtSecret}")
	private String jwtSecret;
	
	@Value("${projeto.jwtExpirationMs}")
	private int jwtExpirationMs;
	
	public String genereteTokenFromUserDetailsImpl(UserDetailsImpl userDetails) {
		return Jwts.builder().setSubject(userDetails.getUsername())
				.setIssuedAt(new Date())
				.setExpiration(new Date(new Date().getTime()+jwtExpirationMs))
				.signWith(getSignKey(), SignatureAlgorithm.HS512).compact();
	}
	private Key getSignKey() {
		SecretKey key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));
		return key;
	}
	
	public String getUsernameToken(String token) {
		return Jwts.parser().setSigningKey(getSignKey()).build()
				.parseClaimsJws(token).getBody().getSubject();
	}
	
	public boolean validadeJwtToken(String authString) {
		try {
			Jwts.parser().setSigningKey(getSignKey()).build().parseClaimsJws(authString);
			return true;
		}catch(MalformedJwtException e) {
			System.out.println("Token invalido " + e.getMessage());
		} catch (ExpiredJwtException e) {
			System.out.println("Token expirado " + e.getMessage());
	    } catch (UnsupportedJwtException e) {
	    	System.out.println("Token não suportado " + e.getMessage());
	    } catch (IllegalArgumentException e) {
	    	System.out.println("Token argumento invalido " + e.getMessage());
	    }
		return false;
	}
}
