package br.com.rgrasson.appium.seuBarriga;

import org.openqa.selenium.By;

import br.com.rgrasson.appium.core.BasePage;


public class SBContasPage extends BasePage {

	public void setConta(String nome) {
		escrever(By.className("android.widget.EditText"), nome);
	}
	
	public void salvar() {
		clicaPorTexto("SALVAR");
	}
	
	public void excluir() {
		clicaPorTexto("EXCLUIR");
	}
	
	public void selecionarConta(String conta) {
		cliqueLongo(By.xpath("//*[@text='"+ conta + "']"));

	}
}
