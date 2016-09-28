package br.com.caelum.argentum.modelo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class CandlestickFactory {


	public Candlestick constroiCandlestick(List<Negociacao> lista, Calendar dia){
		double min = lista.isEmpty() ? 0 : Double.MAX_VALUE;
		double max = 0;
		double volume = 0;
		
		for(Negociacao n: lista){
			if(n.getPreco() < min){
				min = n.getPreco();
			}
			if(n.getPreco() > max){
				max = n.getPreco();
			}
			volume += n.getVolume();
		}
		
		double abertura = lista.isEmpty() ? 0 : lista.get(0).getPreco();
		double fechamento = lista.isEmpty() ? 0 : lista.get(lista.size()-1).getPreco();
		
		return new Candlestick(abertura, fechamento, min, max, volume, dia);
		
	}

	public List<Candlestick> constroiCandles(List<Negociacao> ls) {
		
		List<Negociacao> listaDoDia = new ArrayList<Negociacao>();
		List<Candlestick> candles = new ArrayList<Candlestick>();
		Calendar dia = ls.get(0).getData();
		
		for(Negociacao n: ls){
			if(n.isMesmoDia(dia)){
				listaDoDia.add(n);
			}
			else{
				Candlestick c = constroiCandlestick(listaDoDia, dia);
				candles.add(c);
				listaDoDia.clear();
				listaDoDia.add(n);
				dia = n.getData();
			}
		}
		Candlestick c = constroiCandlestick(listaDoDia, dia);
		candles.add(c);
		return candles;
		
	}

}
