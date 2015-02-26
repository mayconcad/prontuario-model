package br.com.sts.ddum.model.entities;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
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

	// @OneToOne(optional = true, fetch = FetchType.LAZY)
	// private Repasse repasse;

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

	// public Repasse getRepasse() {
	// return repasse;
	// }
	//
	// public void setRepasse(Repasse repasse) {
	// this.repasse = repasse;
	// }

}
