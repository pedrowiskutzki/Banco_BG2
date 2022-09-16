package Menus;

import java.io.IOException;
import java.util.Scanner;

import ArmazenamentoTexto.EscritaTexto;
import Cliente.Cliente;
import Conta.Conta;
import Conta.ContaCorrente;
import Conta.ContaPoupanca;
import MenuEnum.EnumConta;
import MenuEnum.EnumFuncionario;

public class MenuUsuario {
	static Scanner sc = new Scanner(System.in);
	MenuLogin menuLogin = new MenuLogin();
	EscritaTexto escritaTexto = new EscritaTexto();

	public void Menu(Conta conta, Cliente cliente) throws IOException {

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
		System.out.println("=======================DIGITE=======================");
		System.out.println(" 1 - PARA REALIZAR SAQUE / TRANSFERÊNCIA / DEPÓSITO");
		System.out.println(" 2 - PARA VERIFICAR RELATORIOS");

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
						System.out.println("***Transferência realizada com sucesso!***");
						escritaTexto.ComprovanteTransferencia(conta, valor, contaDestino);
					} else {
						System.out.println("***Saldo insuficiente***");
					}
				} else {
					System.out.println("***Esta conta não existe***");
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
				boolean depositou = conta.Depositar(valorDeposito);
				if(depositou) {
					System.out.println("***Depósito realizado com sucesso!***");
					escritaTexto.ComprovanteDeposito(conta, valorDeposito);
				}else {
					System.out.println("***Depósito não realizado!***");
				}
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
				boolean sacou = conta.Sacar(valorSaque);
				if (sacou) {
					escritaTexto.ComprovanteSaque(conta, valorSaque);
					System.out.println("***Saque Efetuado Com Sucesso***");
				} else {
					System.out.println("***Saldo Insuficiente***");
				}
				System.out.println("1 - Para sim || 2 - Para não");
				int si = sc.nextInt();
				if (si == 1) {
					menuLogin.MenuOpcoes(conta, cliente);
				} else {
					menuLogin.MenuInicial();
				}
				break;
			default:
				System.out.println("***Você escolheu uma opção inexistente***");
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

	public void MenuRelatorio(int cargo, Conta conta, Cliente cliente) throws IOException {
		System.out.println("=======================DIGITE=======================");
		if (conta.getTipo().equalsIgnoreCase(EnumConta.CONTACORRENTE.getNome())) {
			System.out.println(" 1 - Para receber o relatório de tributação");
						
		} else {
			System.out.println(" 1 - Para receber opção de rendimento da Poupança");
		}
		if (cargo > 1) {
			System.out.println(" 2 - Relatório  numero de Contas");
		}
		if (cargo > 2) {
			System.out.println(" 3 - Relatório com as informações de Nome, CPF e Agência");
		}
		if (cargo > 3) {
			System.out.println(" 4 - Relatório com valor Total saldo");
		}
		System.out.println(" 5 - Para Sair");

		int opcao2 = sc.nextInt();
		switch (opcao2) {
		case 1: 
			if (conta.getTipo().equalsIgnoreCase(EnumConta.CONTACORRENTE.getNome())) {
				ContaCorrente contaCorrente = (ContaCorrente) conta;
				escritaTexto.RelatorioContaCorrente(contaCorrente);
				System.out.println("Relatório Gerado!");
				
				System.out.println("Você deseja fazer outra operação?");
				System.out.println("1 - Para sim || 2 - Para não");
				int sim = sc.nextInt();
				if (sim == 1) {
					menuLogin.MenuOpcoes(conta, cliente);
				} else {
					menuLogin.MenuInicial();
				}
			} else {
				ContaPoupanca contaPoupanca = (ContaPoupanca) conta;
				System.out.println("Digite o valor da sua simulação: ");
				double valorSimulado = sc.nextDouble();
				System.out.println("Digite quantos meses deseja fazer a simulação: ");
				int mesesSimulado = sc.nextInt();
				escritaTexto.rendimentoPoupanca(contaPoupanca,mesesSimulado,valorSimulado);
				System.out.println("Rendimento Gerado!");
				
				System.out.println("Você deseja fazer outra operação?");
				System.out.println("1 - Para sim || 2 - Para não");
				int sim = sc.nextInt();
				if (sim == 1) {
					menuLogin.MenuOpcoes(conta, cliente);
				} else {
					menuLogin.MenuInicial();
				}
			}
			
			break;
		case 2:
			escritaTexto.numTotalContas(conta, cliente);
			System.out.println("Rendimento Gerado!");			
			
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
			escritaTexto.infos();
			System.out.println("Rendimento Gerado!");	
			
			System.out.println("Você deseja fazer outra operação?");
			System.out.println("1 - Para sim || 2 - Para não");
			sim = sc.nextInt();
			if(sim==1) {
				menuLogin.MenuOpcoes(conta, cliente);
			}else {
				menuLogin.MenuInicial();				}
			break;
		case 4:
			double capital = 0;
			for( String cpf : Conta.mapaConta.keySet()) {
				capital += Conta.mapaConta.get(cpf).getSaldo();
			}System.out.printf("Total de capital armazenado no banco %.2f\n", capital);
			System.out.println("Você deseja fazer outra operação?");
			System.out.println("1 - Para sim || 2 - Para não");
			sim = sc.nextInt();
			if(sim==1) {
				menuLogin.MenuOpcoes(conta, cliente);
			}else {
				menuLogin.MenuInicial();				}
			break;
		default: 
			menuLogin.MenuOpcoes(conta, cliente);
			
		}

	}
}
