package br.com.rgrasson.appium.test;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.rgrasson.appium.core.BaseTest;
import br.com.rgrasson.appium.core.DriverFactory;
import br.com.rgrasson.appium.page.MenuPage;

public class OpcaoEscondidaTest extends BaseTest {

	public MenuPage menu = new MenuPage();
	@Test
	public void devoEncontrarOpcaoEscondida() {
		
		//scroll
		
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 10);
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Formul�rio']")));
		
		menu.scroll();
		
		//clicar menu
		
		menu.clicaPorTexto("Op��o Bem Escondida");
		
		
		//verificar menu
		
		Assert.assertEquals("Voc� achou essa op��o" , menu.obterMensagemAlerta());
		
		//sair
		
		menu.clicaPorTexto("OK");
	}
}
