package Conta;

public abstract class Conta {
	private String nome;
	private String cpf;
	private String senha;
	private double saque;
	private double deposito;
	private double transferencia;
	
	public Conta() {	
	}
	public Conta(String nome, String cpf, String senha, double saque, double deposito, double transferencia) {	
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
	public void setSaque(double saque) {
		this.saque = saque;
	}
	
	public double getDeposito() {
		return deposito;
	}
	public void setDeposito(double deposito) {
		this.deposito = deposito;
	}
	
	public double getTransferencia() {
		return transferencia;
	}
	public void setTransferencia(double transferencia) {
		this.transferencia = transferencia;
	}
	
}
