package br.com.saude.prontuario.model.enums;

public enum TipoCreditoEnum {

	ORCAMENTARIO("Orçamentário", 0);

	private final String descricao;
	private final int numero;

	private TipoCreditoEnum(String descricao, int numero) {
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
