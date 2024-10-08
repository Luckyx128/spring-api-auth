package com.app.lista_jogos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.app.lista_jogos.dto.UserDTO;
import com.app.lista_jogos.entity.UserEntity;
import com.app.lista_jogos.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public List<UserDTO> listAll(){
		List<UserEntity> usuarios = userRepository.findAll();
		return usuarios.stream().map(UserDTO::new).toList();
	}
	
	public void insert(UserDTO usuario) {
		UserEntity usuarioEntity = new UserEntity(usuario);
		usuarioEntity.setPassword(passwordEncoder.encode(usuario.getPassword()));
		userRepository.save(usuarioEntity);
	}
	
	public UserDTO update(UserDTO usuario) {
		UserEntity userEntity = new UserEntity(usuario);
		userEntity.setPassword(passwordEncoder.encode(usuario.getPassword()));
		return new UserDTO(userRepository.save(userEntity));
	}
	
	public void excluir(Long id) {
		UserEntity usuario = userRepository.findById(id).get();
		userRepository.delete(usuario);
	}
	
	public UserDTO buscarPorId(Long id) {
		return new UserDTO(userRepository.findById(id).get());
	}
}
