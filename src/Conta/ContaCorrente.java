package Conta;

public class ContaCorrente extends Conta{

		private String tipo;

		public ContaCorrente(String nome, String cpf, String senha, double saldo,String tipo ) {
			super(nome, cpf, senha, saldo);
			this.tipo = tipo;
			
		}

		@Override
		public String toString() {
			return "**Tipo de Conta = " + tipo + "**\n" + super.toString();
		}


		
		
		
		
		
}

