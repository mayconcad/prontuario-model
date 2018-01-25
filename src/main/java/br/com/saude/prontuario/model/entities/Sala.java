package br.com.saude.prontuario.model.entities;

import javax.persistence.Entity;

@Entity
public class Sala extends BaseEntity {	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8576994517056416998L;
	private String descricao;
	

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
