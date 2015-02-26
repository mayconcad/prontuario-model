package br.com.sts.ddum.model.enums;

public enum TipoMetaEnum {

	OUTRAS("Outras", 7);

	private final String descricao;
	private final int numero;

	private TipoMetaEnum(String descricao, int numero) {
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
