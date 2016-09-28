package br.com.caelum.reader;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import br.com.caelum.argentum.modelo.Negociacao;
import br.com.caelum.argentum.reader.LeitorXML;

@SuppressWarnings("deprecation")
public class LeitorXMLTest {

	@Test
	public void carregaXmlComUmaNegociacaoEmListaUnitaria() {
		String xmlTeste = "<list>"+
							"<negociacao>"
							+ "<preco>43.5</preco>"
							+ "<quantidade>1000</quantidade>"
							+ "<data>"
							+ "<time>1322233344455</time>"
							+ "</data>"
							+ "</negociacao>"
							+ "</list>";
		
		LeitorXML leitor = new LeitorXML();
		InputStream xml = new ByteArrayInputStream(xmlTeste.getBytes());
		List<Negociacao> negociacoes = leitor.carrega(xml);
		Assert.assertEquals(1, negociacoes.size());
		Assert.assertEquals(43.5, negociacoes.get(0).getPreco());
		Assert.assertEquals(1000, negociacoes.get(0).getQuantidade());
	}
	
	@Test
	public void carregaXmlComZeroNegociacao() {
		String xmlTeste = "<list> </list>";
		
		LeitorXML leitor = new LeitorXML();
		InputStream xml = new ByteArrayInputStream(xmlTeste.getBytes());
		List<Negociacao> negociacoes = leitor.carrega(xml);
		Assert.assertEquals(0, negociacoes.size());

	}
	
	@Test
	public void carregaXmlComTresNegociacoes() {
		String xmlTeste = "<list>"+
							"<negociacao>"
							+ "<preco>43.5</preco>"
							+ "<quantidade>1000</quantidade>"
							+ "<data>"
							+ "<time>1322233344455</time>"
							+ "</data>"
							+ "</negociacao>"
							+ "<negociacao>"
							+ "<preco>48.5</preco>"
							+ "<quantidade>1000</quantidade>"
							+ "<data>"
							+ "<time>1322233344455</time>"
							+ "</data>"
							+ "</negociacao>"
							+ "<negociacao>"
							+ "<preco>80.5</preco>"
							+ "<quantidade>200</quantidade>"
							+ "<data>"
							+ "<time>1322233344455</time>"
							+ "</data>"
							+ "</negociacao>"
							+ "</list>";
		
		LeitorXML leitor = new LeitorXML();
		InputStream xml = new ByteArrayInputStream(xmlTeste.getBytes());
		List<Negociacao> negociacoes = leitor.carrega(xml);
		Assert.assertEquals(3, negociacoes.size());
		Assert.assertEquals(43.5, negociacoes.get(0).getPreco());
		Assert.assertEquals(1000, negociacoes.get(0).getQuantidade());
		Assert.assertEquals(48.5, negociacoes.get(1).getPreco());
		Assert.assertEquals(1000, negociacoes.get(1).getQuantidade());
		Assert.assertEquals(80.5, negociacoes.get(2).getPreco());
		Assert.assertEquals(200, negociacoes.get(2).getQuantidade());
	}
	
	@Test
	public void carregaXmlComDuasNegociacoesFaltandoPrecoeQuantidade() {
		String xmlTeste = "<list>"+
							"<negociacao>"
							+ "<preco>43.5</preco>"
							+ "<data>"
							+ "<time>1322233344455</time>"
							+ "</data>"
							+ "</negociacao>"
							+ "<negociacao>"
							+ "<quantidade>1000</quantidade>"
							+ "<data>"
							+ "<time>1322233344455</time>"
							+ "</data>"
							+ "</negociacao>"
							+ "</list>";
		
		LeitorXML leitor = new LeitorXML();
		InputStream xml = new ByteArrayInputStream(xmlTeste.getBytes());
		List<Negociacao> negociacoes = leitor.carrega(xml);
		Assert.assertEquals(2, negociacoes.size());
		Assert.assertEquals(43.5, negociacoes.get(0).getPreco());
		Assert.assertEquals(0, negociacoes.get(0).getQuantidade());
		Assert.assertEquals(0.0, negociacoes.get(1).getPreco());
		Assert.assertEquals(1000, negociacoes.get(1).getQuantidade());

	}

}


