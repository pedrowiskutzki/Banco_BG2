package Main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import ArmazenamentoTexto.LeitorTexto;
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
		
		LeitorTexto leitor = new LeitorTexto();
		leitor.leituratexto();
		
		System.out.println("====================================================");
		System.out.println("||              Bem Vindo ao seu Banco            ||");
		System.out.println("||          Banco BG2 - Sempre ao seu lado        ||");
		System.out.println("====================================================");
		System.out.println("");
		
		Scanner in = new Scanner(System.in);
		System.out.println("Escreva o CPF: ");
		String cpf = in.next();
		System.out.println("Escreva a Senha: ");
		String senha = in.next();
		
		Conta conta = Conta.mapaConta.get(cpf);
		
		if(conta != null) {		
			if(conta.getSenha().equalsIgnoreCase(senha)) {
				System.out.println("Você está logado!");
             }
			}else
				System.out.println("Voce digitou cpf ou senha incorretos");
		}
}

	
