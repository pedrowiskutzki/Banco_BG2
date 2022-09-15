package Menus;

import java.util.Scanner;

import Cliente.Cliente;
import Conta.Conta;
import MenuEnum.EnumFuncionario;

public class MenuUsuario {
	static Scanner sc = new Scanner(System.in);
	MenuLogin menuLogin = new MenuLogin();

	public void Menu(Conta conta, Cliente cliente) {

		System.out.println("====================================================");
		System.out.println("||               Bem Vindo ao Menu                ||");
		if(cliente.getCargo().equalsIgnoreCase(EnumFuncionario.GERENTE.getNome()))
		{
			System.out.println("||                    GERENTE                     ||");
		}
		else if (cliente.getCargo().equalsIgnoreCase(EnumFuncionario.DIRETOR.getNome()))
		{
			System.out.println("||                    DIRETOR                     ||");	
		}
		else if (cliente.getCargo().equalsIgnoreCase(EnumFuncionario.PRESIDENTE.getNome()))
		{
			System.out.println("||                  Sr.PRESIDENTE                 ||");
		} else {			
			System.out.println("||             Sinta-se a vontade                 ||"); 
	    }
		System.out.println("====================================================");
		System.out.println("");
		System.out.println("DIGITE 1 PARA REALIZAR UM SAQUE, TRANSFERÊNCIA OU DEPÓSITO");
		System.out.println("DIGITE 2 PARA VERIFICAR RELATORIOS");

		int opcao = sc.nextInt();

		switch (opcao) {
		case 1:
			System.out.println("===========DIGITE===========");
			System.out.println(" 1 - PARA TRANSFERÊNCIA");
			System.out.println(" 2 - PARA DEPÓSITO");
			System.out.println(" 3 - PARA SAQUE");
			System.out.println("============================");

			opcao = sc.nextInt();

			switch (opcao) {
			case 1:
				System.out.println("Digite o CPF para a conta que deseja transferir: ");
				String cpf = sc.next();
				Conta contaDestino = Conta.mapaConta.get(cpf);
				if (contaDestino != null) {
					System.out.println("Digite o valor da transferência: ");
					Double valor = sc.nextDouble();
					boolean transferiu = conta.Tranferir(contaDestino, valor);
					if (transferiu) {
						System.out.println("Transferência realizada com sucesso!");	
					}else {
						System.out.println("Saldo insuficiente");
					}	
				}else {
					System.out.println("Esta conta não existe.");
				}
				System.out.println("Você deseja fazer outra operação?");
				System.out.println("1 - Para sim || 2 - Para não");
				int sim = sc.nextInt();
				if(sim==1) {
					menuLogin.MenuOpcoes(conta, cliente);
				}else {
					menuLogin.MenuInicial();				}
				break;
			case 2:
				System.out.println("Qual o valor do deposito ?" );
				double valorDeposito = sc.nextDouble();
				conta.Depositar(valorDeposito);
				System.out.println("Depósito realizado com sucesso!");
				System.out.println("Você deseja fazer outra operação?");
				System.out.println("1 - Para sim || 2 - Para não");
				int s = sc.nextInt();
				if(s==1) {
					menuLogin.MenuOpcoes(conta, cliente);
				}else {
					menuLogin.MenuInicial();				}
				break;
			case 3:
				System.out.println("Qual o valor do saque ?");
				double valorSaque = sc.nextDouble();
				System.out.println(conta.Sacar(valorSaque));
				System.out.println("1 - Para sim || 2 - Para não");
				int si = sc.nextInt();
				if(si==1) {
					menuLogin.MenuOpcoes(conta, cliente);
				}else {
					menuLogin.MenuInicial();				}			
				break;
			default:
				System.out.println("Você escolheu uma opção inexistente.");				
			}
			break;
		case 2:
			////////////////
		default:
			System.out.println("Você escolheu uma opção inexistente.");
		}
	}	
}

