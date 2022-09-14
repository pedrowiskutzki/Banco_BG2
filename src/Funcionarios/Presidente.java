package Funcionarios;

public class Presidente extends Diretor{

	private String TIPO = "PRESIDENTE";

	public Presidente(String nome, String cpf, String senha, String cargo, String agencia) {
		super(nome, cpf, senha, cargo, agencia);
	}

	public Presidente(String cpf, String senha) {
		super(cpf, senha);
	}
}
