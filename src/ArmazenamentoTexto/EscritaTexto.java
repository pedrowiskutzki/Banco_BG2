package ArmazenamentoTexto;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import Conta.Conta;
import Conta.ContaCorrente;

public class EscritaTexto {

	final static String BASIC_PATH = "../temp/";
	final static String EXTENSAO = ".txt";

    public void ComprovanteSaque(Conta conta, double valorSaque) throws IOException {
        
    	String read = BASIC_PATH + "Transacoes" + EXTENSAO;
    	BufferedWriter buffWrite = new BufferedWriter(new FileWriter(read, true));
        		
        String linha = "===== SAQUE =====";
        Scanner in = new Scanner(System.in);

        buffWrite.append(linha + "\n");

        linha = "DADOS CONTA";
        buffWrite.append(linha + "\n");
        
        linha = "CPF: " + conta.getCpf() ;
        buffWrite.append(linha + "\n");

        linha = "AGENCIA: " + conta.getAgencia();
        buffWrite.append(linha + "\n");
        
        linha = "VALOR RETIRADO: " + valorSaque;
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
    	
        String linha = "===== DEPÓSITO =====";
        Scanner in = new Scanner(System.in);

        buffWrite.append(linha + "\n");

        linha = "DADOS CONTA";
        buffWrite.append(linha + "\n");
        
        linha = "CPF: " + conta.getCpf() ;
        buffWrite.append(linha + "\n");

        linha = "AGENCIA: " + conta.getAgencia();
        buffWrite.append(linha + "\n");
        
        linha = "VALOR DEPOSITADO: " + valorDeposito;
        buffWrite.append(linha + "\n");
        
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        buffWrite.append(dtf.format(LocalDateTime.now()) + "\n");
        
        linha = "==========";
        buffWrite.append(linha + "\n");        

        buffWrite.close();
    }
    
    public void ComprovanteTransferencia(Conta conta, double valorTransferencia, Conta contaDestino) throws IOException {
        
    	String read = BASIC_PATH + "Transacoes" + EXTENSAO;
    	BufferedWriter buffWrite = new BufferedWriter(new FileWriter(read, true));
    	
        String linha = "===== TRANSFERÊNCIA =====";
        Scanner in = new Scanner(System.in);

        buffWrite.append(linha + "\n");

        linha = "DADOS CONTA REMETENTE";
        buffWrite.append(linha + "\n");
        
        linha = "CPF: " + conta.getCpf() ;
        buffWrite.append(linha + "\n");

        linha = "AGENCIA: " + conta.getAgencia();
        buffWrite.append(linha + "\n");
        
        linha = "VALOR TRANSFERIDO: " + valorTransferencia;
        buffWrite.append(linha + "\n");
        
        linha = "DADOS CONTA DESTINATÁRIO";
        buffWrite.append(linha + "\n");
        
        linha = "CPF: " + contaDestino.getCpf() ;
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
	    
      	buffWrite.append("Relatorio CPF = " + conta.getCpf()+"\n");
      	
      	buffWrite.append( "O total gasto com Saque foi de: R$ " + conta.getNumSaques() * 0.10 + "\n" +
			"O total gasto com transfêrencia foi de: R$ "+ conta.getNumTransferencias() * 0.20 + "\n" +
			"O total gasto com depositos foi de: R$ "+ conta.getNumDepositos() * 0.10 + "\n" + 
			"Para cada saque é cobrado o valor de 10 centavos\nPara cada depósito é cobrado o valor de 10 centavos\nPara cada transferência é cobrado o valor de 20 centavos\n");	
			
        
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        buffWrite.append(dtf.format(LocalDateTime.now()) + "\n");
        
        
	    linha = "====================================";
	    buffWrite.append(linha + "\n");
	        
	    buffWrite.close();		  				
	}
}


