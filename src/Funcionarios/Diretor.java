package Funcionarios;

public class Diretor extends Gerente {
	
	private String TIPO = "DIRETOR";

	public Diretor(String nome, String cpf, String senha, String cargo, String agencia) {
		super(nome, cpf, senha, cargo, agencia);
		
	}

	public Diretor(String cpf, String senha) {
		super(cpf, senha);
		
	}
}
