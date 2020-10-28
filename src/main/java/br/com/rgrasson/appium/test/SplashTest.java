package br.com.rgrasson.appium.test;

import org.junit.Assert;
import org.junit.Test;

import br.com.rgrasson.appium.core.BaseTest;
import br.com.rgrasson.appium.page.MenuPage;
import br.com.rgrasson.appium.page.SplashPage;

public class SplashTest extends BaseTest {

	private MenuPage menu = new MenuPage();
	private SplashPage page = new SplashPage();
	@Test
	public void deveAguardarSplashSumir() {
		
		//acessar menu splash
		menu.acessarSplash();
		//verificar que o splash esta endo exibir
		page.isTelaSplashVisivel();
		//aguarda saida do splash
		page.aguardarSplashSumir();
		//verificar que o form esta aparecendo
		Assert.assertTrue(page.existeElementoPorTexto("Formulário"));
	
	}
}
