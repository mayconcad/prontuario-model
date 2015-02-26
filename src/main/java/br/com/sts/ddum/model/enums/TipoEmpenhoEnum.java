package br.com.sts.ddum.model.enums;

public enum TipoEmpenhoEnum {

	GLOBAL("Global", 3);

	private final String descricao;

	private final int numero;

	private TipoEmpenhoEnum(String descricao, int numero) {
		this.descricao = descricao;
		this.numero = numero;
	}

	public String getDescricao() {
		return descricao;
	}

	public int getNumero() {
		return numero;
	}
}
