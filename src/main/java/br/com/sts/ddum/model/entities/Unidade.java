package br.com.sts.ddum.model.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import br.com.sts.ddum.model.enums.ZonaLocalizacaoEnum;

@Entity
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "nome" }) })
public class Unidade extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7895475832482426476L;

	@NotBlank
	private String nome;

	private String logradouro;

	private String numeroLogradouro;

	private String bairro;

	private String cep;

	private String telefone;

	private ZonaLocalizacaoEnum zonaLocalizacao;

	@NotNull
	@ManyToOne(fetch = FetchType.EAGER)
	private Responsavel responsavel;

	@NotNull
	@ManyToOne(fetch = FetchType.EAGER)
	private ParametroRepasse parametroRepasse;

	@NotNull
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private UnidadeContabil unidadeContabil;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumeroLogradouro() {
		return numeroLogradouro;
	}

	public void setNumeroLogradouro(String numeroLogradouro) {
		this.numeroLogradouro = numeroLogradouro;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Responsavel getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(Responsavel responsavel) {
		this.responsavel = responsavel;
	}

	public UnidadeContabil getUnidadeContabil() {
		return unidadeContabil;
	}

	public void setUnidadeContabil(UnidadeContabil unidadeContabil) {
		this.unidadeContabil = unidadeContabil;
	}

	public ParametroRepasse getParametroRepasse() {
		return parametroRepasse;
	}

	public void setParametroRepasse(ParametroRepasse parametroRepasse) {
		this.parametroRepasse = parametroRepasse;
	}

	public ZonaLocalizacaoEnum getZonaLocalizacao() {
		return zonaLocalizacao;
	}

	public void setZonaLocalizacao(ZonaLocalizacaoEnum zonaLocalizacao) {
		this.zonaLocalizacao = zonaLocalizacao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime
				* result
				+ ((parametroRepasse == null) ? 0 : parametroRepasse.hashCode());
		result = prime * result
				+ ((responsavel == null) ? 0 : responsavel.hashCode());
		result = prime * result
				+ ((unidadeContabil == null) ? 0 : unidadeContabil.hashCode());
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
		Unidade other = (Unidade) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (parametroRepasse == null) {
			if (other.parametroRepasse != null)
				return false;
		} else if (!parametroRepasse.equals(other.parametroRepasse))
			return false;
		if (responsavel == null) {
			if (other.responsavel != null)
				return false;
		} else if (!responsavel.equals(other.responsavel))
			return false;
		if (unidadeContabil == null) {
			if (other.unidadeContabil != null)
				return false;
		} else if (!unidadeContabil.equals(other.unidadeContabil))
			return false;
		return true;
	}

}
