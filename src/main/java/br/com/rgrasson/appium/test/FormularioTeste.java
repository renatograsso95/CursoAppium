package br.com.rgrasson.appium.test;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.rgrasson.appium.core.BaseTest;
import br.com.rgrasson.appium.core.DriverFactory;
import br.com.rgrasson.appium.page.FormularioPage;
import br.com.rgrasson.appium.page.MenuPage;
import io.appium.java_client.MobileBy;
import io.appium.java_client.functions.ExpectedCondition;

public class FormularioTeste extends BaseTest {

	private MenuPage menu = new MenuPage();
	private FormularioPage formulario = new FormularioPage();

	@Before
	public void inicializarAppium() throws MalformedURLException {

		menu.acessarFormulario();

	}

	@Test
	public void devePreencherCampoTexto() throws MalformedURLException {

		// escrever nome
		formulario.escreverNome("Renato");

		// Validar nome esssrito

		Assert.assertEquals("Renato", formulario.obterNome());
	}

	@Test
	public void deveInteragirComCombo() throws MalformedURLException {

		// class[@att='']

		// Clicar no combo
		formulario.selecionarCombo("Nintendo Switch");

		// Verificar opção

		Assert.assertEquals("Nintendo Switch", formulario.obterValorCombo());

	}

	@Test
	public void deveInteragirSwitchCheckBox() throws MalformedURLException {

		// Verificar status dos elementos

		Assert.assertFalse(formulario.isCheckMarcado());
		Assert.assertFalse(formulario.isSwitchMarcado());

		// Clicar nos elementos
		formulario.clicarCheck();
		formulario.clicarSwitch();

		// Verificar status alterados

		Assert.assertFalse(formulario.isCheckMarcado());
		Assert.assertFalse(formulario.isSwitchMarcado());

	}

	@Test
	public void preencherESalvarFormulario() {

		// Selecionar o nome

		formulario.escreverNome("Renato");

		// Selecionar opçoes

		formulario.selecionarCombo("Nintendo Switch");

		// Selecionar switch e Checkbox

		formulario.clicarSwitch();
		formulario.clicarCheck();

		// Salvar

		formulario.clicarSalvar();

		// Validação

		Assert.assertEquals("Nome: Renato", formulario.obterNomePessoal());
		Assert.assertEquals("Console: switch", formulario.obterConsole());

		Assert.assertEquals("Switch: Off", formulario.obterEstadoSwitch());
		Assert.assertEquals("Checkbox: Marcado", formulario.obterEstadoCheckBox());

	}

	@Test
	public void preencherESalvarFormularioDemorado() {

		formulario.escreverNome("Renato");

		DriverFactory.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		
		formulario.clicarSalvarDemorado();

//		esperar(3000);
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Nome: Renato']")));
		
		Assert.assertEquals("Nome: Renato", formulario.obterNomePessoal());

	}
	
	@Test
	public void deveAlterarData() {
		menu.clicaPorTexto("01/01/2000");
		menu.clicaPorTexto("20");
		menu.clicaPorTexto("OK");
		Assert.assertTrue(menu.existeElementoPorTexto("20/2/2000"));
	}
	
	@Test
	public void deveAlterarHora() {
		menu.clicaPorTexto("06:00");
		menu.clicar(MobileBy.AccessibilityId("10"));
		menu.clicar(MobileBy.AccessibilityId("40"));
		menu.clicaPorTexto("OK");
		Assert.assertTrue(menu.existeElementoPorTexto("10:40"));
	}
	
	@Test
	public void deveInteragirComSeekBar() {
		//Clicar no SeekBar
		
		formulario.clicarSeekBar(0.65);
		
		//Salvar
		
		formulario.clicarSalvar();
		//ObterValor
	}

}
