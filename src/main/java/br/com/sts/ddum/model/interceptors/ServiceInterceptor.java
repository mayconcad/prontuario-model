package br.com.sts.ddum.model.interceptors;

import java.util.List;

import javax.faces.application.FacesMessage;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;

import br.com.sts.ddum.model.utils.MessageContext;
import br.com.sts.ddum.model.validations.ValidationUtils;

@Aspect
public class ServiceInterceptor {
	

	@After("within(@org.springframework.stereotype.Service *)")
	public void handle() throws Throwable {

		if (hasErrorMessage()) 			
			ValidationUtils.throwException();

	}

	private boolean hasErrorMessage() {

		List<FacesMessage> messages = MessageContext.getContext()
				.getMessageList();
		
		boolean clean = false;

		for (FacesMessage facesMessage : messages) {

			if (facesMessage.getSeverity() == FacesMessage.SEVERITY_ERROR
					&& "business".equals(facesMessage.getDetail())) {
				clean = true;
				facesMessage.setDetail("");
			}

		}
		
		if (clean) 
			return true;

		return false;

	}

}
