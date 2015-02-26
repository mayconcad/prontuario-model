package br.com.sts.ddum.model.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;

@Entity
public class ContaContabil extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5067972760356337639L;

	private String codigo;

	private String descricao;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private FonteRecurso fonteRecurso;

	public ContaContabil() {
	}

	/**
	 * @param codigo
	 * @param descricao
	 */
	public ContaContabil(long id, String codigo, String descricao) {
		super();
		super.setId(id);
		this.codigo = codigo;
		this.descricao = descricao;
	}

	/**
	 * @param codigo
	 * @param descricao
	 * @param fonteRecurso
	 */
	public ContaContabil(String codigo, String descricao,
			FonteRecurso fonteRecurso) {
		super();
		this.codigo = codigo;
		this.descricao = descricao;
		this.fonteRecurso = fonteRecurso;
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

	public FonteRecurso getFonteRecurso() {
		return fonteRecurso;
	}

	public void setFonteRecurso(FonteRecurso fonteRecurso) {
		this.fonteRecurso = fonteRecurso;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result
				+ ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result
				+ ((fonteRecurso == null) ? 0 : fonteRecurso.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContaContabil other = (ContaContabil) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (fonteRecurso == null) {
			if (other.fonteRecurso != null)
				return false;
		} else if (!fonteRecurso.equals(other.fonteRecurso))
			return false;
		return true;
	}

}
