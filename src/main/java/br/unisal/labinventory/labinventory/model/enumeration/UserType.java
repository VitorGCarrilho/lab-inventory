package br.unisal.labinventory.labinventory.model.enumeration;

public enum UserType {
	STUDENT("Aluno"),
	ADMIN("admin");
	
	UserType(String value){
		this.value = value;
	}
	
	private String value;
	
	public String getValue(){
		return value;
	}
}
