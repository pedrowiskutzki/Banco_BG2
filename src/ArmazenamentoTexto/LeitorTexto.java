package ArmazenamentoTexto;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import Conta.Conta;
import Conta.ContaCorrente;
import Funcionarios.Funcionario;
import Funcionarios.Gerente;

public class LeitorTexto {
	
	public void leituratexto() {
	String read = "C:\\Serratec2022.2\\Java\\Trabalho Final Java\\Banco_Grupo2\\src\\TESTE.txt";
	try (BufferedReader re = new BufferedReader(new FileReader(read))){		
		
		String line = re.readLine();
		while(line != null) {
			
			String[] teste = line.split(";");
			// CONTA	
		
			if (teste[0].equals("CLIENTE")) {
				if(teste[1].equals("CONTACORRENTE")) {				
					ContaCorrente c1 = new ContaCorrente(teste[0], teste[1], teste[2], teste[3], teste[4], Double.parseDouble(teste[5]), teste[6]); 			
					Conta.mapaConta.put(c1.getCpf(), c1); 
				}if(teste[1].equals("CONTAPOUPANCA")) {
					ContaCorrente c1 = new ContaCorrente(teste[0], teste[1], teste[2], teste[3], teste[4], Double.parseDouble(teste[5]), teste[6]); 			
					Conta.mapaConta.put(c1.getCpf(), c1); }		
			}else {
				System.out.println("Erro na Leitura");}
			
			line = re.readLine();
		}
		}catch (IOException o) {
		System.out.println("Error :" + o.getMessage());
	}
}
}