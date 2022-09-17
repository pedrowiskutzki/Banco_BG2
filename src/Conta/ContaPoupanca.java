package Conta;

import java.text.DecimalFormat;

public class ContaPoupanca extends Conta {

	public ContaPoupanca(String tipo, String cpf, double saldo, int agencia) {
		super(tipo, cpf, saldo, agencia);
	}

	public String getInfoContaPoupanca(int quantMeses, double depositoRendimento) {
		double rendimento = 0.5;
		double valor = quantMeses * rendimento;
		double n = (valor / 100) * depositoRendimento;
		DecimalFormat df = new DecimalFormat("0.00");
		double resultadoRendimento = depositoRendimento + n;
		return "\n*************Simulação Rendimento***************" + "\nSe você aplicar: R$ " + depositoRendimento
				+ "\nEm " + quantMeses + " meses você tera um rendimento de : R$ " + df.format(n)
				+ "\nSeu saldo total será de : R$ " + df.format(resultadoRendimento) + "\n";
	}
}
