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
	
	final static String BASIC_PATH = "../temp/";
	final static String EXTENSAO = ".txt";

	public Map<String, Conta> leituratexto() {
		String read = BASIC_PATH + "LeitorDados" + EXTENSAO;
		try (BufferedReader re = new BufferedReader(new FileReader(read))) {

			String line = re.readLine();
			while (line != null) {

				String[] ler = line.split(";");

				if (ler[0].equals("CLIENTE")) 
				{	
					Cliente cl1 = new Cliente(ler[0], ler[1], ler[2], ler[3]);
					Cliente.mapaCliente.put(cl1.getCpf(), cl1);
					Cliente.mapaClienteAlfabetico.put(cl1.getNome(), cl1);
				}	
				else if (ler[0].equals("GERENTE")) {
					Gerente g1 = new Gerente(ler[0], ler[1],ler[2],ler[3], Integer.parseInt(ler[4]));
					Cliente.mapaCliente.put(g1.getCpf(),g1);
					Cliente.mapaClienteAlfabetico.put(g1.getNome(), g1);
				}
				else if (ler[0].equals("DIRETOR")) {
					Diretor d1 = new Diretor(ler[0], ler[1],ler[2],ler[3], Integer.parseInt(ler[4]));
					Cliente.mapaCliente.put(d1.getCpf(), d1);
					Cliente.mapaClienteAlfabetico.put(d1.getNome(), d1);
				}
				else if (ler[0].equals("PRESIDENTE")) {
					Presidente pr1 = new Presidente(ler[0], ler[1],ler[2],ler[3], Integer.parseInt(ler[4]));
					Cliente.mapaCliente.put(pr1.getCpf(), pr1);
					Cliente.mapaClienteAlfabetico.put(pr1.getNome(), pr1);
				}			
				else if (ler[0].equals("CONTACORRENTE")) 
				{
					ContaCorrente c1 = new ContaCorrente(ler[0], ler[1],Double.parseDouble(ler[2]),Integer.parseInt(ler[3]));
					Conta.mapaConta.put(c1.getCpf(), c1);
				}
				else if (ler[0].equals("CONTAPOUPANCA")) 
				{
					ContaPoupanca p1 = new ContaPoupanca(ler[0], ler[1],Double.parseDouble(ler[2]),Integer.parseInt(ler[3]));
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