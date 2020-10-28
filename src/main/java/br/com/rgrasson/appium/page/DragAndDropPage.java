package br.com.rgrasson.appium.page;

import java.util.List;

import org.openqa.selenium.By;

import br.com.rgrasson.appium.core.DriverFactory;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.ElementOption;

public class DragAndDropPage {

	public void arrastar(String origem, String destino) {
//	MobileElement inicio = DriverFactory.getDriver().findElement(By.xpath("//*[text='" + origem + "']"));
//	MobileElement fim = DriverFactory.getDriver().findElement(By.xpath("//*[text='" + destino + "']"));

	new TouchAction(DriverFactory.getDriver()).longPress(ElementOption.element(DriverFactory.getDriver().findElement(By.xpath("//*[@text='"+origem+"']"))))

	.moveTo(ElementOption.element(DriverFactory.getDriver().findElement(By.xpath("//*[@text='"+destino+"']")))).release().perform();
		
		
	}

	public String[] obterLista() {
		List<MobileElement> elements = DriverFactory.getDriver().findElements(By.xpath("//android.widget.TextView"));

		String[] retorno = new String[elements.size()];
		for (int i = 0; i < elements.size(); i++) {
			retorno[i] = elements.get(i).getText();
//			System.out.println("\"" + retorno[i] + "\", ");
		}
		return retorno;
	}

}
