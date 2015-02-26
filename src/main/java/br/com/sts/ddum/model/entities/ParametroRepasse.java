package br.com.sts.ddum.model.entities;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "descricao",
		"ativo", "exercicio" }) })
public class ParametroRepasse extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8924832799990095361L;

	private long codDotacao;

	@NotBlank
	private String descricao;

	@NotNull
	private BigDecimal valorRepasse;

	@NotNull
	private SegmentoEnum segmento;

	@NotBlank
	private String codUnidade;

	@NotBlank
	private String codAtividade;

	@NotBlank
	private String codElementoDespesa;

	@NotBlank
	private String codFonteRecurso;

	private int exercicio;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getValorRepasse() {
		return valorRepasse;
	}

	public void setValorRepasse(BigDecimal valorRepasse) {
		this.valorRepasse = valorRepasse;
	}

	public SegmentoEnum getSegmento() {
		return segmento;
	}

	public void setSegmento(SegmentoEnum segmento) {
		this.segmento = segmento;
	}

	public String getCodUnidade() {
		return codUnidade;
	}

	public void setCodUnidade(String codUnidade) {
		this.codUnidade = codUnidade;
	}

	public String getCodAtividade() {
		return codAtividade;
	}

	public void setCodAtividade(String codAtividade) {
		this.codAtividade = codAtividade;
	}

	public String getCodElementoDespesa() {
		return codElementoDespesa;
	}

	public void setCodElementoDespesa(String codElementoDespesa) {
		this.codElementoDespesa = codElementoDespesa;
	}

	public String getCodFonteRecurso() {
		return codFonteRecurso;
	}

	public void setCodFonteRecurso(String codFonteRecurso) {
		this.codFonteRecurso = codFonteRecurso;
	}

	public int getExercicio() {
		return exercicio;
	}

	public void setExercicio(int exercicio) {
		this.exercicio = exercicio;
	}

	public long getCodDotacao() {
		return codDotacao;
	}

	public void setCodDotacao(long codDotacao) {
		this.codDotacao = codDotacao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((codAtividade == null) ? 0 : codAtividade.hashCode());
		result = prime * result + (int) (codDotacao ^ (codDotacao >>> 32));
		result = prime
				* result
				+ ((codElementoDespesa == null) ? 0 : codElementoDespesa
						.hashCode());
		result = prime * result
				+ ((codFonteRecurso == null) ? 0 : codFonteRecurso.hashCode());
		result = prime * result
				+ ((codUnidade == null) ? 0 : codUnidade.hashCode());
		result = prime * result
				+ ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + exercicio;
		result = prime * result
				+ ((segmento == null) ? 0 : segmento.hashCode());
		result = prime * result
				+ ((valorRepasse == null) ? 0 : valorRepasse.hashCode());
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
		ParametroRepasse other = (ParametroRepasse) obj;
		if (codAtividade == null) {
			if (other.codAtividade != null)
				return false;
		} else if (!codAtividade.equals(other.codAtividade))
			return false;
		if (codDotacao != other.codDotacao)
			return false;
		if (codElementoDespesa == null) {
			if (other.codElementoDespesa != null)
				return false;
		} else if (!codElementoDespesa.equals(other.codElementoDespesa))
			return false;
		if (codFonteRecurso == null) {
			if (other.codFonteRecurso != null)
				return false;
		} else if (!codFonteRecurso.equals(other.codFonteRecurso))
			return false;
		if (codUnidade == null) {
			if (other.codUnidade != null)
				return false;
		} else if (!codUnidade.equals(other.codUnidade))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (exercicio != other.exercicio)
			return false;
		if (segmento != other.segmento)
			return false;
		if (valorRepasse == null) {
			if (other.valorRepasse != null)
				return false;
		} else if (!valorRepasse.equals(other.valorRepasse))
			return false;
		return true;
	}

}
