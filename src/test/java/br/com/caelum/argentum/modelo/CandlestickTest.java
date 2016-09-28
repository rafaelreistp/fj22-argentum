package br.com.caelum.argentum.modelo;

import java.util.Calendar;

import org.junit.Test;

public class CandlestickTest {

	@Test(expected=IllegalArgumentException.class)
	public void minimoMaiorQueMaximo(){
		@SuppressWarnings("unused")
		Candlestick candle = new Candlestick(10, 10, 500, 300, 1000, Calendar.getInstance());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void dataNula(){
		@SuppressWarnings("unused")
		Candlestick candle = new Candlestick(10,10,10,10,10,null);
	}
	
//	@Test(expected=IllegalArgumentException.class)
//	public void valorNulo(){
//		Candlestick candle = new Candlestick(-1,-1,-1,-1,-1,Calendar.getInstance());
//	}

}
