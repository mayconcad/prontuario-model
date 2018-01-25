package br.com.saude.prontuario.model.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import br.com.saude.prontuario.model.enums.NaturezaEmpenhoEnum;
import br.com.saude.prontuario.model.enums.TipoCreditoEnum;
import br.com.saude.prontuario.model.enums.TipoEmpenhoEnum;
import br.com.saude.prontuario.model.enums.TipoMetaEnum;

@Entity
public class Repasse extends BaseEntity {

	private static final long serialVersionUID = 3332286569398360373L;

	private long numeroEmpenho;

	private long numeroLiquidacao;

	private long numeroProcesso;

	private int exercicio;

	@NotBlank
	private String historico;

	@NotBlank
	private String codAplicacao;

	@Temporal(TemporalType.TIMESTAMP)
	@NotNull
	private Date dataEmissao;

	@NotNull
	private BigDecimal valorRepasse;

	@NotNull
	private BigDecimal valorEmpenho;

	@NotNull
	private TipoEmpenhoEnum tipoEmpenho;

	@NotNull
	private TipoCreditoEnum tipoCredito;

	@NotNull
	private TipoMetaEnum tipoMeta;

	@NotNull
	private NaturezaEmpenhoEnum naturezaEmpenho;

	@NotNull
	@ManyToOne(fetch = FetchType.EAGER)
	private Unidade unidade;

	public long getNumeroEmpenho() {
		return numeroEmpenho;
	}

	public void setNumeroEmpenho(long numeroEmpenho) {
		this.numeroEmpenho = numeroEmpenho;
	}

	public long getNumeroProcesso() {
		return numeroProcesso;
	}

	public void setNumeroProcesso(long numeroProcesso) {
		this.numeroProcesso = numeroProcesso;
	}

	public int getExercicio() {
		return exercicio;
	}

	public void setExercicio(int exercicio) {
		this.exercicio = exercicio;
	}

	public String getHistorico() {
		return historico;
	}

	public void setHistorico(String historico) {
		this.historico = historico;
	}

	public String getCodAplicacao() {
		return codAplicacao;
	}

	public void setCodAplicacao(String codAplicacao) {
		this.codAplicacao = codAplicacao;
	}

	public Date getDataEmissao() {
		return dataEmissao;
	}

	public void setDataEmissao(Date dataEmissao) {
		this.dataEmissao = dataEmissao;
	}

	public BigDecimal getValorEmpenho() {
		return valorEmpenho;
	}

	public void setValorEmpenho(BigDecimal valorEmpenho) {
		this.valorEmpenho = valorEmpenho;
	}

	public TipoEmpenhoEnum getTipoEmpenho() {
		return tipoEmpenho;
	}

	public void setTipoEmpenho(TipoEmpenhoEnum tipoEmpenho) {
		this.tipoEmpenho = tipoEmpenho;
	}

	public TipoCreditoEnum getTipoCredito() {
		return tipoCredito;
	}

	public void setTipoCredito(TipoCreditoEnum tipoCredito) {
		this.tipoCredito = tipoCredito;
	}

	public TipoMetaEnum getTipoMeta() {
		return tipoMeta;
	}

	public void setTipoMeta(TipoMetaEnum tipoMeta) {
		this.tipoMeta = tipoMeta;
	}

	public NaturezaEmpenhoEnum getNaturezaEmpenho() {
		return naturezaEmpenho;
	}

	public void setNaturezaEmpenho(NaturezaEmpenhoEnum naturezaEmpenho) {
		this.naturezaEmpenho = naturezaEmpenho;
	}

	public Unidade getUnidade() {
		return unidade;
	}

	public void setUnidade(Unidade unidade) {
		this.unidade = unidade;
	}

	public BigDecimal getValorRepasse() {
		return valorRepasse;
	}

	public void setValorRepasse(BigDecimal valorRepasse) {
		this.valorRepasse = valorRepasse;
	}

	public long getNumeroLiquidacao() {
		return numeroLiquidacao;
	}

	public void setNumeroLiquidacao(long numeroLiquidacao) {
		this.numeroLiquidacao = numeroLiquidacao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((codAplicacao == null) ? 0 : codAplicacao.hashCode());
		result = prime * result
				+ ((dataEmissao == null) ? 0 : dataEmissao.hashCode());
		result = prime * result + exercicio;
		result = prime * result
				+ ((naturezaEmpenho == null) ? 0 : naturezaEmpenho.hashCode());
		result = prime * result
				+ (int) (numeroEmpenho ^ (numeroEmpenho >>> 32));
		result = prime * result
				+ (int) (numeroLiquidacao ^ (numeroLiquidacao >>> 32));
		result = prime * result
				+ (int) (numeroProcesso ^ (numeroProcesso >>> 32));
		result = prime * result
				+ ((tipoCredito == null) ? 0 : tipoCredito.hashCode());
		result = prime * result
				+ ((tipoEmpenho == null) ? 0 : tipoEmpenho.hashCode());
		result = prime * result
				+ ((tipoMeta == null) ? 0 : tipoMeta.hashCode());
		result = prime * result + ((unidade == null) ? 0 : unidade.hashCode());
		result = prime * result
				+ ((valorEmpenho == null) ? 0 : valorEmpenho.hashCode());
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
		Repasse other = (Repasse) obj;
		if (codAplicacao == null) {
			if (other.codAplicacao != null)
				return false;
		} else if (!codAplicacao.equals(other.codAplicacao))
			return false;
		if (dataEmissao == null) {
			if (other.dataEmissao != null)
				return false;
		} else if (!dataEmissao.equals(other.dataEmissao))
			return false;
		if (exercicio != other.exercicio)
			return false;
		if (naturezaEmpenho != other.naturezaEmpenho)
			return false;
		if (numeroEmpenho != other.numeroEmpenho)
			return false;
		if (numeroLiquidacao != other.numeroLiquidacao)
			return false;
		if (numeroProcesso != other.numeroProcesso)
			return false;
		if (tipoCredito != other.tipoCredito)
			return false;
		if (tipoEmpenho != other.tipoEmpenho)
			return false;
		if (tipoMeta != other.tipoMeta)
			return false;
		if (unidade == null) {
			if (other.unidade != null)
				return false;
		} else if (!unidade.equals(other.unidade))
			return false;
		if (valorEmpenho == null) {
			if (other.valorEmpenho != null)
				return false;
		} else if (!valorEmpenho.equals(other.valorEmpenho))
			return false;
		if (valorRepasse == null) {
			if (other.valorRepasse != null)
				return false;
		} else if (!valorRepasse.equals(other.valorRepasse))
			return false;
		return true;
	}

}
