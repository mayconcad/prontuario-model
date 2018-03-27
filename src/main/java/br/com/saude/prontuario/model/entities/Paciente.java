package br.com.saude.prontuario.model.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Paciente extends BaseEntity{

	private static final long serialVersionUID = 1391639766027518830L;	
	
	private String nome;

	private String cpf;

	private String rg;

	private String endereco;	

	private String fone;
	
	private String cidade;

	private String bairro;

	private String uf;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataNascimento;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCadastro;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataUltimaAtualizacao;

	
	//@OneToMany(cascade=CascadeType.REMOVE, fetch = FetchType.EAGER , mappedBy="paciente")
    /*@JoinTable(name="atendimento_paciente",  
              joinColumns={@JoinColumn(name="paciente_id", 
               referencedColumnName="id")},  
              inverseJoinColumns={@JoinColumn(name="atendimento_id", 
                referencedColumnName="id")}) */
	//private List<Atendimento> atendimentos;
	

	public String getNome() {
		return nome;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getFone() {
		return fone;
	}

	public void setFone(String fone) {
		this.fone = fone;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Date getDataUltimaAtualizacao() {
		return dataUltimaAtualizacao;
	}

	public void setDataUltimaAtualizacao(Date dataUltimaAtualizacao) {
		this.dataUltimaAtualizacao = dataUltimaAtualizacao;
	}

}
