package br.com.sts.ddum.model.utils;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;


public class MessageContext {
	
	public static FacesContext getContext() {
		return FacesContext.getCurrentInstance();
	}
	
	public static void addInfo(String msg) {
		getContext().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, msg, null));
	}
	
	public static void addWarn(String msg) {
		getContext().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, msg, null));
	}
	
	public static void addError(String msg) {
		getContext().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, "business"));
	}
	

}
