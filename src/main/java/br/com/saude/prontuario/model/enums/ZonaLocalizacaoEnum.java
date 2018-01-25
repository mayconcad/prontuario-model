package br.com.saude.prontuario.model.enums;

public enum ZonaLocalizacaoEnum {

	URBANA("Urbana"), RURAL("Rural");

	private String descricao;

	private ZonaLocalizacaoEnum(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return descricao;
	}

}
