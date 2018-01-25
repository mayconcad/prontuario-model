package br.com.saude.prontuario.model.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;

@Entity
public class AtividadeContabil extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5494339909215558770L;

	private String codigo;

	private String descricao;

	private String codOrgao;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private ContaContabil contaContabil;

	public AtividadeContabil() {
	}

	/**
	 * @param codigo
	 * @param descricao
	 */
	public AtividadeContabil(long id, String codigo, String descricao,
			String codOrgao) {
		super();
		super.setId(id);
		this.codigo = codigo;
		this.descricao = descricao;
		this.codOrgao = codOrgao;
	}

	/**
	 * @param codigo
	 * @param descricao
	 * @param contaContabil
	 */
	public AtividadeContabil(String codigo, String descricao,
			ContaContabil contaContabil) {
		super();
		this.codigo = codigo;
		this.descricao = descricao;
		this.contaContabil = contaContabil;
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

	public ContaContabil getContaContabil() {
		return contaContabil;
	}

	public void setContaContabil(ContaContabil contaContabil) {
		this.contaContabil = contaContabil;
	}

	public String getCodOrgao() {
		return codOrgao;
	}

	public void setCodOrgao(String codOrgao) {
		this.codOrgao = codOrgao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result
				+ ((contaContabil == null) ? 0 : contaContabil.hashCode());
		result = prime * result
				+ ((descricao == null) ? 0 : descricao.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AtividadeContabil other = (AtividadeContabil) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (contaContabil == null) {
			if (other.contaContabil != null)
				return false;
		} else if (!contaContabil.equals(other.contaContabil))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		return true;
	}

}
