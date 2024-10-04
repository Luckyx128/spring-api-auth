package com.app.lista_jogos.controller;

import com.app.lista_jogos.model.User;
import com.app.lista_jogos.repository.UserRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.app.lista_jogos.util.HashConvert;

import java.security.NoSuchAlgorithmException;
import java.util.*;

@RestController
@RequestMapping("/api.lista.jogos/")
public class LoginController {

    @Autowired
    private UserRepository userRepository;
    private Map<String, Object> response = new HashMap<>();
    private HashConvert hexconvert = new HashConvert();
    private User user = new User();
    
    @GetMapping
    public Map<String,Object> ver(){
    	response.clear();
    	response.put("result", user);
        return response;
    }

    @PostMapping("/login")
    public Map<String,Object> singIn(@RequestBody @NotNull User user){
    	
    	response.clear();
        String username = user.getUsername();
        String password = user.getPassword();
        
        try {
			hexconvert.gerarHash(password);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        Optional<User> authenticated_user = userRepository.findByUsernameAndPassword(username,password);
        response.put("result", authenticated_user);
        
        return response;
    }
    
    /**
     * Cadastrar usuario no banco 
     * @param usuario
     */
    @PostMapping("/cadastro")
    public Map<String, Object> singUp(@RequestBody @NotNull User user) {
    	response.clear();
    	try {
    		userRepository.save(user);
    		response.put("result", "Usuario cadastrado com sucesso!");
    		
    	}catch (Exception e) {
			// TODO: handle exception
    		response.put("result", "Erro durante o cadastro! Tente novamente em alguns minutos.");
		}
    	return response;
    }
}
