package br.com.rgrasson.appium.seuBarriga;

import br.com.rgrasson.appium.core.BasePage;

public class SBMenuPage extends BasePage {

	public void acessarContas() {
		clicaPorTexto("CONTAS");
	}
	
	public void acessarMov() {
		clicaPorTexto("MOV...");
	}
	
	public void acessarResuma() {
		clicaPorTexto("RESUMO");
	}
	
	public void acessarHome() {
		clicaPorTexto("HOME");
	}
}
