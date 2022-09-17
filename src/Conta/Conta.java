package Conta;

import java.util.HashMap;
import java.util.Map;

public abstract class Conta {
	protected String tipo;
	protected String cpf;
	protected double saldo;
	protected int agencia;

	public static Map<String, Conta> mapaConta = new HashMap<>();

	public Conta() {
	}

	public Conta(String tipo, String cpf, double saldo, int agencia) {
		super();
		this.tipo = tipo;
		this.cpf = cpf;
		this.saldo = saldo;
		this.agencia = agencia;
	}

	public String getTipo() {
		return tipo;
	}

	public String getCpf() {
		return cpf;
	}

	public double getSaldo() {
		return saldo;
	}

	public int getAgencia() {
		return agencia;
	}

	public boolean Sacar(double valor) {
		if (valor > 0) {
			if (this.saldo < valor) {
				return false;
			} else {
				this.saldo -= valor;
				return true;
			}
		}
		return false;
	}

	public boolean Depositar(double deposito) {
		if (deposito > 0) {
			this.saldo = this.saldo + deposito;
			return true;
		}
		return false;
	}

	public boolean Tranferir(Conta destino, double valor) {
		if (valor > 0) {
			if (this.saldo >= valor) {
				this.saldo = this.saldo - valor;
				destino.saldo = destino.saldo + valor;
				return true;
			} else {
				return false;
			}
		}
		return false;
	}
}
