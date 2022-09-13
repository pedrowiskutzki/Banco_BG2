package Funcionarios;

public abstract class Funcionario {
	private String nome;
	private String cpf;
	private String senha;
	private String cargo;
	
	
	public Funcionario(String nome, String cpf, String senha, String cargo) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.senha = senha;
		this.cargo = cargo;
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

	public String getCargo() {
		return cargo;
	}

	
}
;