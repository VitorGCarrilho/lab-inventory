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
	
	private UserType userType;
	
	@Column(unique=true)
	private long ra;
	
	@Column(unique=true)
	private long cpf;
 
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setRa(Long ra) {
		this.ra = ra;
	}

	public void setCpf(Long cpf) {
		this.cpf = cpf;
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
