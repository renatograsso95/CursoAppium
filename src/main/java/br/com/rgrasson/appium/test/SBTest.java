package br.com.rgrasson.appium.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.rgrasson.appium.core.BaseTest;
import br.com.rgrasson.appium.page.MenuPage;
import br.com.rgrasson.appium.seuBarriga.SBContasPage;
import br.com.rgrasson.appium.seuBarriga.SBHomePage;
import br.com.rgrasson.appium.seuBarriga.SBLoginPage;
import br.com.rgrasson.appium.seuBarriga.SBMenuPage;
import br.com.rgrasson.appium.seuBarriga.SBMovimentacaoPage;
import br.com.rgrasson.appium.seuBarriga.SBResumoPage;

public class SBTest extends BaseTest {

	private MenuPage menu = new MenuPage();
	private SBLoginPage login = new SBLoginPage();
	private SBMenuPage SBMenu = new SBMenuPage();
	private SBContasPage contas = new SBContasPage();
	private SBMovimentacaoPage mov = new SBMovimentacaoPage();
	private SBHomePage home = new SBHomePage();
	private SBResumoPage resumo = new SBResumoPage();

	@Before
	public void setup() {
		menu.acessarSBNativo();
		login.setEmail("renatograsso@g");
		login.setSenha("renato10");
		login.entrar();

	}

	@Test
	public void deveInserirConta() {

		// entrar em conta

		SBMenu.acessarContas();

		// digitar nome conta

		contas.setConta("Conta de Teste");

		// salvar

		contas.salvar();

		// verificar mensagem

		Assert.assertTrue(contas.existeElementoPorTexto("Conta adicionada com sucesso"));

	}

	@Test
	public void deveExcluirConta() {
		// entrar em conta

		SBMenu.acessarContas();

		// clique longo na conta

		contas.selecionarConta("123");

		// excluir

		contas.excluir();

		// verificar mensagem]

		Assert.assertTrue(contas.existeElementoPorTexto("Conta excluída com sucesso"));

	}

	@Test
	public void deveValidarMovimentacaoInclusao() {

		// clicar MOV...

		SBMenu.acessarMov();

		// validar des

		mov.salvar();
		Assert.assertTrue(mov.existeElementoPorTexto("Descrição é um campo obrigatório"));

		// validar inte

		mov.setDescricao("Desc");
		mov.salvar();
		Assert.assertTrue(mov.existeElementoPorTexto("Interessado é um campo obrigatório"));

		// validar valor

		mov.setInteressado("Renato");
		mov.salvar();
		Assert.assertTrue(mov.existeElementoPorTexto("Valor é um campo obrigatório"));

		// validar conta

		mov.setValor("123");
		mov.salvar();
		Assert.assertTrue(mov.existeElementoPorTexto("Conta é um campo obrigatório"));

		// inserir com sucesso

		mov.setConta("Conta para alterar");
		mov.salvar();
		Assert.assertTrue(mov.existeElementoPorTexto("Movimentação cadastrada com sucesso"));

	}

	@Test
	public void deveAtualizarSaldoAoExcluirMovimento() {
		// verificar saldo "Conta para saldo = 534.00

		Assert.assertEquals("534.00", home.obterSaldoConta("Conta para saldo"));

		// ir pararesumo

		SBMenu.acessarResuma();
		// excluir Movimentacao 3

		resumo.excluirMovimentacao("Movimentacao 3, calculo saldo");

		// validar a mensagem "Movimentacao removida com sucesso"

		Assert.assertTrue(resumo.existeElementoPorTexto("Movimentação removida com sucesso!"));

		// voltar home

		SBMenu.acessarHome();

		// atualizar saldos
		esperar(1000);
		home.scroll();

		// verificar saldo = -1000

		Assert.assertEquals("-1000.00", home.obterSaldoConta("Conta para saldo"));
	}
}
