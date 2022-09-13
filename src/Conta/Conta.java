package Conta;

import java.util.HashMap;
import java.util.Map;

public abstract class Conta {
	protected String nome;
	protected String cpf;
	protected String senha;
	protected double saldo;

	public static Map<String, Conta> mapaConta = new HashMap<>();
	
	
	public Conta() {	
	}
	public Conta(String nome, String cpf, String senha, double saldo) {	
		 super();
		 this.nome = nome;
		 this.cpf = cpf;
		 this.senha = senha;
		 this.saldo = saldo;
	}
	
	public String getNome() {
		return nome;
	}
	
	
	public String getCpf() {
		return cpf;
	}
	
	
	public String getSenha() {
		return senha;
	}
	
	public double getSaldo() {
		return saldo;
	}
	
	public String Sacar(double valor) {
		if (this.saldo < valor) {
			return "Saldo Insuficiente";
		} else {
			double novoSaldo = this.saldo - valor;
			this.saldo = novoSaldo;
			return "Saque Efetuado";
			
		}
	}
		
	public void Depositar(double deposito) {
		this.saldo = saldo + deposito;
	}
	
	public void Tranferir(Conta destino, double valor) {
		if (this.saldo >= valor) {
			this.saldo = this.saldo - valor;
			destino.saldo = destino.saldo + valor;
		} else {
			System.out.println("Não há saldo suficiente para transferência");
		}
	}
	
	@Override
	public String toString() {
		return "[Nome = " + nome + ", CPF = " + cpf + ", Saldo = " + saldo + "]";
	}	
}
