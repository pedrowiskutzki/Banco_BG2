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
	public Conta( String tipo, String cpf, double saldo, int agencia) {	
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
		if (this.saldo < valor) {
			return false;
		} else {
			double novoSaldo = this.saldo - valor;
			this.saldo = novoSaldo;
			return true;		
		}
	}	
	public void Depositar(double deposito) {
		this.saldo = saldo + deposito;
	}
	public boolean Tranferir(Conta destino, double valor) {
		if (this.saldo >= valor) {
			this.saldo = this.saldo - valor;
			destino.saldo = destino.saldo + valor;
			return true;
		} else {
			return false;
		}
	}
}
