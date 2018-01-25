package br.com.saude.prontuario.model.entities;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
public class PrestacaoConta extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8061683064776232026L;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataPrestacao;

	@NotNull
	private BigDecimal saldoDisponivel;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Documento> documentos;

	@NotNull
	@OneToOne(optional = true, fetch = FetchType.LAZY)
	private Repasse repasse;

	public Date getDataPrestacao() {
		return dataPrestacao;
	}

	public void setDataPrestacao(Date dataPrestacao) {
		this.dataPrestacao = dataPrestacao;
	}

	public BigDecimal getSaldoDisponivel() {
		return saldoDisponivel;
	}

	public void setSaldoDisponivel(BigDecimal saldoDisponivel) {
		this.saldoDisponivel = saldoDisponivel;
	}

	public List<Documento> getDocumentos() {
		return documentos;
	}

	public void setDocumentos(List<Documento> documentos) {
		this.documentos = documentos;
	}

	public Repasse getRepasse() {
		return repasse;
	}

	public void setRepasse(Repasse repasse) {
		this.repasse = repasse;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((dataPrestacao == null) ? 0 : dataPrestacao.hashCode());
		result = prime * result + ((repasse == null) ? 0 : repasse.hashCode());
		result = prime * result
				+ ((saldoDisponivel == null) ? 0 : saldoDisponivel.hashCode());
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
		PrestacaoConta other = (PrestacaoConta) obj;
		if (dataPrestacao == null) {
			if (other.dataPrestacao != null)
				return false;
		} else if (!dataPrestacao.equals(other.dataPrestacao))
			return false;
		if (repasse == null) {
			if (other.repasse != null)
				return false;
		} else if (!repasse.equals(other.repasse))
			return false;
		if (saldoDisponivel == null) {
			if (other.saldoDisponivel != null)
				return false;
		} else if (!saldoDisponivel.equals(other.saldoDisponivel))
			return false;
		return true;
	}
}
