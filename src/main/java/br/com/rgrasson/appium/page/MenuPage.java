package br.com.rgrasson.appium.page;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.rgrasson.appium.core.BasePage;
import br.com.rgrasson.appium.core.DriverFactory;

public class MenuPage extends BasePage{


	public void acessarFormulario() {
		clicaPorTexto("Formulário");
	}

	public void acessarSplash() {
		clicaPorTexto("Splash");
	}
	
	public void acessarAlerta() {
		clicaPorTexto("Alertas");
	}
	
	public void acessarAba() {
		clicaPorTexto("Abas");
	}
	
	public void acessarSegundaAba() {
		clicaPorTexto("ABA 2");
	}
	
	public void acessarAccordion() {
		clicaPorTexto("Accordion");
	}
	
	public void acessarCliques() {
		clicaPorTexto("Cliques");
	}
	
	public void acessaSwipe() {
		clicaPorTexto("Swipe");
	}
	
	public void acessarSBHibrido() {
		clicaPorTexto("SeuBarriga Híbrido");
	}
	
	
	
	public void acessaDragAndDrop() {
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Formulário']")));

		scrollByText("Drag and drop");
		clicaPorTexto("Drag and drop");

		
	}
	
	public void acessaSwipeList() {
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Formulário']")));

		scroll();
		clicaPorTexto("Swipe List");
	}

	public void acessarSBNativo() {
		clicaPorTexto("SeuBarriga Nativo");
		
	}
}
