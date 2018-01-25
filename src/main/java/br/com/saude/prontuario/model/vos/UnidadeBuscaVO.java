package br.com.saude.prontuario.model.vos;

import java.math.BigDecimal;

import br.com.saude.prontuario.model.entities.Responsavel;

public class UnidadeBuscaVO extends BaseVO {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4940207879747422984L;

	private Long id;

	private String nome;

	private String logradouro;

	private String numeroLogradouro;

	private String bairro;

	private String cep;

	private String telefone;

	private Responsavel responsavel;

	private BigDecimal valorRepasse;

	private int quantAluno;

	private String zonaLocalizacao;

	public UnidadeBuscaVO() {
	}

	/**
	 * @param id
	 * @param nome
	 * @param logradouro
	 * @param numeroLogradouro
	 * @param bairro
	 * @param cep
	 * @param telefone
	 * @param responsavel
	 * @param segmento
	 * @param valorRepasse
	 * @param quantAluno
	 * @param zonaLocalizacao
	 */
	public UnidadeBuscaVO(Long id, String nome, String logradouro,
			String numeroLogradouro, String bairro, String cep,
			String telefone, Responsavel responsavel, BigDecimal valorRepasse,
			int quantAluno, String zonaLocalizacao) {
		super();
		this.id = id;
		this.nome = nome;
		this.logradouro = logradouro;
		this.numeroLogradouro = numeroLogradouro;
		this.bairro = bairro;
		this.cep = cep;
		this.telefone = telefone;
		this.responsavel = responsavel;
		this.valorRepasse = valorRepasse;
		this.quantAluno = quantAluno;
		this.zonaLocalizacao = zonaLocalizacao;
	}

	public UnidadeBuscaVO(Long id, String nome, String logradouro,
			String numeroLogradouro, String bairro, String cep,
			String telefone, Responsavel responsavel, BigDecimal valorRepasse) {
		super();
		this.id = id;
		this.nome = nome;
		this.logradouro = logradouro;
		this.numeroLogradouro = numeroLogradouro;
		this.bairro = bairro;
		this.cep = cep;
		this.telefone = telefone;
		this.responsavel = responsavel;
		this.valorRepasse = valorRepasse;
	}

	public UnidadeBuscaVO(Long id, String nome, String logradouro,
			String numeroLogradouro, String bairro, String cep,
			String telefone, Responsavel responsavel) {
		super();
		this.id = id;
		this.nome = nome;
		this.logradouro = logradouro;
		this.numeroLogradouro = numeroLogradouro;
		this.bairro = bairro;
		this.cep = cep;
		this.telefone = telefone;
		this.responsavel = responsavel;
	}

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

	public BigDecimal getValorRepasse() {
		return valorRepasse;
	}

	public void setValorRepasse(BigDecimal valorRepasse) {
		this.valorRepasse = valorRepasse;
	}

	public int getQuantAluno() {
		return quantAluno;
	}

	public void setQuantAluno(int quantAluno) {
		this.quantAluno = quantAluno;
	}

	public String getZonaLocalizacao() {
		return zonaLocalizacao;
	}

	public void setZonaLocalizacao(String zonaLocalizacao) {
		this.zonaLocalizacao = zonaLocalizacao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
