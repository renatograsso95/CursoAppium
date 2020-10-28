package br.com.rgrasson.appium.test;

import org.junit.Assert;
import org.junit.Test;

import br.com.rgrasson.appium.core.BaseTest;
import br.com.rgrasson.appium.page.AccordionPage;
import br.com.rgrasson.appium.page.MenuPage;

public class AccordionTest extends BaseTest {
	
	private MenuPage menu = new MenuPage();
	private AccordionPage page = new AccordionPage();

	@Test
	public void deveInteragirComAccordion() {
		
		//acessar menu
		
		menu.acessarAccordion();
		
		//clicar op��o 1
		
		page.selecionarOp1();
		
		//Verificar o texto
		esperar(1000);
		
		Assert.assertEquals("Esta � a descri��o da op��o 1", page.obterValorOp1());

	}
}
