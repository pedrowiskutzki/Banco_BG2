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
			System.out.println("DIGITE 1 PARA TRANSFERÊNCIA");
			System.out.println("DIGITE 2 PARA DEPÓSITO");
			System.out.println("DIGITE 3 PARA SAQUE");

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
						System.out.println("Transfêrencia não realizada");
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
				break;
			case 3:
				System.out.println("Qual o valor do saque ?");
				break;
			default:
				System.out.println("Você escolheu uma opção inexistente.");
			}
			break;
		case 2:
			System.out.println("DIGITE 1 PARA RELATORIO DE CONTA CORRENTE");
			System.out.println("DIGITE 2 PARA RELATÓRIO DE CONTA CONTA POUPANCA");
			System.out.println("DIGITE 3 PARA RELATÓRIO DE CONTA CONTAS DA MESMA AGENCIA");

			opcao = sc.nextInt();

			switch (opcao) {
			case 1:
				break;
			case 2:
				break;
			case 3:
				break;
			default:
				System.out.println("Você escolheu uma opção inexistente.");
			}
		default:
			System.out.println("Você escolheu uma opção inexistente.");
		}
	}

//	public  void menuDiretor(Conta conta) {
//		
//		System.out.println("====================================================");
//		System.out.println("||               Bem Vindo ao Menu                ||");
//		System.out.println("||                    DIRETOR                     ||");
//		System.out.println("====================================================");
//		System.out.println("");
//
//		System.out.println("Sr. Diretor, você deseja realizar o relatório?");
//		System.out.println("1 - Para sim || 2 - Para não");
//		int opcao = sc.nextInt();
//		if(opcao == 1) {
//			//fazer relatorio
//		}else if(opcao ==2 ){
//			System.out.println("Obrigado por usar o progama!");
//		}else {
//			System.out.println("Opção não reconhecida!");
//		}
//	}
//
//	public  void menuPresidente(Conta conta) {
//		
//		System.out.println("====================================================");
//		System.out.println("||               Bem Vindo ao seu Menu            ||");
//		System.out.println("||                  Sr.PRESIDENTE                 ||");
//		System.out.println("====================================================");
//		System.out.println("");
//		
//		int opcao = sc.nextInt();
//		
//		switch(opcao){
//		case 1:
//			System.out.println("so teste");
//			break;
//		}
//	}
//
//	public void menuCliente(Conta conta) {
		
}

