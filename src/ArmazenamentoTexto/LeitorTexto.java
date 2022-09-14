package ArmazenamentoTexto;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import Conta.Conta;
import Conta.ContaCorrente;
import Conta.ContaPoupanca;
import Funcionarios.Diretor;
import Funcionarios.Funcionario;
import Funcionarios.Gerente;
import Funcionarios.Presidente;

public class LeitorTexto {
	
	public void leituratexto() {
	String read = "C:\\Users\\fabri\\Documents\\Trabalho Final G2\\src\\TESTE.txt";
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
					ContaPoupanca p1 = new ContaPoupanca(teste[0], teste[1], teste[2], teste[3], teste[4], Double.parseDouble(teste[5]), teste[6]); 			
					Conta.mapaConta.put(p1.getCpf(), p1); }		
			}else if (teste[0].equals("FUNCIONARIO")){
					if(teste[1].equals("GERENTE")) {				
						Gerente g1 = new Gerente(teste[0], teste[1], teste[2], teste[3], teste[4], Double.parseDouble(teste[5]), teste[6]); 			
						Conta.mapaConta.put(g1.getCpf(), g1); 
					}if(teste[1].equals("DIRETOR")) {
						Diretor d1 = new Diretor(teste[0], teste[1], teste[2], teste[3], teste[4], Double.parseDouble(teste[5]), teste[6]); 			
						Conta.mapaConta.put(d1.getCpf(), d1); }	
					if(teste[1].equals("PRESIDENTE")) {
						Presidente pr1 = new Presidente(teste[0], teste[1], teste[2], teste[3], teste[4], Double.parseDouble(teste[5]), teste[6]); 			
						Conta.mapaConta.put(pr1.getCpf(), pr1); }	
			}else {
				System.out.println("Erro na Leitura");}
			
			line = re.readLine();
		}
		}catch (IOException o) {
		System.out.println("Error :" + o.getMessage());
	}
}
}