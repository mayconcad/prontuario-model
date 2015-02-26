package br.com.sts.ddum.model.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;

import br.com.sts.ddum.model.enums.TipoContaEnum;
import br.com.sts.ddum.model.springsecurity.entities.User;

@Entity
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "matriculaFuncional" }) })
public class Responsavel extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8037811071046921890L;

	private long idExterno;

	@NotBlank
	@Size(max = 50)
	private String nome;

	@NotBlank
	@Size(max = 50)
	private String matriculaFuncional;

	@NotBlank
	@CPF
	private String cpf;

	@NotBlank
	private String rg;

	private String orgaoExpedidor;

	private String dataExpedicao;

	private long idCargo;

	@NotBlank
	private String cargo;

	private String endereco;

	private String cidade;

	private String bairro;

	private String uf;

	private String telefone;

	@Temporal(value = TemporalType.TIMESTAMP)
	@NotNull
	private Date dataInicial;

	@Temporal(value = TemporalType.TIMESTAMP)
	private Date dataFinal;

	@NotBlank
	private String codigoBanco;

	@NotBlank
	private String numeroConta;

	private TipoContaEnum tipoConta;

	@NotBlank
	private String digitoConta;

	@NotBlank
	private String numeroAgencia;

	@NotBlank
	private String digitoAgencia;

	@OneToOne
	private User user;

	public Responsavel() {
	}

	/**
	 * @param nome
	 * @param matriculaFuncional
	 * @param cpf
	 * @param codigoBanco
	 * @param numeroConta
	 * @param tipoConta
	 * @param digitoConta
	 * @param digitoAgencia
	 */
	public Responsavel(long id, String matriculaFuncional, String cpf,
			String nome, String codigoBanco, String numeroConta,
			String tipoConta, String digitoConta, String digitoAgencia) {
		super();
		super.setId(id);
		this.nome = nome;
		this.matriculaFuncional = matriculaFuncional;
		this.cpf = cpf;
		this.codigoBanco = codigoBanco;
		this.numeroConta = numeroConta;
		this.digitoConta = digitoConta;
		this.digitoAgencia = digitoAgencia;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCodigoBanco() {
		return codigoBanco;
	}

	public void setCodigoBanco(String codigoBanco) {
		this.codigoBanco = codigoBanco;
	}

	public String getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(String numeroConta) {
		this.numeroConta = numeroConta;
	}

	public TipoContaEnum getTipoConta() {
		return tipoConta;
	}

	public void setTipoConta(TipoContaEnum tipoConta) {
		this.tipoConta = tipoConta;
	}

	public String getDigitoConta() {
		return digitoConta;
	}

	public void setDigitoConta(String digitoConta) {
		this.digitoConta = digitoConta;
	}

	public String getDigitoAgencia() {
		return digitoAgencia;
	}

	public void setDigitoAgencia(String digitoAgencia) {
		this.digitoAgencia = digitoAgencia;
	}

	public String getMatriculaFuncional() {
		return matriculaFuncional;
	}

	public void setMatriculaFuncional(String matriculaFuncional) {
		this.matriculaFuncional = matriculaFuncional;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public long getIdExterno() {
		return idExterno;
	}

	public void setIdExterno(long idExterno) {
		this.idExterno = idExterno;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getOrgaoExpedidor() {
		return orgaoExpedidor;
	}

	public String getDataExpedicao() {
		return dataExpedicao;
	}

	public void setDataExpedicao(String dataExpedicao) {
		this.dataExpedicao = dataExpedicao;
	}

	public void setOrgaoExpedidor(String orgaoExpedidor) {
		this.orgaoExpedidor = orgaoExpedidor;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Date getDataInicial() {
		return dataInicial;
	}

	public void setDataInicial(Date dataInicial) {
		this.dataInicial = dataInicial;
	}

	public Date getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(Date dataFinal) {
		this.dataFinal = dataFinal;
	}

	public long getIdCargo() {
		return idCargo;
	}

	public void setIdCargo(long idCargo) {
		this.idCargo = idCargo;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getNumeroAgencia() {
		return numeroAgencia;
	}

	public void setNumeroAgencia(String numeroAgencia) {
		this.numeroAgencia = numeroAgencia;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((codigoBanco == null) ? 0 : codigoBanco.hashCode());
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result
				+ ((digitoAgencia == null) ? 0 : digitoAgencia.hashCode());
		result = prime * result
				+ ((digitoConta == null) ? 0 : digitoConta.hashCode());
		result = prime
				* result
				+ ((matriculaFuncional == null) ? 0 : matriculaFuncional
						.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result
				+ ((numeroConta == null) ? 0 : numeroConta.hashCode());
		result = prime * result
				+ ((tipoConta == null) ? 0 : tipoConta.hashCode());
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
		Responsavel other = (Responsavel) obj;
		if (codigoBanco == null) {
			if (other.codigoBanco != null)
				return false;
		} else if (!codigoBanco.equals(other.codigoBanco))
			return false;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (digitoAgencia == null) {
			if (other.digitoAgencia != null)
				return false;
		} else if (!digitoAgencia.equals(other.digitoAgencia))
			return false;
		if (digitoConta == null) {
			if (other.digitoConta != null)
				return false;
		} else if (!digitoConta.equals(other.digitoConta))
			return false;
		if (matriculaFuncional == null) {
			if (other.matriculaFuncional != null)
				return false;
		} else if (!matriculaFuncional.equals(other.matriculaFuncional))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (numeroConta == null) {
			if (other.numeroConta != null)
				return false;
		} else if (!numeroConta.equals(other.numeroConta))
			return false;
		if (tipoConta == null) {
			if (other.tipoConta != null)
				return false;
		} else if (!tipoConta.equals(other.tipoConta))
			return false;
		return true;
	}

}
