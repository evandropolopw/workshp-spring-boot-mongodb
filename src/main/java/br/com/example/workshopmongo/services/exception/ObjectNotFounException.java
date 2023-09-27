package br.com.example.workshopmongo.services.exception;

public class ObjectNotFounException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public ObjectNotFounException(String msg) {
		super(msg);
	}
	
	
}
