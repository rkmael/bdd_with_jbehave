package test;

import static org.junit.Assert.*;
import model.Cliente;

import org.jbehave.scenario.annotations.Given;
import org.jbehave.scenario.annotations.Then;
import org.jbehave.scenario.annotations.When;
import org.jbehave.scenario.steps.Steps;

public class SaqueDeClienteEspecialComSaldoNegativo extends Steps {

	// Objeto que representa o cliente
	private Cliente cliente;

	// Variável usada para validar se o saque foi ou não liberado
	private boolean saqueEfetuado = false;

	// Instancia o cliente e define o saldo inicial
	@Given("um cliente especial com saldo atual de $saldoAtual reais")
	public void popularCliente(Double saldoAtual) {
		cliente = new Cliente();
		cliente.setSaldoAtual(saldoAtual);
		cliente.clienteEspecial();
	}

	// Efetua o saque e armazena o retorno na variável que será testada a seguir
	@When("for solicitado um saque no valor de $valorDoSaque reais")
	public void sacar(Double valorDoSaque) throws Exception {
		saqueEfetuado = cliente.sacar(valorDoSaque);
	}

	// Verifica se o saque foi efetuado e se o saldo foi atualizado
	@Then("deve efetuar o saque e atualizar o saldo da conta para $novoSaldo reais")
	public void verificaOSaldo(Double novoSaldo) {
		assertTrue(saqueEfetuado);
		assertEquals(novoSaldo, cliente.getSaldoAtual(), 0d);
	}
}
