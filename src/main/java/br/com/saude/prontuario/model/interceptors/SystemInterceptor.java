package br.com.saude.prontuario.model.interceptors;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;

import br.com.saude.prontuario.model.utils.TakeEM;
import br.com.saude.prontuario.model.validations.Validation;
import br.com.saude.prontuario.model.validations.ValidationType;

public class SystemInterceptor extends EmptyInterceptor {

	private static final long serialVersionUID = 4756368525765636969L;

	@Override
	public boolean onSave(Object entity, Serializable id, Object[] state,
			String[] propertyNames, Type[] types) {

		this.validate(entity, ValidationType.CREATE);

		return false;

	}

	@Override
	public boolean onFlushDirty(Object entity, Serializable id,
			Object[] currentState, Object[] previousState,
			String[] propertyNames, Type[] types) {

		this.validate(entity, ValidationType.UPDATE);

		return false;

	}

	@Override
	public void onDelete(Object entity, Serializable id, Object[] state,
			String[] propertyNames, Type[] types) {

		this.validate(entity, ValidationType.DELETE);

	}

	private void validate(Object entity, ValidationType validationType) {

		Method[] methods = entity.getClass().getMethods();

		try {

			for (Method method : methods) {

				Validation validate = method.getAnnotation(Validation.class);

				if (validate != null && hasValue(validate, validationType)) {

					method.invoke(entity, entity, TakeEM.retrieveEM());

				}

			}

		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		} catch (IllegalArgumentException e) {
			throw new RuntimeException(e);
		} catch (InvocationTargetException e) {
			throw new RuntimeException(e.getCause());
		}

	}

	private boolean hasValue(Validation validate, ValidationType value) {

		ValidationType[] values = validate.values();

		for (ValidationType validationType : values) {

			if (validationType == value)
				return true;

		}

		return false;

	}

}