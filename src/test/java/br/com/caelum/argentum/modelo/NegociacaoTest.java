package br.com.caelum.argentum.modelo;

import java.util.Calendar;
import java.util.GregorianCalendar;

import junit.framework.Assert;

import org.junit.Test;

@SuppressWarnings("deprecation")
public class NegociacaoTest {

	@Test
	public void dataDaNegociacaoEhImutavel() {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DAY_OF_MONTH, 15);
		Negociacao n = new Negociacao(10, 5, c);
		
		n.getData().set(Calendar.DAY_OF_MONTH, 20);
		
		Assert.assertEquals(15, n.getData().get(Calendar.DAY_OF_MONTH));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void negociacaoDataNula(){
		new Negociacao(10, 10, null);
	}
	
	@Test
	public void mesmoMilissegundoEhDoMesmoDia(){
		Calendar agora = Calendar.getInstance();
		Calendar mesmoMomento = (Calendar) agora.clone();
		
		Negociacao negociacao = new Negociacao(40, 100, agora);
		Assert.assertTrue(negociacao.isMesmoDia(mesmoMomento));
	}
	
	@Test
	public void horariosDiferentesMesmoDia(){
		Calendar manha = new GregorianCalendar(2011,10,20,8,30);
		Calendar tarde = new GregorianCalendar(2011, 10, 20,15,30);
		
		Negociacao n = new Negociacao(10, 10, manha);
		Assert.assertTrue(n.isMesmoDia(tarde));
	}
	
	@Test
	public void mesmoDiaMesDiferente(){
		Calendar data1 = new GregorianCalendar(2011,10,20,8,30);
		Calendar data2 = new GregorianCalendar(2011,11,20,9,30);
		Negociacao n = new Negociacao(10, 10, data1);
		Assert.assertFalse(n.isMesmoDia(data2));
	}
	
	@Test
	public void anoDiferente(){
		Calendar data1 = new GregorianCalendar(2011,10,20,8,30);
		Calendar data2 = new GregorianCalendar(2012,10,20,9,30);
		Negociacao n = new Negociacao(10, 10, data1);
		Assert.assertFalse(n.isMesmoDia(data2));
	}

}
