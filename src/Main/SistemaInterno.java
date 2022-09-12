package Main;

import Conta.ContaCorrente;

public class SistemaInterno {

	public static void main(String[] args) {
		ContaCorrente c1 = new ContaCorrente("Lucas", "05397119342", "1234",1400.50, "Conta Corrente");
		System.out.println(c1.toString());
		c1.Deposito(10.00);
		System.out.println(c1.getSaldo());
		c1.Saque(410.50);
		System.out.println(c1.getSaldo());
	}

}
