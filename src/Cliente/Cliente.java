package Cliente;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import Conta.Conta;

public class Cliente extends Conta {
	
	private String nome;
	private String cpf;
	private String senha;
	private String cargo;

	public static Map<String, Cliente> mapaCliente = new HashMap<>();
	public static TreeMap<String, Cliente> mapaClienteAlfabetico = new TreeMap<>();
	
	
	public Cliente(String cargo, String nome, String cpf, String senha) {
		super();
		this.cargo = cargo;
		this.nome = nome;
		this.cpf = cpf;
		this.senha = senha;
		
	}
	
	public Cliente(String cpf, String senha) {
		super();
		this.cpf = cpf;
		this.senha = senha ;
	}

	public CharSequence informacoes() {
		Conta conta = Conta.mapaConta.get(this.cpf);
		return "Nome: " + getNome() + ", CPF: " + getCpf() + ", AG: "+ conta.getAgencia() + "\n";  
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

