package Menus;

import java.util.Scanner;

import Cliente.Cliente;
import Conta.Conta;

public class MenuLogin {

	public void MenuInicial() {
		MenuUsuario menuUsuario = new MenuUsuario();

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
		Cliente cliente = Cliente.mapaCliente.get(cpf);

		if (conta != null && cliente != null) {
			if (cliente.getSenha().equalsIgnoreCase(senha)) {
				System.out.println("Você está logado!");
				MenuOpcoes(conta, cliente);
			}
		} 
		while (conta == null || cliente == null) {
			
			System.out.println("Voce digitou cpf ou senha incorretos");
			
			System.out.println("Escreva o CPF: ");
			cpf = in.next();
			System.out.println("Escreva a Senha: ");
			senha = in.next();
			
			conta = Conta.mapaConta.get(cpf);
			cliente = Cliente.mapaCliente.get(cpf);
			
			if (conta != null && cliente != null) {
				if (cliente.getSenha().equalsIgnoreCase(senha)) {
					System.out.println("Você está logado!");
					MenuOpcoes(conta, cliente);
				}
			} 
		}
	}

	public void MenuOpcoes(Conta conta, Cliente cliente) {
		MenuUsuario menuUsuario = new MenuUsuario();
			menuUsuario.Menu(conta, cliente);
	}
}
