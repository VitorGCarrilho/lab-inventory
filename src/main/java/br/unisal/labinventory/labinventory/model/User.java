package br.unisal.labinventory.labinventory.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import br.unisal.labinventory.labinventory.model.enumeration.UserType;

@Entity
public class User {
	@Id 
	@Column(unique=true)
	private long cpf;
	
	@NotNull
	@NotEmpty
	private String name;
	
	private UserType userType;
	
	@Column(unique=true)
	private long ra;

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

	public long getRa() {
		return ra;
	}

	public void setRa(long ra) {
		this.ra = ra;
	}

	public long getCpf() {
		return cpf;
	}

	public void setCpf(long cpf) {
		this.cpf = cpf;
	}
}
