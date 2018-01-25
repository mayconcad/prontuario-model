package br.com.saude.prontuario.model.enums;

public enum TipoContaEnum {

	POUPANCA("Poupança"), CORRENTE("Corrente");

	private String descricao;

	private TipoContaEnum(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return descricao;
	}
}
