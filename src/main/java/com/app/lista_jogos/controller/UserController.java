package com.app.lista_jogos.controller;

import com.app.lista_jogos.dto.UserDTO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.lista_jogos.service.UserService;

@RestController
@RequestMapping(value = "/usuario")
@CrossOrigin
public class UserController {
	

		@Autowired
		private UserService userService;
		
		@GetMapping
		public List<UserDTO> listarTodos(){
			return userService.listAll();
		}

		@PostMapping(value = "/cadastrar")
		public void insert(@RequestBody UserDTO usuario) {
			userService.insert(usuario);
		}
		
		@PutMapping
		public UserDTO update(@RequestBody UserDTO usuario) {
			return userService.update(usuario);
		}
		
		//http://endereco/usuario/3
		@DeleteMapping("/{id}")
		public ResponseEntity<Void> excluir(@PathVariable("id") Long id){
			userService.excluir(id);
			return ResponseEntity.ok().build();
		}
	}

