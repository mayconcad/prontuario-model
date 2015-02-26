package br.com.sts.ddum.model.entities;

import javax.persistence.Entity;

@Entity
public class FonteRecurso extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1140600012941916929L;

	private String codigo;

	private String descricao;

	public FonteRecurso() {
	}

	/**
	 * @param codigo
	 * @param descricao
	 */
	public FonteRecurso(long id, String codigo, String descricao) {
		super();
		super.setId(id);
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
