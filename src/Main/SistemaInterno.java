package Main;

import Conta.ContaCorrente;
import Conta.ContaPoupanca;

public class SistemaInterno {

	public static void main(String[] args) {
		ContaCorrente c1 = new ContaCorrente("Lucas", "05397119342", "1234",1400.50, "Conta Corrente");
		System.out.println(c1.toString());
		c1.Deposito(10.00);
		System.out.println(c1.getSaldo());
		c1.Saque(410.50);
		System.out.println(c1.getSaldo());
		
		ContaPoupanca p1 = new ContaPoupanca("Pedro", "1551515442", "4321",500.50, "Conta Poupanca");
		System.out.println(p1.toString());
		p1.Deposito(60.00);
		System.out.println(p1.getSaldo());
		p1.Saque(300.50);
		System.out.println(p1.getSaldo());
	}

}
