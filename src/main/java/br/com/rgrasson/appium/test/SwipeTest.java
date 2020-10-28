package br.com.rgrasson.appium.test;

import org.junit.Assert;
import org.junit.Test;

import br.com.rgrasson.appium.core.BaseTest;
import br.com.rgrasson.appium.page.MenuPage;
import br.com.rgrasson.appium.page.SwipeListPage;

public class SwipeTest extends BaseTest {

	private MenuPage menu = new MenuPage();
	private SwipeListPage page = new SwipeListPage();

	@Test
	public void deveRealizarSwipe() {
		// acessar menu

		menu.acessaSwipe();

		// verificar texto "a esquerda"

		Assert.assertTrue(menu.existeElementoPorTexto("a esquerda"));

		// swipe para direita

		menu.swipeRight();

		// verificar texto 'E veja se'

		Assert.assertTrue(menu.existeElementoPorTexto("E veja se"));

		// clica botao direito

		menu.clicaPorTexto("›");

		// verifica texto 'Chegar ate o fim'

		Assert.assertTrue(menu.existeElementoPorTexto("Chegar até o fim!"));

		// swipe esquerda

		menu.swipeLeft();

		// clica no botao da esquerda

		menu.clicaPorTexto("‹");

		// verificar texto "a esquerda"
		Assert.assertTrue(menu.existeElementoPorTexto("a esquerda"));

	}

	@Test
	public void deveRealizarSwipeList() {
		// Clicar swipe List

		menu.acessaSwipeList();

		// Op1 para direita

		page.swipeElementRight("Opção 1");

		// op1+

		page.clicarBotaoMais();
		
		// Verificar op1+

		Assert.assertTrue(page.existeElementoPorTexto("Opção 1 (+)"));
		
		// op4 para direita

		page.swipeElementRight("Opção 4");

		// op4 -
		page.clicaPorTexto("(-)");

		// verificar op4-

		Assert.assertTrue(page.existeElementoPorTexto("Opção 4 (-)"));

		// p5 para direita

		page.swipeElementLeft("Opção 5 (-)");

		// verificar op5

		Assert.assertTrue(page.existeElementoPorTexto("Opção 5"));

	}

}
