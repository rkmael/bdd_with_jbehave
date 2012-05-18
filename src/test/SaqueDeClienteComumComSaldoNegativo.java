package test;

import static org.junit.Assert.*;
import model.Cliente;

import org.jbehave.scenario.annotations.Given;
import org.jbehave.scenario.annotations.Then;
import org.jbehave.scenario.annotations.When;
import org.jbehave.scenario.steps.Steps;

public class SaqueDeClienteComumComSaldoNegativo extends Steps {

	// Objeto que representa o cliente
	private Cliente cliente;

	// Variável usada para validar se o saque foi ou não liberado
	private final boolean saqueEfetuado = false;

	// Variável usada para armazenar a mensagem que será validada a seguir
	private Exception exception;

	// Instancia o cliente e define o saldo inicial
	@Given("um cliente comum com saldo atual de $saldoAtual reais")
	public void popularCliente(Double saldoAtual) {
		cliente = new Cliente();
		cliente.setSaldoAtual(saldoAtual);
		cliente.clienteComum();
	}

	// Efetua o saque e armazena a mensagem de retorno na variável que será testada a seguir
	@When("solicitar um saque de $valorDoSaque reais")
	public void sacar(Double valorDoSaque) {
		try {
			cliente.sacar(valorDoSaque);
		} catch (Exception e) {
			this.exception = e;
		}
	}

	// Validar se o saque foi negado e se mensagem de retorno foi a mesma que a especificada no cenário
	@Then("não deve efetuar o saque e retornar a mensagem $msg")
	public void verificaOSaldo(String msg) {
		assertFalse(saqueEfetuado);
		assertEquals(msg, exception.getMessage());
	}
}
