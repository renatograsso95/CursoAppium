package br.com.rgrasson.appium.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import br.com.rgrasson.appium.core.BaseTest;
import br.com.rgrasson.appium.page.MenuPage;
import br.com.rgrasson.appium.page.WebViewPage;

public class WebViewTest extends BaseTest{
	private MenuPage menu = new MenuPage();
	private WebViewPage page = new WebViewPage();
	
	
	@Test
	public void deveFazerLogin() {
		
		
		//acessar menu
		
		menu.acessarSBHibrido();
		esperar(3000);
		page.contextWeb();
		//preencher email
		
		page.setEmail("renatograsso@g");
		//preencher senha
		
		page.setSenha("renato10");
		
		//entrar
		
		page.clickEntrar();
		
		//verificar
		
		Assert.assertEquals("Bem vindo, Renato!", page.getMensagem());
	}
	
	@After
	public void tearDown() {
		page.exitContext();
	}

}
