package br.com.saude.prontuario.model.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;

@Entity
public class UnidadeContabil extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8072062446789940420L;

	private String codigo;

	private String nome;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private AtividadeContabil atividade;

	public UnidadeContabil() {
	}

	/**
	 * @param codigo
	 * @param nome
	 */
	public UnidadeContabil(long id, String codigo, String nome) {
		super();
		super.setId(id);
		this.codigo = codigo;
		this.nome = nome;
	}

	/**
	 * @param codigo
	 * @param nome
	 * @param atividade
	 */
	public UnidadeContabil(String codigo, String nome,
			AtividadeContabil atividade) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.atividade = atividade;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public AtividadeContabil getAtividade() {
		return atividade;
	}

	public void setAtividade(AtividadeContabil atividade) {
		this.atividade = atividade;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((atividade == null) ? 0 : atividade.hashCode());
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		UnidadeContabil other = (UnidadeContabil) obj;
		if (atividade == null) {
			if (other.atividade != null)
				return false;
		} else if (!atividade.equals(other.atividade))
			return false;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

}
