package br.com.saude.prontuario.model.entities;

import javax.persistence.Entity;

@Entity
public class TipoAtendimento extends BaseEntity{

	private static final long serialVersionUID = 3940210640720766782L;

	
	private String descricao;	

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	

}
