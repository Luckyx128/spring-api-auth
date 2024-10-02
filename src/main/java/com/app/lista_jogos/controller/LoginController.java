package com.app.lista_jogos.controller;

import com.app.lista_jogos.model.User;
import com.app.lista_jogos.repository.UserRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api.lista.jogos/auth")
public class LoginController {

    @Autowired
    private UserRepository userRepository;
    private List<User> user = new ArrayList<>();

    @GetMapping
    public String ver(){
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        return "Opa";
    }

    @PostMapping("/login")
    public String singIn(@RequestBody @NotNull User user){
        String username = user.getUsername();
        String password = user.getPassword();

        Optional<User> authenticated_user = userRepository.findByUsernameAndPassword(username,password);
        return "Usuario logado";
    }
}
