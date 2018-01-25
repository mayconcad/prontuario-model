package br.com.saude.prontuario.model.springsecurity.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.saude.prontuario.model.entities.BaseEntity;

@Entity
public class Role extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 5886820991361556707L;

	@NotNull
	@Size(min = 3, max = 60)
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
