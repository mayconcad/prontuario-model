package br.com.saude.prontuario.model.handlers;
import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerFactory;

public class ServiceExceptionHandlerFactory extends ExceptionHandlerFactory {

	private final ExceptionHandlerFactory parent;

	public ServiceExceptionHandlerFactory( ExceptionHandlerFactory parent ) {
		this.parent = parent;
	}

	@Override
	public ExceptionHandler getExceptionHandler() {
		return new ServiceExceptionHandler( parent.getExceptionHandler() );
	}

}