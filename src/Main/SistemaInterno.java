package Main;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import Cliente.Cliente;
import Conta.Conta;
import Conta.ContaCorrente;
import Conta.ContaPoupanca;
import Funcionarios.Diretor;
import Funcionarios.Funcionario;
import Funcionarios.Gerente;
import Funcionarios.Presidente;

public class SistemaInterno {
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		
		//criacao conta corrente
		ContaCorrente c1 = new ContaCorrente("Lucas", "05397119342", "1234",1400.50, "Conta Corrente");
		Conta.mapaConta.put(c1.getCpf(), c1);
		
		// criacao conta poupanca
		ContaPoupanca p1 = new ContaPoupanca("Pedro", "1551515442", "4321",500.50, "Conta Poupanca");
		Conta.mapaConta.put(p1.getCpf(), p1);
		
		// criacao gerente
		Gerente g1 = new Gerente("Bernardo","12345678910","9876","Gerente","0005");
		Conta.mapaConta.put(g1.getCpf(), g1);
		
		// criacao diretor
		Diretor d1 = new Diretor("Bruna","12345612","987536","Diretor","0002");
		Conta.mapaConta.put(d1.getCpf(), d1);
		
		// criacao presidente
		Presidente b1 = new Presidente("Raquel","51535612","95136","Presidente","0003");
		Conta.mapaConta.put(b1.getCpf(), b1);
		
		Scanner in = new Scanner(System.in);
		System.out.println("Escreva o CPF: ");
		String cpf = in.next();
		System.out.println("Escreva a Senha: ");
		String senha = in.next();
		Conta conta = Conta.mapaConta.get(cpf);
	
		if(conta != null) {		
			if(conta.getSenha().equalsIgnoreCase(senha)) {
				System.out.println("PASSOU");
			}else
				System.out.println("Voce digitou cpf ou senha incorretos");
		}else
			System.out.println("Voce digitou cpf ou senha incorretos");
	}
}
