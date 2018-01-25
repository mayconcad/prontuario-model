package br.com.saude.prontuario.model.vos;

import java.math.BigDecimal;

public class ReservaDotacaoVO {

	private BigDecimal valor;

	private long numReserva;

	private int statusReserva;

	public ReservaDotacaoVO() {
	}

	/**
	 * @param valor
	 * @param numReserva
	 * @param statusReserva
	 */
	public ReservaDotacaoVO(long numReserva, BigDecimal valor, int statusReserva) {
		super();
		this.valor = valor;
		this.numReserva = numReserva;
		this.statusReserva = statusReserva;
	}

	public long getNumReserva() {
		return numReserva;
	}

	public void setNumReserva(long numReserva) {
		this.numReserva = numReserva;
	}

	public int getStatusReserva() {
		return statusReserva;
	}

	public void setStatusReserva(int statusReserva) {
		this.statusReserva = statusReserva;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
}
