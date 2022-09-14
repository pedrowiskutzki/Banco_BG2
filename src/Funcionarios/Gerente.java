package Funcionarios;

import java.text.DecimalFormat;

import Conta.Conta;
import Conta.ContaCorrente;
import Conta.ContaPoupanca;

public class Gerente extends Funcionario {
	
	private static int numTransferencias;
	private static int numSaques;
	private static int numDepositos;
	private int quantMeses;
	private double rendimento;

	public Gerente() {
		super();
	}
	public Gerente(String cargo, String tipo , String nome, String cpf, String senha, double saldo, String agencia) {
		super(cargo, tipo, nome, cpf, senha, saldo, agencia);
		
	}

	@Override
	public String Sacar(double valor) {
		if (this.saldo < valor) {
			return "Saldo Insuficiente";
		} else {
			double novoSaldo = this.saldo - valor;
			this.saldo = novoSaldo;
			numSaques++;
			this.saldo = novoSaldo - 0.10;
			return "Saque Efetuado";
		}
	}

	@Override
	public void Depositar(double deposito) {
		this.saldo = saldo + deposito;
		numDepositos++;
		this.saldo = saldo - 0.10;
	}

	@Override
	public void Tranferir(Conta destino, double valor) {
		if (this.saldo >= valor) {
			this.saldo = this.saldo - valor;
			double s = destino.getSaldo();
			s = destino.getSaldo() + valor;
			numTransferencias++;
			this.saldo = saldo - 0.20;
		} else {
			System.out.println("Não há saldo suficiente para transferência");
		}

	}

	public String rendimentoPoupanca(int quantMeses) {
		this.quantMeses = quantMeses;
		double valor;
		valor = (float) quantMeses * (float) rendimento;
		double n = (valor / 100) * getSaldo();
		DecimalFormat df = new DecimalFormat("0.00");
		double resultadoRendimento = getSaldo() + n;
		return "\nEm " + quantMeses + " meses você tera um rendimento de : R$ " + df.format(n)
				+ "\nSeu saldo total sera de : R$ " + df.format(resultadoRendimento);

	}
}
