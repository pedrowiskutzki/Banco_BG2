package Conta;

public class ContaCorrente extends Conta{

		private String tipoConta;
		
		
	public ContaCorrente() {
		super();
	}
	
	public ContaCorrente(String tipoConta) {
	 	super(getNome(), cpf, senha, saque, deposito, transferencia);
	 	
	}
