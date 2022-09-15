package Funcionarios;

public class Gerente extends Funcionario {
	
	private int agencia;

	public Gerente( String cargo, String nome, String cpf, String senha, int agencia) {
		super(cargo, nome, cpf, senha );
		this.agencia = agencia;
	}

	public int getAgencia() {
		return agencia;
	}

}
