package Main;

import java.util.Scanner;

import Conta.Conta;
import Conta.ContaCorrente;
import Conta.ContaPoupanca;
import Funcionarios.Gerente;

public class SistemaInterno {

	public static void main(String[] args) {
		
		//criacao conta corrente
		ContaCorrente c1 = new ContaCorrente("Lucas", "05397119342", "1234",1400.50, "Conta Corrente");
		Conta.mapaConta.put(c1.getCpf(), c1);
		System.out.println(c1.toString());
		c1.Depositar(10.00);
		c1.Depositar(10.00);
		System.out.printf("Saldo : R$ %.2f %n", c1.getSaldo());
		System.out.println(c1.Sacar(410.50));
		System.out.println(c1.Sacar(50.00));
		System.out.printf("Saldo : R$ %.2f %n", c1.getSaldo());
		
		// criacao conta poupanca
		ContaPoupanca p1 = new ContaPoupanca("Pedro", "1551515442", "4321",500.50);
		Conta.mapaConta.put(p1.getCpf(), p1);
		System.out.println(p1.toString());
		p1.Depositar(60.00);
		System.out.printf("Saldo : R$ %.2f %n", p1.getSaldo());
		System.out.println(p1.Sacar(600.00));
		System.out.printf("Saldo : R$ %.2f %n", p1.getSaldo());
		
		// tranferencia
		c1.Tranferir(p1, 400.00);
		System.out.printf("O saldo do " + c1.getNome() + " é de: R$ %.2f %n", c1.getSaldo());
		System.out.printf("O saldo do " + p1.getNome() + " é de: R$ %.2f %n", p1.getSaldo());
		
		//relatorio contacorrente
		System.out.printf(c1.RelatorioContaCorrente());
		
		//relatorio de Rendimento
		System.out.println(p1.rendimentoPoupanca(5));
		
		//Gerente
		Gerente g1 = new Gerente("Raquel", "12347859200", "1564", "Gerente", "001");
		System.out.println();
		
		Scanner in = new Scanner(System.in);
		System.out.println("Escreva algo: ");
		String cpf = in.next();
		String senha = in.next();
		Conta conta = Conta.mapaConta.get(cpf);
		
		if(conta != null) {
			if(conta.getSenha().equalsIgnoreCase(senha)) {
				System.out.println("PASSOU");
			}
		}
		
	}
}
