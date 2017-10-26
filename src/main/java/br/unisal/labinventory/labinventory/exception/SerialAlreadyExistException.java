package br.unisal.labinventory.labinventory.exception;

public class SerialAlreadyExistException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2076082432923372601L;
	
	public SerialAlreadyExistException(){}
	
	public SerialAlreadyExistException(String message){
		super(message);
	}

}
