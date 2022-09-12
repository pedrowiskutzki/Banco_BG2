package Main;

import Conta.ContaCorrente;
import Conta.ContaPoupanca;

public class SistemaInterno {

	public static void main(String[] args) {
		
		//criacao conta corrente
		ContaCorrente c1 = new ContaCorrente("Lucas", "05397119342", "1234",1400.50, "Conta Corrente");
		System.out.println(c1.toString());
		c1.Depositar(10.00);
		c1.Depositar(10.00);
		System.out.printf("Saldo : R$ %.2f %n", c1.getSaldo());
		System.out.println(c1.Sacar(410.50));
		System.out.println(c1.Sacar(50.00));
		System.out.printf("Saldo : R$ %.2f %n", c1.getSaldo());
		
		// criacao conta poupanca
		ContaPoupanca p1 = new ContaPoupanca("Pedro", "1551515442", "4321",500.50, "Conta Poupanca");
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
	}

}
