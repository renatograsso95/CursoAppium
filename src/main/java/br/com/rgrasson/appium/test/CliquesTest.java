package br.com.rgrasson.appium.test;

import org.junit.Test;

import br.com.rgrasson.appium.core.BaseTest;
import br.com.rgrasson.appium.page.CliquesLongosPage;
import br.com.rgrasson.appium.page.MenuPage;
import org.junit.Assert;
import org.junit.Before;

public class CliquesTest extends BaseTest{
	
	private MenuPage menu = new MenuPage();
	private CliquesLongosPage page = new CliquesLongosPage();
	
	@Before
	public void setup() {
		menu.acessarCliques();
	}

	@Test
	public void deveRealizarCliquesLongos(){
	
		
		//clique longo
		
		page.cliqueLongo();
		
		
		//verificar texto
		
		Assert.assertEquals("Clique Longo", page.obterTextoCampo());
	}
	
	@Test
	public void deveRealizarCliqueDuplo() {
		
		
		//Clique duplo
		
		page.clicaPorTexto("Clique duplo");
		page.clicaPorTexto("Clique duplo");
		
		//verificar texto
		
		Assert.assertEquals("Duplo Clique", page.obterTextoCampo());

	}
}
