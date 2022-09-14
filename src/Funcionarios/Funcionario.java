package Funcionarios;

import Conta.Conta;

public abstract class Funcionario extends Conta{
	
	public Funcionario() {
		super();
	}
	public Funcionario(String cargo, String tipo , String nome, String cpf, String senha, double saldo, String agencia) {
		super(cargo, tipo, nome, cpf, senha, saldo, agencia);	
		
		}

	public String getAgencia() {
		return agencia;
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
	
}
;