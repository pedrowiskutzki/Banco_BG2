package Funcionarios;

public class Gerente extends Funcionario {
	
	private int agencia;

	public Gerente( String cargo, String nome, String cpf, String senha, int agencia) {
		super(nome, cpf, senha, cargo);
		this.agencia = agencia;
	}

	public int getAgencia() {
		return agencia;
	}

}
