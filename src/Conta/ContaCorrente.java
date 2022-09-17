package Conta;

import java.text.DecimalFormat;

public class ContaCorrente extends Conta {

	private int numTransferencias;
	private int numSaques;
	private int numDepositos;

	DecimalFormat df = new DecimalFormat("0.00");

	public ContaCorrente(String tipo, String cpf, double saldo, int agencia) {
		super(tipo, cpf, saldo, agencia);
	}

	public int getNumTransferencias() {
		return numTransferencias;
	}

	public int getNumSaques() {
		return numSaques;
	}

	public int getNumDepositos() {
		return numDepositos;
	}

	public String getInfoContaCorrente() {
		return "O total gasto com Saque foi de: R$ " + df.format(this.numSaques * 0.10) + "\n"
				+ "O total gasto com transfêrencia foi de: R$ " + df.format(this.numTransferencias * 0.20) + "\n"
				+ "O total gasto com depósitos foi de: R$ " + df.format(this.numDepositos * 0.10) + "\n"
				+ "Para cada saque é cobrado o valor de 10 centavos\nPara cada depósito é cobrado o valor de 10 centavos\nPara cada transferência é cobrado o valor de 20 centavos\n";
	}

	@Override
	public boolean Sacar(double valor) {
		if (valor > 0) {
			if (this.saldo < valor) {
				return false;
			} else {
				this.saldo -= valor;
				numSaques++;
				this.saldo -= 0.10;
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean Depositar(double deposito) {
		if (deposito > 0) {
			this.saldo = saldo + deposito;
			numDepositos++;
			this.saldo = saldo - 0.10;
			return true;
		}
		return false;
	}

	@Override
	public boolean Tranferir(Conta destino, double valor) {
		if (this.saldo >= valor) {
			this.saldo = this.saldo - valor;
			destino.saldo = destino.saldo + valor;
			numTransferencias++;
			this.saldo = saldo - 0.20;
			return true;
		} else {
			return false;
		}
	}
}
