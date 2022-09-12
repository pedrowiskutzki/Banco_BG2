package Conta;

public class ContaPoupanca extends Conta {

	private String tipo;

	public ContaPoupanca(String nome, String cpf, String senha, double saldo,String tipo ) {
		super(nome, cpf, senha, saldo);
		this.tipo = tipo;
		
	}

	@Override
	public String toString() {
		return "**Tipo de Conta = " + tipo + "**\n" + super.toString();
	}
	
		
}
