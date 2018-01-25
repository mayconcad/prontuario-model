package br.com.saude.prontuario.model.entities;

public enum SegmentoEnum {

	PMDDSO("Assis.Social"), PMDDUS("Saúde"), PMDDSR("Superintendência"), PMDDE(
			"Educação");

	private String descricao;

	private SegmentoEnum(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return descricao;
	}
}
