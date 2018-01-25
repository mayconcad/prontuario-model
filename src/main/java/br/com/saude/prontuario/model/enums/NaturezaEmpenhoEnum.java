package br.com.saude.prontuario.model.enums;

public enum NaturezaEmpenhoEnum {

	EMPENHO_SUPRIMENTO_FUNDO("Empenho de Suprimento de Fundo", 1);

	private final String descricao;
	private final int numero;

	private NaturezaEmpenhoEnum(String descricao, int numero) {
		this.numero = numero;
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public int getNumero() {
		return numero;
	}

}
