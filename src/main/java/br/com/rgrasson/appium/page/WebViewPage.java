package br.com.rgrasson.appium.page;

import java.util.Set;

import org.openqa.selenium.By;

import br.com.rgrasson.appium.core.BasePage;
import br.com.rgrasson.appium.core.DriverFactory;

public class WebViewPage extends BasePage{
	
	public void contextWeb() {
		Set <String>  contextHandles = DriverFactory.getDriver().getContextHandles();
//		for(String valor: contextHandles) {
//			System.out.println(valor);
//		}
		DriverFactory.getDriver().context((String) contextHandles.toArray()[1]);
	}

	public void setEmail(String valor) {
		DriverFactory.getDriver().findElement(By.id("email")).sendKeys(valor);
	}
	
	public void setSenha(String valor) {
		DriverFactory.getDriver().findElement(By.id("senha")).sendKeys(valor);
	}
	
	public void clickEntrar() {
		clicar(By.xpath("//button[@type='submit']"));
	}
	
	public String getMensagem() {
		return checarNome(By.xpath("//div[@class='alert alert-success']"));
	}
	
	public void exitContext() {
		

		DriverFactory.getDriver().context((String) DriverFactory.getDriver().getContextHandles().toArray()[0]);
	}
}
