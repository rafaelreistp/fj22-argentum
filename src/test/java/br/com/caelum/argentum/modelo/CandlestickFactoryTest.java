package br.com.caelum.argentum.modelo;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

@SuppressWarnings("deprecation")
public class CandlestickFactoryTest {

	@Test
	public void sequenciaSimplesDeNegociacoes() {
		Calendar hoje = Calendar.getInstance();
		Negociacao n1 = new Negociacao(100, 3, hoje);
		Negociacao n2 = new Negociacao(35.6, 3, hoje);
		Negociacao n3 = new Negociacao(45.8, 1, hoje);
		Negociacao n4 = new Negociacao(66.7, 6, hoje);
		
		List<Negociacao> negociacoes = Arrays.asList(n1,n2,n3,n4);
		CandlestickFactory fabrica = new CandlestickFactory();
		Candlestick candle = fabrica.constroiCandlestick(negociacoes, hoje);
		
		Assert.assertEquals(100, candle.getAbertura(),0.00001);
		Assert.assertEquals(66.7, candle.getFechamento(), 0.00001);
		Assert.assertEquals(35.6, candle.getMinimo(), 0.00001);
		Assert.assertEquals(100, candle.getMaximo(), 0.00001);
		Assert.assertEquals(852.8, candle.getVolume(),0.0001);
		
	}
	
	@Test
	public void zeroNegociacoes(){
		Calendar hoje = Calendar.getInstance();
		List<Negociacao> negociacoes = Arrays.asList();
		CandlestickFactory fabrica = new CandlestickFactory();
		Candlestick candle = fabrica.constroiCandlestick(negociacoes, hoje);
		
		Assert.assertEquals(0, candle.getAbertura(), 0.00001);
		Assert.assertEquals(0, candle.getFechamento(), 0.00001);
		Assert.assertEquals(0, candle.getMaximo(), 0.00001);
		Assert.assertEquals(0, candle.getMinimo(), 0.00001);
		Assert.assertEquals(0, candle.getVolume(),0.00001);
	}
	
	@Test
	public void apenasUmaNegociacao(){
		Calendar hoje = Calendar.getInstance();
		Negociacao n1 = new Negociacao(40.5, 100, hoje);
		List<Negociacao> negociacoes = Arrays.asList(n1);
		CandlestickFactory fabrica = new CandlestickFactory();
		Candlestick candle = fabrica.constroiCandlestick(negociacoes, hoje);
		
		Assert.assertEquals(40.5, candle.getAbertura(),0.00001);
		Assert.assertEquals(40.5, candle.getFechamento(),0.00001);
		Assert.assertEquals(40.5, candle.getMaximo(),0.00001);
		Assert.assertEquals(40.5, candle.getMinimo(),0.00001);
		Assert.assertEquals(4050, candle.getVolume(),0.00001);
	}
	
	
	@Test
	public void negociacoesDeDiasDistintosGeraCandles(){
		Calendar hoje = Calendar.getInstance();
		Negociacao n1 = new Negociacao(40.5, 100, hoje);
		Negociacao n2 = new Negociacao(45, 100, hoje);
		Negociacao n3 = new Negociacao(39.8, 100, hoje);
		Negociacao n4 = new Negociacao(42.3, 100, hoje);
		
		Calendar amanha = (Calendar) hoje.clone();
		amanha.add(Calendar.DAY_OF_MONTH, 1);
		
		Negociacao n5 = new Negociacao(48.8, 100, amanha);
		Negociacao n6 = new Negociacao(49.3, 100, amanha);
		
		Calendar depois = (Calendar) hoje.clone();
		depois.add(Calendar.DAY_OF_MONTH,5);
		
		Negociacao n7 = new Negociacao(51.8, 100, depois);
		Negociacao n8 = new Negociacao(52.3, 100, depois);
		
		List<Negociacao> negociacoes = Arrays.asList(n1,n2,n3,n4,n5,n6,n7,n8);
		CandlestickFactory fabrica = new CandlestickFactory();
		List<Candlestick> candles = fabrica.constroiCandles(negociacoes);
		
		Assert.assertEquals(3, candles.size());
		Assert.assertEquals(40.5, candles.get(0).getAbertura(),0.00001);
		Assert.assertEquals(42.3, candles.get(0).getFechamento(),0.00001);
		Assert.assertEquals(48.8, candles.get(1).getAbertura(),0.00001);
		Assert.assertEquals(49.3, candles.get(1).getFechamento(),0.00001);
		Assert.assertEquals(51.8, candles.get(2).getAbertura(),0.00001);
		Assert.assertEquals(52.3, candles.get(2).getFechamento(),0.00001);
	}
	
	@Test
	public void negociacoesDeDiasDistintosOrdemDiferenteGeraCandles(){
		Calendar hoje = Calendar.getInstance();
		Calendar amanha = (Calendar) hoje.clone();
		amanha.add(Calendar.DAY_OF_MONTH, 1);
		Calendar depois = (Calendar) hoje.clone();
		depois.add(Calendar.DAY_OF_MONTH,5);
		
		
		Negociacao n1 = new Negociacao(40.5, 100, hoje);
		Negociacao n2 = new Negociacao(45, 100, amanha);
		Negociacao n3 = new Negociacao(39.8, 100, depois);
		Negociacao n4 = new Negociacao(42.3, 100, hoje);
		

		Negociacao n5 = new Negociacao(48.8, 100, hoje);
		Negociacao n6 = new Negociacao(49.3, 100, amanha);
		

		
		Negociacao n7 = new Negociacao(51.8, 100, hoje);
		Negociacao n8 = new Negociacao(52.3, 100, depois);
		
		List<Negociacao> negociacoes = Arrays.asList(n1,n2,n3,n4,n5,n6,n7,n8);
		CandlestickFactory fabrica = new CandlestickFactory();
		List<Candlestick> candles = fabrica.constroiCandles(negociacoes);
		
		Assert.assertEquals(3, candles.size());

	}
	
}
