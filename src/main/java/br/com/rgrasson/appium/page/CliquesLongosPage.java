package br.com.rgrasson.appium.page;

import org.openqa.selenium.By;

import br.com.rgrasson.appium.core.BasePage;
import br.com.rgrasson.appium.core.DriverFactory;

public class CliquesLongosPage extends BasePage{

	public void cliqueLongo() {
		cliqueLongo(By.xpath("//*[@text='Clique Longo']"));
		}
	
	public String obterTextoCampo() {
		return DriverFactory.getDriver().findElement(By.xpath("(//android.widget.TextView)[3]")).getText();
	}
}
