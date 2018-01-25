package br.com.saude.prontuario.model.validations;

import javax.validation.ValidationException;


public class ValidationUtils {

	public static void throwException() {

		throw new ValidationException();
	
	}
	
	public static void throwException(String msg) {

		throw new ValidationException(msg);
	
	}

}
