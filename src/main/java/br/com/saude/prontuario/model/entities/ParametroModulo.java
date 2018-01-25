package br.com.saude.prontuario.model.entities;

import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.validator.constraints.NotBlank;

//@Entity
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "descricao",
		"ativo", "exercicio" }) })
public class ParametroModulo extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3432617817716497877L;

	@NotBlank
	private String descricao;

	private int exercicio;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getExercicio() {
		return exercicio;
	}

	public void setExercicio(int exercicio) {
		this.exercicio = exercicio;
	}

}
