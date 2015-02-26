package br.com.sts.ddum.model.entities;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Documento extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8154950656554715409L;

	@Size(min = 1, max = 200)
	@NotBlank
	private String caminho;

	@NotBlank
	@Size(min = 1, max = 200)
	private String nomeOriginal;

	@NotBlank
	@Size(min = 1, max = 200)
	private String nome;

	@NotBlank
	@Size(min = 1, max = 50)
	private String contentType;

	@NotBlank
	@Size(min = 1, max = 50)
	private String tipo;

	@NotNull
	private BigDecimal valor;

	@NotBlank
	@Size(min = 1, max = 50)
	private String numero;

	@NotNull
	private long tamanho;

	@NotNull
	@Lob
	private byte[] arquivo;

	public String getCaminho() {
		return caminho;
	}

	public void setCaminho(String caminho) {
		this.caminho = caminho;
	}

	public String getNomeOriginal() {
		return nomeOriginal;
	}

	public void setNomeOriginal(String nomeOriginal) {
		this.nomeOriginal = nomeOriginal;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public long getTamanho() {
		return tamanho;
	}

	public void setTamanho(long tamanho) {
		this.tamanho = tamanho;
	}

	public byte[] getArquivo() {
		return arquivo;
	}

	public void setArquivo(byte[] arquivo) {
		this.arquivo = arquivo;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
}
