package br.com.rgrasson.appium.test;

import org.junit.Assert;
import org.junit.Test;

import br.com.rgrasson.appium.core.BaseTest;
import br.com.rgrasson.appium.page.AbasPage;
import br.com.rgrasson.appium.page.MenuPage;

public class AbaTest extends BaseTest {

	private MenuPage menu = new MenuPage();
	private AbasPage page = new AbasPage();

	@Test
	public void deveInteragircomAbas() {

		// Acessar menu aba

		menu.acessarAba();

		// verificar aba 1

		Assert.assertTrue(page.obterPrimeiraAba());

		// acessar aba2

		menu.acessarSegundaAba();

		// verificar que esta na aba2

		Assert.assertTrue(page.obterSegundaAba());

	}

}
