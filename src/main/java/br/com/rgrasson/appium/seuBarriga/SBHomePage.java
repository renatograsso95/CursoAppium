package br.com.rgrasson.appium.seuBarriga;

import org.openqa.selenium.By;

import br.com.rgrasson.appium.core.BasePage;

public class SBHomePage extends BasePage {

	
	public String obterSaldoConta(String conta) {
		return checarNome(By.xpath("//*[@text='" + conta + "']/following-sibling::android.widget.TextView"));
	}
}
