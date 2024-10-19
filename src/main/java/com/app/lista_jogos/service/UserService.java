package com.app.lista_jogos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.app.lista_jogos.dto.UserDTO;
import com.app.lista_jogos.entity.RoleEntity;
import com.app.lista_jogos.entity.UserEntity;
import com.app.lista_jogos.repository.RoleRepository;
import com.app.lista_jogos.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;
	private Optional<UserEntity> targetUser;
	
	
	public List<UserDTO> listAll(){
		List<UserEntity> usuarios = userRepository.findAll();
		return usuarios.stream().map(UserDTO::new).toList();
	}
	
	public void insert(UserDTO usuario) {
		Optional<RoleEntity> roleEntity = roleRepository.findById(1);
		UserEntity usuarioEntity = new UserEntity(usuario);
		//TODO Verificart se role id foi encontrado
		usuarioEntity.setRole(roleEntity.get());
		usuarioEntity.setPassword(passwordEncoder.encode(usuario.getPassword()));
		userRepository.save(usuarioEntity);
	}
	
	public UserDTO update(UserDTO usuario) {
//		if(usuario.getUsername() == null) {
//			targetUser = userRepository.findByUsername(usuario.getUsername());
//		}else {
//			targetUser = userRepository.findByEmail(usuario.getUsername());
//			}
		targetUser = userRepository.findByUsernameOrEmail(usuario.getUsername(), usuario.getEmail());
		if(targetUser.isPresent()) {
			UserEntity user = targetUser.get();
			  
	        if (usuario.getPassword() != null && !usuario.getPassword().isEmpty()) {
	        	user.setPassword(passwordEncoder.encode(usuario.getPassword()));
	        }
	        
	        if (usuario.getPhone_number() != null && !usuario.getPhone_number().isEmpty()) {
	        	user.setPhone_number(usuario.getPhone_number());
	        }

	        return new UserDTO(userRepository.save(user));
		}
		else {
			  throw new RuntimeException("Usuário não encontrado");
		}
	}
	
	public void excluir(Long id) {
		UserEntity usuario = userRepository.findById(id).get();
		userRepository.delete(usuario);
	}
	
	public UserDTO buscarPorId(Long id) {
		return new UserDTO(userRepository.findById(id).get());
	}
}
