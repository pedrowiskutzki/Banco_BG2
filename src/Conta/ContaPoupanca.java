package Conta;

import java.text.DecimalFormat;

public class ContaPoupanca extends Conta {
	
	private int quantMeses;
	private double rendimento = 0.5;
	private double depositoRendimento;

	public ContaPoupanca( String tipo ,  String cpf, double saldo, int agencia ) {
		super( tipo, cpf, saldo, agencia);
	}
		
	public String rendimentoPoupanca(int quantMeses, double depositoRendimento) {
			this.quantMeses = quantMeses;
			double valor;
			valor = (float)quantMeses * (float)rendimento;
			double n = (valor/100)*depositoRendimento;
			DecimalFormat df = new DecimalFormat("0.00");
			double resultadoRendimento = depositoRendimento + n;
			return  "\n*************Simulação Rendimento***************" + "\nSe você aplicar: R$ " + depositoRendimento + "\nEm " + quantMeses + " meses você tera um rendimento de : R$ " 
					+ df.format(n) + "\nSeu saldo total sera de : R$ " + df.format(resultadoRendimento) ;
	}
	
	
	@Override
	public String toString() {
		return "**Tipo de Conta = " + tipo + "**\n" + super.toString();
	}
	
		
}
