package br.com.rgrasson.appium.page;

import br.com.rgrasson.appium.core.BasePage;

public class AbasPage extends BasePage {

	public boolean obterPrimeiraAba() {
		return existeElementoPorTexto("Este � o conte�do da Aba 1");
	}

	public boolean obterSegundaAba() {
		return existeElementoPorTexto("Este � o conte�do da Aba 2");
	}
}
