package br.com.sts.ddum.model.vos;

import java.math.BigDecimal;

import br.com.sts.ddum.model.entities.ParametroRepasse;
import br.com.sts.ddum.model.entities.SegmentoEnum;

public class ParametroRepasseBuscaVO extends BaseVO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7613038470667328638L;

	private Long id;

	private String descricao;

	private BigDecimal valorRepasse;

	private SegmentoEnum segmento;

	public ParametroRepasseBuscaVO(ParametroRepasse parametroRepasse) {
		this.id = parametroRepasse.getId();
		this.segmento = parametroRepasse.getSegmento();
		this.descricao = parametroRepasse.getDescricao();
		this.valorRepasse = parametroRepasse.getValorRepasse();
	}

	public ParametroRepasseBuscaVO() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return descricao;
	}

	public void setNome(String nome) {
		this.descricao = nome;
	}

	public BigDecimal getValorRepasse() {
		return valorRepasse;
	}

	public void setValorRepasse(BigDecimal valorRepasse) {
		this.valorRepasse = valorRepasse;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public SegmentoEnum getSegmento() {
		return segmento;
	}

	public void setSegmento(SegmentoEnum segmento) {
		this.segmento = segmento;
	}
}
