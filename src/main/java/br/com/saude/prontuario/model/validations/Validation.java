package br.com.saude.prontuario.model.validations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Target( ElementType.METHOD )
@Retention( RetentionPolicy.RUNTIME )
public @interface Validation {

	abstract ValidationType[] values();
	
}
