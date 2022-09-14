package Cliente;

import java.util.HashMap;
import java.util.Map;

import Conta.Conta;

public class Cliente extends Conta {
	
	private String TIPO = "CLIENTE";
	
	private String nome;
	private String cpf;
	private String senha;
	private String cargo;

	public static Map<String, Cliente> mapaCliente = new HashMap<>();
	
	public Cliente(String nome, String cpf, String senha, String cargo) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.senha = senha;
	}
	
	public Cliente(String cpf, String senha) {
		super();
		this.cpf = cpf;
		this.senha = senha ;
	}

	

	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return this.cpf;
	}

	public String getSenha() {
		return this.senha;
	}

	public String getCargo() {
		return cargo;
	}
}

