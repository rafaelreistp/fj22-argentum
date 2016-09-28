package br.com.caelum.argentum.modelo;

import java.util.Calendar;

public final class Negociacao {
	private final double preco;
	private final int quantidade;
	private final Calendar data;
	
	public Negociacao(double preco, int quantidade, Calendar data) {
		this.preco = preco;
		this.quantidade = quantidade;
		if(data == null){
			throw new IllegalArgumentException("Data não pode ser nula!");
		}
		this.data = data;
	}

	public double getPreco() {
		return preco;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public Calendar getData() {
		return (Calendar) data.clone();
	}
	
	public double getVolume(){
		return (preco * quantidade);
	}

	public boolean isMesmoDia(Calendar c) {
		return (this.data.get(Calendar.DAY_OF_MONTH) == c.get(Calendar.DAY_OF_MONTH) &&
				this.data.get(Calendar.MONTH) == c.get(Calendar.MONTH) && this.data.get(Calendar.YEAR)
				== c.get(Calendar.YEAR));
	}


}
