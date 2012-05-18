package model;

public class Cliente {

	private boolean clienteEspecial;
	private Double saldoAtual;

	public boolean isClienteEspecial() {
		return clienteEspecial;
	}

	public Double getSaldoAtual() {
		return saldoAtual;
	}

	public void clienteEspecial() {
		this.clienteEspecial = true;
	}

	public void clienteComum() {
		this.clienteEspecial = false;
	}

	public void setSaldoAtual(Double saldoAtual) {
		this.saldoAtual = saldoAtual;
	}

	// Método reponsável por liberar ou não o saque
	public boolean sacar(Double valorDoSaque) throws Exception {
		// Se o saldo for ficar negativo
		if (this.saldoAtual < valorDoSaque) {

			// E o cliente for especial
			if (isClienteEspecial()) {
				// Libera o saque e atualiza o saldo
				this.atualizarSaldo(valorDoSaque);
				return true;

				// Se o cliente for comum
			} else {
				// Não libera o saque e retorna uma mensagem na Exception
				throw new Exception("Saldo Insuficiente");
			}
			// Se o saldo for ficar positivo
		} else {
			// Libera o saque e atualiza o saldo
			this.atualizarSaldo(valorDoSaque);
			return true;
		}

	}

	private void atualizarSaldo(Double valorDoSaque) {
		this.saldoAtual -= valorDoSaque;
	}
}
