package Menus;

import java.util.Scanner;

import Cliente.Cliente;
import Conta.Conta;
import MenuEnum.EnumConta;
import MenuEnum.EnumFuncionario;

public class MenuUsuario {
	static Scanner sc = new Scanner(System.in);
	MenuLogin menuLogin = new MenuLogin();

	public void Menu(Conta conta, Cliente cliente) {

		System.out.println("====================================================");
		System.out.println("||               Bem Vindo ao Menu                ||");
		if (cliente.getCargo().equalsIgnoreCase(EnumFuncionario.GERENTE.getNome())) {
			System.out.println("||                    GERENTE                     ||");
		} else if (cliente.getCargo().equalsIgnoreCase(EnumFuncionario.DIRETOR.getNome())) {
			System.out.println("||                    DIRETOR                     ||");
		} else if (cliente.getCargo().equalsIgnoreCase(EnumFuncionario.PRESIDENTE.getNome())) {
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
					} else {
						System.out.println("Saldo insuficiente");
					}
				} else {
					System.out.println("Esta conta não existe.");
				}
				System.out.println("Você deseja fazer outra operação?");
				System.out.println("1 - Para sim || 2 - Para não");
				int sim = sc.nextInt();
				if (sim == 1) {
					menuLogin.MenuOpcoes(conta, cliente);
				} else {
					menuLogin.MenuInicial();
				}
				break;
			case 2:
				System.out.println("Qual o valor do deposito ?");
				double valorDeposito = sc.nextDouble();
				conta.Depositar(valorDeposito);
				System.out.println("Depósito realizado com sucesso!");
				System.out.println("Você deseja fazer outra operação?");
				System.out.println("1 - Para sim || 2 - Para não");
				int s = sc.nextInt();
				if (s == 1) {
					menuLogin.MenuOpcoes(conta, cliente);
				} else {
					menuLogin.MenuInicial();
				}
				break;
			case 3:
				System.out.println("Qual o valor do saque ?");
				double valorSaque = sc.nextDouble();
				System.out.println(conta.Sacar(valorSaque));
				System.out.println("1 - Para sim || 2 - Para não");
				int si = sc.nextInt();
				if (si == 1) {
					menuLogin.MenuOpcoes(conta, cliente);
				} else {
					menuLogin.MenuInicial();
				}
				break;
			default:
				System.out.println("Você escolheu uma opção inexistente.");
				menuLogin.MenuOpcoes(conta, cliente);
			}
			break;

		case 2:
			if (cliente.getCargo().equalsIgnoreCase(EnumFuncionario.CLIENTE.getNome())) {
				MenuRelatorio(EnumFuncionario.CLIENTE.getValor(), conta, cliente);
			} else if (cliente.getCargo().equalsIgnoreCase(EnumFuncionario.GERENTE.getNome())) {
				MenuRelatorio(EnumFuncionario.GERENTE.getValor(), conta, cliente);
			}

			else if (cliente.getCargo().equalsIgnoreCase(EnumFuncionario.DIRETOR.getNome())) {
				MenuRelatorio(EnumFuncionario.DIRETOR.getValor(), conta, cliente);
			}

			else if (cliente.getCargo().equalsIgnoreCase(EnumFuncionario.PRESIDENTE.getNome())) {
				MenuRelatorio(EnumFuncionario.PRESIDENTE.getValor(), conta, cliente);
			}
			break;
		default:
			System.out.println("Você escolheu uma opção inexistente.");
			menuLogin.MenuOpcoes(conta, cliente);
			break;
		}
	}

	public void MenuRelatorio(int cargo, Conta conta, Cliente cliente) {
		if (conta.getTipo().equalsIgnoreCase(EnumConta.CONTACORRENTE.getNome())) {
			System.out.println("Digite 1 para receber o relatorio de tributação");
		} else {
			System.out.println("Digite 1 para receber opção de rendimento");
		}
		if (cargo > 1) {
			System.out.println("Digite 2- Relatorio  numero de Contas");
		}
		if (cargo > 2) {
			System.out.println("Digite 3 - Relatório com as informações de Nome, CPF e Agência");
		}
		if (cargo > 3) {
			System.out.println("Digite 4 - Relatorio com valor Total saldo");
		}
		System.out.println("Digite 5 para Sair");

		int opcao2 = sc.nextInt();
		switch (opcao2) {
		case 1:
			break;
		case 2:
			System.out.println("Digite 2- Relatorio  numero de Contas");
			System.out.println("Você deseja fazer outra operação?");
			System.out.println("1 - Para sim || 2 - Para não");
			int sim = sc.nextInt();
			if (sim == 1) {
				menuLogin.MenuOpcoes(conta, cliente);
			} else {
				menuLogin.MenuInicial();
			}
			break;

		case 3:
			System.out.println("Digite 3 - Relatório com as informações de Nome, CPF e Agência");
			System.out.println("Você deseja fazer outra operação?");
			System.out.println("1 - Para sim || 2 - Para não");
			sim = sc.nextInt();
			if(sim==1) {
				menuLogin.MenuOpcoes(conta, cliente);
			}else {
				menuLogin.MenuInicial();				}
			break;
		case 4:
			System.out.println("Digite 4 - Relatorio com valor Total saldo");
			double capital = 0;
			for( Conta conta2 : Conta.mapaConta.values()) {
				capital += conta2.getSaldo();
			}System.out.printf("Total de capital armazenado no banco %2.f", capital);
			System.out.println("Você deseja fazer outra operação?");
			System.out.println("1 - Para sim || 2 - Para não");
			sim = sc.nextInt();
			if(sim==1) {
				menuLogin.MenuOpcoes(conta, cliente);
			}else {
				menuLogin.MenuInicial();				}
			break;
		}

	}
}
