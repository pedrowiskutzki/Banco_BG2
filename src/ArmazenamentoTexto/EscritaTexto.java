package ArmazenamentoTexto;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import Cliente.Cliente;
import Conta.Conta;
import Conta.ContaCorrente;
import Conta.ContaPoupanca;

public class EscritaTexto {

	final static String BASIC_PATH = "../temp/";
	final static String EXTENSAO = ".txt";

	public void ComprovanteSaque(Conta conta, double valorSaque) throws IOException {

		String read = BASIC_PATH + "Transacoes" + EXTENSAO;
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(read, true));

		DecimalFormat df = new DecimalFormat("0.00");
		String linha = "===== SAQUE =====";

		buffWrite.append(linha + "\n");

		linha = "DADOS CONTA";
		buffWrite.append(linha + "\n");

		linha = "CPF: " + conta.getCpf();
		buffWrite.append(linha + "\n");

		linha = "AGENCIA: " + conta.getAgencia();
		buffWrite.append(linha + "\n");

		linha = "VALOR RETIRADO R$" + df.format(valorSaque);
		buffWrite.append(linha + "\n");

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		buffWrite.append(dtf.format(LocalDateTime.now()) + "\n");

		linha = "==========";
		buffWrite.append(linha + "\n");

		buffWrite.close();
	}

	public void ComprovanteDeposito(Conta conta, double valorDeposito) throws IOException {

		String read = BASIC_PATH + "Transacoes" + EXTENSAO;
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(read, true));

		DecimalFormat df = new DecimalFormat("0.00");
		String linha = "===== DEPÓSITO =====";

		buffWrite.append(linha + "\n");

		linha = "DADOS CONTA";
		buffWrite.append(linha + "\n");

		linha = "CPF: " + conta.getCpf();
		buffWrite.append(linha + "\n");

		linha = "AGENCIA: " + conta.getAgencia();
		buffWrite.append(linha + "\n");

		linha = "VALOR DEPOSITADO R$" + df.format(valorDeposito);
		buffWrite.append(linha + "\n");

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		buffWrite.append(dtf.format(LocalDateTime.now()) + "\n");

		linha = "==========";
		buffWrite.append(linha + "\n");

		buffWrite.close();
	}

	public void ComprovanteTransferencia(Conta conta, double valorTransferencia, Conta contaDestino)
			throws IOException {

		String read = BASIC_PATH + "Transacoes" + EXTENSAO;
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(read, true));

		DecimalFormat df = new DecimalFormat("0.00");
		String linha = "===== TRANSFERÊNCIA =====";
		buffWrite.append(linha + "\n");

		linha = "DADOS CONTA REMETENTE";
		buffWrite.append(linha + "\n");

		linha = "CPF: " + conta.getCpf();
		buffWrite.append(linha + "\n");

		linha = "AGENCIA: " + conta.getAgencia();
		buffWrite.append(linha + "\n");

		linha = "VALOR TRANSFERIDO R$" + df.format(valorTransferencia);
		buffWrite.append(linha + "\n");

		linha = "DADOS CONTA DESTINATÁRIO";
		buffWrite.append(linha + "\n");

		linha = "CPF: " + contaDestino.getCpf();
		buffWrite.append(linha + "\n");

		linha = "AGENCIA: " + contaDestino.getAgencia();
		buffWrite.append(linha + "\n");

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		buffWrite.append(dtf.format(LocalDateTime.now()) + "\n");

		linha = "==========";
		buffWrite.append(linha + "\n");

		buffWrite.close();
	}

	public void RelatorioContaCorrente(ContaCorrente conta) throws IOException {
		String read = BASIC_PATH + "Relatorios Conta Corrente" + EXTENSAO;
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(read, true));

		String linha = "===== Relatorio Conta Corrente =====";
		buffWrite.append(linha + "\n");

		linha = "====================================";
		buffWrite.append(linha + "\n");

		buffWrite.append("Relatorio CPF = " + conta.getCpf() + "\n");

		buffWrite.append(conta.getInfoContaCorrente());

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		buffWrite.append(dtf.format(LocalDateTime.now()) + "\n");

		linha = "====================================";
		buffWrite.append(linha + "\n");

		buffWrite.close();
	}

	public void rendimentoPoupanca(ContaPoupanca conta, int quantMeses, double depositoRendimento) throws IOException {
		String read = BASIC_PATH + "Relatorios Conta Poupança" + EXTENSAO;
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(read, true));

		String linha = "===== Relatório Conta Poupança =====";
		buffWrite.append(linha + "\n");

		linha = "====================================";
		buffWrite.append(linha + "\n");

		buffWrite.append("Relatorio CPF = " + conta.getCpf() + "\n");

		buffWrite.append(conta.getInfoContaPoupanca(quantMeses, depositoRendimento));

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		buffWrite.append(dtf.format(LocalDateTime.now()) + "\n");

		linha = "====================================";
		buffWrite.append(linha + "\n");

		buffWrite.close();
	}

	public void numTotalContas(Conta conta, int totalNumConta) throws IOException {

		Cliente cliente = Cliente.mapaCliente.get(conta.getCpf());
		String read = BASIC_PATH + "Relatórios Num. Contas Agência" + EXTENSAO;
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(read, true));

		String linha = "===== Relatórios Num. Contas Agência =====";
		buffWrite.append(linha + "\n");

		linha = "====================================";
		buffWrite.append(linha + "\n");

		buffWrite.append("CPF do Gerenciador = " + conta.getCpf() + "\n");
		buffWrite.append("Agência = " + cliente.getAgencia() + "\n");

		buffWrite.append("O Número Total de Contas Administradas é de: " + totalNumConta + "\n");

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		buffWrite.append(dtf.format(LocalDateTime.now()) + "\n");

		linha = "====================================";
		buffWrite.append(linha + "\n");

		buffWrite.close();
	}

	public void infos(Conta conta) throws IOException {

		String read = BASIC_PATH + "Relatórios Informacoes Contas" + EXTENSAO;
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(read, true));

		String linha = "===== Relatórios Informacoes Contas =====";
		buffWrite.append(linha + "\n");

		linha = "====================================";
		buffWrite.append(linha + "\n");

		linha = "Relatorio CPF = " + conta.getCpf();
		buffWrite.append(linha + "\n");

		for (Cliente clienteAlf : Cliente.mapaClienteAlfabetico.values()) {
			buffWrite.append(clienteAlf.informacoes());
		}

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		buffWrite.append("\n" + dtf.format(LocalDateTime.now()) + "\n");

		linha = "====================================";
		buffWrite.append(linha + "\n");

		buffWrite.close();

	}

	public void valorTotalBanco(Conta conta, Double capital) throws IOException {

		String read = BASIC_PATH + "Relatório Valor Total Banco" + EXTENSAO;
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(read, true));

		String linha = "===== Relatório Valor Total Banco =====";
		buffWrite.append(linha + "\n");

		linha = "Relatorio CPF = " + conta.getCpf();
		buffWrite.append(linha + "\n");

		linha = "====================================";
		buffWrite.append(linha + "\n");
		DecimalFormat df = new DecimalFormat("0.00");
		buffWrite.append("Total de capital armazenado no banco: R$ " + df.format(capital) + "\n");

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		buffWrite.append("\n" + dtf.format(LocalDateTime.now()) + "\n");

		linha = "====================================";
		buffWrite.append(linha + "\n");

		buffWrite.close();
	}
}
