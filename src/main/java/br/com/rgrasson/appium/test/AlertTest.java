package br.com.rgrasson.appium.test;

import org.junit.Test;

import br.com.rgrasson.appium.core.BaseTest;
import br.com.rgrasson.appium.page.AlertaPage;
import br.com.rgrasson.appium.page.MenuPage;
import org.junit.Assert;
import org.junit.Before;

public class AlertTest extends BaseTest {
	
	private MenuPage menu = new MenuPage();
	private AlertaPage page = new AlertaPage();

	
	@Before
	
	public void setup() {
		menu.acessarAlerta();
	}
	@Test
	public void deveConfimarAlerta() {
		
		//Acessar menu alerta
		menu.acessarAlerta();
		
		//Clicar em alerta confirm
		
		page.clicarAlerta();
		
		//Verificar os textos
		Assert.assertEquals("Info", page.obterTituloAlerta());
		Assert.assertEquals("Confirma a operação?", page.obterMensagemAlerta());
		
		
		//confirmar alerta
		page.confirmaPorTexto();
		
		//Verificar nova mensagem
		Assert.assertEquals("Confirmado", page.obterMensagemAlerta());

		//sair
		
		page.sairAlerta();
	}
	@Test
	public void deveClicarForaAlerta() {
		
		
		//Click alerta simples
		
		page.clicarAlertaSimples();
		//click fora da caixa
		//clicar 315, 112
		page.clicarForaCaixa();
		//verificar que a msg n existe mais
		esperar(1000);
		page.clicaPorTexto("OK");
		Assert.assertFalse(page.existeElementoPorTexto("Pode clicar no OK ou fora da caixa para sair"));
	}
}
