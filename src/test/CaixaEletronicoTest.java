package test;

import org.jbehave.scenario.Scenario;

public class CaixaEletronicoTest extends Scenario {

	// Construtor
	public CaixaEletronicoTest() {
		// Cria Steps que irão executar os cenários do arquivo texto.
		addSteps(new SaqueDeClienteEspecialComSaldoNegativo());
		addSteps(new SaqueDeClienteComumComSaldoNegativo());
	}

}
