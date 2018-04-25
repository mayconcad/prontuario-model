package br.com.saude.prontuario.model.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Atendimento extends BaseEntity {

	private static final long serialVersionUID = 3940210640720766782L;

	@ManyToOne
	private Paciente paciente;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Sessao> sessoes;

	@OneToOne
	private TipoAtendimento tipoAtendimento;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataAtendimento;

	@Column
	private String descricao;

	@Column
	private String observacao;

	// total de atendimentos
	@Column
	private int total;

	@Temporal(TemporalType.TIMESTAMP)
	@NotNull
	private Date dataInicio;

	@Temporal(TemporalType.TIMESTAMP)
	@NotNull
	private Date dataFinal;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCadastro;

	@Column
	// Qantidade desta sessão por atendimento
	private int quantidade;

	@Column
	private int quantidadesala1;

	@Column
	private int quantidadesala2;

	private String log;

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public TipoAtendimento getTipoAtendimento() {
		return tipoAtendimento;
	}

	public void setTipoAtendimento(TipoAtendimento tipoAtendimento) {
		this.tipoAtendimento = tipoAtendimento;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List<Sessao> getSessoes() {
		return sessoes;
	}

	public void setSessoes(List<Sessao> sessoes) {
		this.sessoes = sessoes;
	}

	public Date getDataAtendimento() {
		return dataAtendimento;
	}

	public void setDataAtendimento(Date dataAtendimento) {
		this.dataAtendimento = dataAtendimento;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(Date dataFinal) {
		this.dataFinal = dataFinal;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public int getQuantidadesala1() {
		return quantidadesala1;
	}

	public void setQuantidadesala1(int quantidadesala1) {
		this.quantidadesala1 = quantidadesala1;
	}

	public int getQuantidadesala2() {
		return quantidadesala2;
	}

	public void setQuantidadesala2(int quantidadesala2) {
		this.quantidadesala2 = quantidadesala2;
	}

	public String getLog() {
		return log;
	}

	public void setLog(String log) {
		this.log = log;
	}

}
