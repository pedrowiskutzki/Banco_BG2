package Conta;

public abstract class Conta {
	protected String nome;
	protected String cpf;
	protected String senha;
	protected double saldo;
	private double saque;
	private double deposito;
	private double transferencia;
	
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
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public double getSaque() {
		return saque;
	}
	public void Saque(double saque) {
		this.saldo = saldo - saque;
	}
	
	public double getDeposito() {
		return deposito;
	}
	
	public void Deposito(double deposito) {
		this.saldo = saldo + deposito;
	}
	
	public double getTransferencia() {
		return transferencia;
	}
	public void setTransferencia(double transferencia) {
		this.transferencia = transferencia;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	@Override
	public String toString() {
		return "[Nome = " + nome + ", CPF = " + cpf + ", Saldo = " + saldo + "]";
	}
	
	
}
