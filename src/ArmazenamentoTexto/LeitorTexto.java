package ArmazenamentoTexto;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

import Cliente.Cliente;
import Conta.Conta;
import Conta.ContaCorrente;
import Conta.ContaPoupanca;
import Funcionarios.Diretor;
import Funcionarios.Gerente;
import Funcionarios.Presidente;

public class LeitorTexto {

	public Map<String, Conta> leituratexto() {
		String read = "C:\\Serratec2022.2\\Java\\Trabalho Final Java\\Banco_Grupo2\\src\\TESTE.txt";
		try (BufferedReader re = new BufferedReader(new FileReader(read))) {

			String line = re.readLine();
			while (line != null) {

				String[] teste = line.split(";");

				if (teste[0].equals("CLIENTE")) 
				{	
					Cliente cl1 = new Cliente(teste[0], teste[1], teste[2], teste[3]);
					Cliente.mapaCliente.put(cl1.getCpf(), cl1);
				}	
				else if (teste[0].equals("GERENTE")) {
					Gerente g1 = new Gerente(teste[0], teste[1],teste[2],teste[3], Integer.parseInt(teste[4]));
					Cliente.mapaCliente.put(g1.getCpf(),g1);
				}
				else if (teste[0].equals("DIRETOR")) {
					Diretor d1 = new Diretor(teste[0], teste[1],teste[2],teste[3], Integer.parseInt(teste[4]));
					Cliente.mapaCliente.put(d1.getCpf(), d1);
				}
				else if (teste[0].equals("PRESIDENTE")) {
					Presidente pr1 = new Presidente(teste[0], teste[1],teste[2],teste[3], Integer.parseInt(teste[4]));
					Cliente.mapaCliente.put(pr1.getCpf(), pr1);
				}			
				else if (teste[0].equals("CONTACORRENTE")) 
				{
					ContaCorrente c1 = new ContaCorrente(teste[0], teste[1],Double.parseDouble(teste[2]),Integer.parseInt(teste[3]));
					Conta.mapaConta.put(c1.getCpf(), c1);
				}
				else if (teste[0].equals("CONTAPOUPANCA")) 
				{
					ContaPoupanca p1 = new ContaPoupanca(teste[0], teste[1],Double.parseDouble(teste[2]),Integer.parseInt(teste[3]));
					Conta.mapaConta.put(p1.getCpf(), p1);
				} else {
					System.out.println("Erro na Leitura");
				}

				line = re.readLine();
			}
		} catch (IOException o) {
			System.out.println("Error :" + o.getMessage());
		}
		return Conta.mapaConta;
	}

}