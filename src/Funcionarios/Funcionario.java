package Funcionarios;

import Cliente.Cliente;

public abstract class Funcionario extends Cliente {

	public Funcionario(String nome, String cpf, String senha, String cargo) {
		super(nome, cpf, senha, cargo);

	}

};