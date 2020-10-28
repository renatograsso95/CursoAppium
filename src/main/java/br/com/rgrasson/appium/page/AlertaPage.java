package br.com.rgrasson.appium.page;

import org.openqa.selenium.By;

import br.com.rgrasson.appium.core.BasePage;

public class AlertaPage extends BasePage {

	public void clicarAlerta() {
		clicaPorTexto("ALERTA CONFIRM");
	}
	
	public void clicarAlertaSimples() {
		clicaPorTexto("ALERTA SIMPLES");
	}
	

	
	public void confirmaPorTexto() {
		clicaPorTexto("CONFIRMAR");
	}
	
	public void sairAlerta() {
		clicaPorTexto("SAIR");
	}
	
	public void clicarForaCaixa() {
			tap(100, 150);
	}
}
