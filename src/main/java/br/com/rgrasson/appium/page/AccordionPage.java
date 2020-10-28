package br.com.rgrasson.appium.page;

import org.openqa.selenium.By;

import br.com.rgrasson.appium.core.BasePage;

public class AccordionPage extends BasePage {
	
	public void selecionarOp1() {
		clicaPorTexto("Opção 1");
	}

	public String obterValorOp1() {
		return checarNome(By.xpath("//*[text='Opção 1]/../..//following-sibling::android.view.ViewGroup//android.widget.TextView"));
	}
}
