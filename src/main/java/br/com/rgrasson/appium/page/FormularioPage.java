package br.com.rgrasson.appium.page;

import org.openqa.selenium.By;

import br.com.rgrasson.appium.core.BasePage;
import br.com.rgrasson.appium.core.DriverFactory;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

public class FormularioPage extends BasePage {


	public void escreverNome(String nome) {
		escrever(MobileBy.AccessibilityId("nome"), nome);

	}

	public String obterNome() {

		return checarNome(MobileBy.AccessibilityId("nome"));
	}

	public void selecionarCombo(String valor) {
		selecionarCombo(MobileBy.AccessibilityId("console"), valor);

	}

	public String obterValorCombo() {

		return checarNome(By.xpath("//android.widget.Spinner/android.widget.TextView"));

	}

	public void clicarCheck() {
		clicar(By.className("android.widget.CheckBox"));

	}

	public void clicarSwitch() {
		clicar(MobileBy.AccessibilityId("switch"));

	}
	
	public void clicarSeekBar(double posicao) {
		MobileElement seek =	
				DriverFactory.getDriver().findElement(MobileBy.AccessibilityId("slid"));
		
		int delta = 50;
		
		int xInicial = seek.getLocation().x + delta;
		
		int x = (int) (xInicial + (seek.getSize().width - 2 * delta) * posicao);
		int y = (seek.getLocation().y)+ (seek.getSize().height / 2);
		
		tap(x, y);
	
	}

	public void clicarSalvar() {
		clicaPorTexto("SALVAR");

	}
	public void clicarSalvarDemorado() {
		clicaPorTexto("SALVAR DEMORADO");

	}

	public boolean isCheckMarcado() {
		return isCheckMarcado(By.className("android.widget.CheckBox"));

	}

	public boolean isSwitchMarcado() {
		return isCheckMarcadoFalse(By.className("android.widget.Switch"));

	}

	public String obterNomePessoal() {

		return checarNome(By.xpath("//android.widget.TextView[@text='Nome: Renato']"));

	}

	public String obterConsole() {
		return checarNome(By.xpath("//android.widget.TextView[@text='Console: switch']"));

	}

	public String obterEstadoCheckBox() {
		return checarNome(By.xpath("//android.widget.TextView[@text='Checkbox: Marcado']"));
	}

	public String obterEstadoSwitch() {
		return checarNome(By.xpath("//android.widget.TextView[@text='Switch: Off']"));


	}

}
