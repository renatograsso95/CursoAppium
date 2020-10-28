package br.com.rgrasson.appium.core;

import static br.com.rgrasson.appium.core.DriverFactory.getDriver;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

public class BasePage {

	public void escrever(By by, String texto) {
		getDriver().findElement(by).sendKeys(texto);
	}

	public String checarNome(By by) {
		return getDriver().findElement(by).getText();
	}

	public void clicaPorTexto(String texto) {
		clicar((By.xpath("//*[@text='" + texto + "']")));

	}

	public void clicar(By by) {
		getDriver().findElement(by).click();
	}

	public void selecionarCombo(By by, String valor) {

		getDriver().findElement(by).click();
		clicaPorTexto(valor);

	}

	public boolean isCheckMarcado(By by) {
		return getDriver().findElement(by).getAttribute("checked").equals(true);

	}

	public boolean isCheckMarcadoFalse(By by) {
		return getDriver().findElement(by).getAttribute("checked").equals(false);

	}

	public boolean existeElementoPorTexto(String texto) {
		List<MobileElement> elementos = getDriver().findElements(By.xpath("//*[@text='" + texto + "']"));
		return elementos.size() > 0;
	}

	public String obterTituloAlerta() {
		return checarNome(By.id("android:id/alertTitle"));

	}

	public String obterMensagemAlerta() {
		return checarNome(By.id("android:id/message"));
	}

	public void tap(int x, int y) {
		new TouchAction(getDriver()).tap(PointOption.point(x, y)).perform();
	}

	public void scroll() {
		int x = getDriver().manage().window().getSize().width / 2;

		int start_y = (int) (getDriver().manage().window().getSize().height * 0.2);

		int end_y = (int) (getDriver().manage().window().getSize().height * 0.8);

		new TouchAction(getDriver()).longPress(PointOption.point(x, start_y)).moveTo(PointOption.point(x, end_y))
				.release().perform();

	}

	public void scrollByText(String menuText) {

		try {

			getDriver()

					.findElement(MobileBy

							.AndroidUIAutomator(

									"new UiScrollable(new UiSelector()"

											+ ".scrollable(true)"

											+ ".instance(0))"

											+ ".scrollIntoView(new UiSelector()"

											+ ".textMatches(\"" + menuText + "\")"

											+ ".instance(0));"));

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

//
//	public void scrollDown() {
//		scroll(0.9, 0.1);
//	}
//
//	public void scrollUp() {
//		scroll(0.1, 0.9);
//	}

	public void swipeLeft() {
		swipe(0.1, 0.9);
	}

	public void swipeRight() {
		swipe(0.9, 0.1);
	}

	public void swipe(double inicio, double fim) {

		Dimension size = getDriver().manage().window().getSize();

		int y = size.height / 2;

		int start_x = (int) (size.width * inicio);
		int end_x = (int) (size.width * fim);

		new TouchAction<>(getDriver()).longPress(PointOption.point(start_x, y)).moveTo(PointOption.point(end_x, y))
				.release().perform();

	}

	public void swipeElement(MobileElement element, double inicio, double fim) {
		int y = element.getLocation().y + (element.getSize().height / 2);

		int start_x = (int) (element.getSize().width * inicio);
		int end_x = (int) (element.getSize().width * fim);

		new TouchAction<>(getDriver()).longPress(PointOption.point(start_x, y)).moveTo(PointOption.point(end_x, y))
				.release().perform();
	}

	public void cliqueLongo(By by) {
		new TouchAction<>(DriverFactory.getDriver())
				.longPress(ElementOption.element(DriverFactory.getDriver().findElement(by))).perform();

	}
}
