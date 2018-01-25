package br.com.saude.prontuario.model.vos;

import br.com.saude.prontuario.model.entities.Responsavel;
import br.com.saude.prontuario.model.entities.UnidadeContabil;

public class TermoCompromissoReportVO extends BaseVO {

	private Responsavel responsavel;

	private UnidadeContabil unidadeContabil;

	public Responsavel getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(Responsavel responsavel) {
		this.responsavel = responsavel;
	}

	public UnidadeContabil getUnidadeContabil() {
		return unidadeContabil;
	}

	public void setUnidadeContabil(UnidadeContabil unidadeContabil) {
		this.unidadeContabil = unidadeContabil;
	}
}
