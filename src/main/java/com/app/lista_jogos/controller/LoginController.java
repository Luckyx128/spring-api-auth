package com.app.lista_jogos.controller;

import com.app.lista_jogos.model.User;
import com.app.lista_jogos.repository.UserRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api.lista.jogos/")
public class LoginController {

    @Autowired
    private UserRepository userRepository;
    Map<String, Object> response = new HashMap<>();
    @GetMapping
    public Map<String,Object> ver(){
    	response.clear();
        return response;
    }

    @PostMapping("/login")
    public Map<String,Object> singIn(@RequestBody @NotNull User usuario){
    	response.clear();
        String username = usuario.getUsername();
        String password = usuario.getPassword();

        Optional<User> authenticated_user = userRepository.findByUsernameAndPassword(username,password);
        return response;
    }
    
    /**
     * Cadastrar usuario no banco 
     * @param usuario
     */
    @PostMapping("/cadastro")
    public Map<String, Object> singUp(@RequestBody @NotNull User usuario) {
    	response.clear();
    	try {
//    		userRepository.save(usuario);
    		response.put("result", "Usuario cadastrado com sucesso!");
    		
    	}catch (Exception e) {
			// TODO: handle exception
    		response.put("result", "Erro durante o cadastro! Tente novamente em alguns minutos.");
		}
    	return response;
    }
}
