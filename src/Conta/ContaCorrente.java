package Conta;

public class ContaCorrente extends Conta{
	
		private static int numTransferencias;
		private static int numSaques;
		private static int numDepositos;

		public ContaCorrente( String tipo , String cpf, double saldo, String agencia) {
			super( tipo, cpf, saldo, agencia);
			
			
		}

		@Override
		public String toString() {
			return "**Tipo de Conta = " + tipo + "**\n" + super.toString();
		}
		
		@Override
		public String Sacar(double valor) {
			if (this.saldo < valor) {
				return "Saldo Insuficiente";
			} else {
				double novoSaldo = this.saldo - valor;
				this.saldo = novoSaldo;
				numSaques++;
				this.saldo = novoSaldo - 0.10;
				return "Saque Efetuado";
				
			}
		}
		
		@Override
		public void Depositar(double deposito) {
			this.saldo = saldo + deposito;
			numDepositos++;
			this.saldo = saldo - 0.10;
		}
		
		@Override
		public boolean Tranferir(Conta destino, double valor) {
			if (this.saldo >= valor) {
				this.saldo = this.saldo - valor;
				destino.saldo = destino.saldo + valor;
				numTransferencias++;
				this.saldo = saldo - 0.20;
				return true;
			} else {
				return false;				
			}
		}
		
		
		public String RelatorioContaCorrente() {
			return "O total gasto com Saque foi de: R$ " + numSaques * 0.10 + "\n" +
				"O total gasto com tranfêrencia foi de: R$ "+ numTransferencias * 0.20 + "\n" +
				"O total gasto com depositos foi de: R$ "+ numDepositos * 0.10;	
		}


		
		
		
		
		
}

