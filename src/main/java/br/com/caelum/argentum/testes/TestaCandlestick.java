package br.com.caelum.argentum.testes;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import br.com.caelum.argentum.modelo.Candlestick;
import br.com.caelum.argentum.modelo.CandlestickFactory;
import br.com.caelum.argentum.modelo.Negociacao;

public class TestaCandlestick {
	public static void main(String[] args) {
		Calendar hoje = Calendar.getInstance();
		Negociacao n1 = new Negociacao(100, 3, hoje);
		Negociacao n2 = new Negociacao(35.6, 3, hoje);
		Negociacao n3 = new Negociacao(45.8, 1, hoje);
		Negociacao n4 = new Negociacao(66.7, 6, hoje);
		
		List<Negociacao> negociacoes = Arrays.asList(n1,n2,n3,n4);
		CandlestickFactory fabrica = new CandlestickFactory();
		Candlestick candle1 = fabrica.constroiCandlestick(negociacoes, hoje);
		
		List<Negociacao> negociacoes2 = Arrays.asList(n1);
		Candlestick candle2 = fabrica.constroiCandlestick(negociacoes2, hoje);
		
		List<Negociacao> negociacoes3 = Arrays.asList();
		Candlestick candle3 = fabrica.constroiCandlestick(negociacoes3, hoje);
		
		System.out.println(candle1.toString());
		System.out.println(candle2.toString());
		System.out.println(candle3.toString());

	}

}
