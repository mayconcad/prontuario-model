package br.com.sts.ddum.model.handlers;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

import javax.faces.FacesException;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerWrapper;
import javax.faces.context.FacesContext;
import javax.faces.event.ExceptionQueuedEvent;
import javax.faces.event.ExceptionQueuedEventContext;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.util.StringUtils;

import br.com.sts.ddum.model.utils.ResourceBundleUtils;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

public class ServiceExceptionHandler extends ExceptionHandlerWrapper {

	private final ExceptionHandler wrapped;

	public ServiceExceptionHandler(ExceptionHandler wrapped) {
		this.wrapped = wrapped;
	}

	@Override
	public ExceptionHandler getWrapped() {
		return this.wrapped;
	}

	public void handle() throws FacesException {
		for (Iterator<ExceptionQueuedEvent> iterator = getUnhandledExceptionQueuedEvents()
				.iterator(); iterator.hasNext();) {
			ExceptionQueuedEvent event = iterator.next();
			ExceptionQueuedEventContext context = (ExceptionQueuedEventContext) event
					.getSource();
			Throwable t = context.getException();
//			t.printStackTrace();
			try {
				handleServiceException(t);
			} finally {
				iterator.remove();
			}
		}
		getWrapped().handle();
	}

	private void handleServiceException(Throwable e) {

		FacesContext context = FacesContext.getCurrentInstance();
		Throwable throwable = ExceptionUtils.getRootCause(e);

		if (throwable instanceof ValidationException) {

		} else if (throwable instanceof ConstraintViolationException) {

			Set<ConstraintViolation<?>> constraintViolations = ((ConstraintViolationException) throwable)
					.getConstraintViolations();

			String beanValidatorMessage = ResourceBundleUtils
					.getLocalizedMessage(
							"javax.faces.validator.BeanValidator.MESSAGE",
							context.getViewRoot().getLocale());
			for (ConstraintViolation<?> constraintViolation : constraintViolations) {
				String field = StringUtils.uncapitalize(constraintViolation
						.getRootBeanClass().getSimpleName())
						+ "."
						+ constraintViolation.getPropertyPath().toString();
				String message = constraintViolation.getMessage();
				String fieldLabel = ResourceBundleUtils.getLocalizedMessage(
						field, context.getViewRoot().getLocale());
				if (fieldLabel.startsWith("$")) {
					String fieldLabelTemp = ResourceBundleUtils
							.getLocalizedMessage(fieldLabel.substring(1),
									context.getViewRoot().getLocale());
					fieldLabel = fieldLabelTemp != null ? fieldLabelTemp
							: fieldLabel;
				}

				context.addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR,
								MessageFormat.format(beanValidatorMessage,
										message, fieldLabel), null));
			}

		} else if (throwable instanceof MySQLIntegrityConstraintViolationException) {

			MySQLIntegrityConstraintViolationException m = (MySQLIntegrityConstraintViolationException) throwable;

			if (m.getErrorCode() == 1062) {
				Map<String, String> tokens = this.retrieveTokens(throwable
						.getMessage());

				context.addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR,
								"O valor " + tokens.get("value")
										+ " não pode ser duplicado.", null));
			}
			else if (m.getErrorCode() == 1451) {
				context.addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR,
								"Não é possível a remoção em virtude de dependência.", null));
			}

		} else if (throwable instanceof RuntimeException) {
			context.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_FATAL, "Erro desconhecido", null));

		}

	}

	private Map<String, String> retrieveTokens(String message) {

		StringTokenizer st = new StringTokenizer(message);
		Map<String, String> tokens = new HashMap<String, String>();

		while (st.hasMoreTokens()) {
			String tk = st.nextToken();

			if (tk.startsWith("\'") && tk.endsWith("\'")) {
				tk = tk.replace('\'', ' ').trim();
			} else
				continue;

			if (!tokens.containsKey("value")) {
				tokens.put("value", tk);
			} else {
				tokens.put("field", tk);
			}

		}

		return tokens;

	}
}
