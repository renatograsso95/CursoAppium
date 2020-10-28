package br.com.rgrasson.appium.page;

import br.com.rgrasson.appium.core.BasePage;

public class AbasPage extends BasePage {

	public boolean obterPrimeiraAba() {
		return existeElementoPorTexto("Este é o conteúdo da Aba 1");
	}

	public boolean obterSegundaAba() {
		return existeElementoPorTexto("Este é o conteúdo da Aba 2");
	}
}
