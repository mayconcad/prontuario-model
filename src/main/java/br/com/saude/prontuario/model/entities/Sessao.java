package br.com.saude.prontuario.model.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
public class Sessao extends BaseEntity{
		
	/**
	 * 
	 */
	private static final long serialVersionUID = -4414020162158191004L;

	@OneToOne    
	private Sala sala;	
	
//	@Temporal( TemporalType.TIMESTAMP )
//	@NotNull
//	private Date dataInicio;
	
//	@Temporal( TemporalType.TIMESTAMP )
//	@NotNull
//	private Date dataFinal;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCadastro;
	
   @Column
	//Qantidade desta sessão por atendimento
   private int quantidade;
	
	@Column
	private String descricao;
	
	@Column
	private String observacao;


	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}	

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}	

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}	

}
