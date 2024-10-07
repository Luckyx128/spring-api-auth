package com.app.lista_jogos.entity;

import java.util.Objects;

import org.springframework.beans.BeanUtils;

import com.app.lista_jogos.dto.UserDTO;


import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "username",nullable = false,length = 50,unique = true)	
    private String username;

    @Column(name = "name",nullable = false,length = 100)
    private String name;

    @Column(name = "email",nullable = false,length = 50)
    private String email;

    @Column(name = "phone_number")
    private String phone_number;

    @Column(name = "password",nullable = false)
    private String password;
    
    @Column(name = "role", nullable = false)
    private String role = "USER";
    
    @ManyToOne
    @JoinColumn(name =  "role_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_role"))
    private RoleEntity roleEntity;
    
    public UserEntity(UserDTO usuario) {
		BeanUtils.copyProperties(usuario, this);
	}

    public UserEntity() {
		
	}

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserEntity other = (UserEntity) obj;
		return Objects.equals(id, other.id);
	}

}
