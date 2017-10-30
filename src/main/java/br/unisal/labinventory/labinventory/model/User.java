package br.unisal.labinventory.labinventory.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import br.unisal.labinventory.labinventory.model.enumeration.UserType;

@Entity
public class User {
	@Id
	@GeneratedValue
	private Long id;
	
	@NotNull
	@NotEmpty
	private String name;
	
	@NotNull
	@NotEmpty
	@Column(unique=true)
	private String email;
	
	private UserType userType;
	
	@Column(unique=true)
	private String ra; 
	
	@Column(unique=true)
	private String cpf;
 
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	public String getRa() {
		return ra;
	}

	public void setRa(String ra) {
		if (ra.isEmpty()) ra = null;
		this.ra = ra;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
