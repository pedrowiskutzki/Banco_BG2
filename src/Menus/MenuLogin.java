package Menus;

import java.io.IOException;
import java.util.Scanner;

import Cliente.Cliente;
import Conta.Conta;

public class MenuLogin {

	public void MenuInicial() throws IOException {
		MenuUsuario menuUsuario = new MenuUsuario();

		System.out.println("====================================================");
		System.out.println("||              Bem Vindo ao seu Banco            ||");
		System.out.println("||          Banco BG2 - Sempre ao seu lado        ||");
		System.out.println("====================================================");
		System.out.println("");

		Scanner in = new Scanner(System.in);
		System.out.println("====================Digite o CPF====================");
		String cpf = in.next();
		System.out.println("===================Digite a Senha===================");
		String senha = in.next();
		System.out.println("\n \n \n \n");

		Conta conta = Conta.mapaConta.get(cpf);
		Cliente cliente = Cliente.mapaCliente.get(cpf);

		if (conta != null && cliente != null) {
			if (cliente.getSenha().equalsIgnoreCase(senha)) {
				System.out.println("Você está logado!");
				MenuOpcoes(conta, cliente);
			}
		} 
		while (conta == null || cliente == null || !cliente.getSenha().equalsIgnoreCase(senha)) {
			
			System.out.println("Voce digitou cpf ou senha incorretos");
			
			System.out.println("====================Digite o CPF====================");
			cpf = in.next();
			System.out.println("===================Digite a Senha===================");
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

	public void MenuOpcoes(Conta conta, Cliente cliente) throws IOException {
		MenuUsuario menuUsuario = new MenuUsuario();
			menuUsuario.Menu(conta, cliente);
	}
}
