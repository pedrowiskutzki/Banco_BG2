package Funcionarios;

import Conta.Conta;

public abstract class Funcionario extends Conta{
	private String nome;
	protected String cpf;
	protected String senha;
	private String cargo;
	
	
	public Funcionario(String nome, String cpf, String senha, String cargo) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.senha = senha;
		this.cargo = cargo;
		}

		public Funcionario(String cpf, String senha) {
			super();
			this.cpf = cpf;
			this.senha = senha;
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