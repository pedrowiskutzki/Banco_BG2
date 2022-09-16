package Conta;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ContaCorrente extends Conta{
	
		private static int numTransferencias;
		private static int numSaques;
		private static int numDepositos;
		
		final static String BASIC_PATH = "../temp/";
		final static String EXTENSAO = ".txt";

		public ContaCorrente( String tipo , String cpf, double saldo, int agencia) {
			super( tipo, cpf, saldo, agencia);		
		}
		
		

		public static int getNumTransferencias() {
			return numTransferencias;
		}



		public static int getNumSaques() {
			return numSaques;
		}



		public static int getNumDepositos() {
			return numDepositos;
		}

		@Override
		public boolean Sacar(double valor) {
			if (this.saldo < valor) {
				return false;
			} else {
				double novoSaldo = this.saldo - valor;
				this.saldo = novoSaldo;
				numSaques++;
				this.saldo = novoSaldo - 0.10;
				return true;
				
			}
		}
		
		@Override
		public boolean Depositar(double deposito) {
			if(deposito > 0) {
				this.saldo = saldo + deposito;
				numDepositos++;
				this.saldo = saldo - 0.10;
				return true;
			}
			return false;
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
		
}

