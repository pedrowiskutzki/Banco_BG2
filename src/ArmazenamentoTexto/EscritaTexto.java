package ArmazenamentoTexto;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.Scanner;

import Conta.Conta;

public class EscritaTexto {

    public void ComprovanteSaque(Conta conta, double valorSaque) throws IOException {
        
    	BufferedWriter buffWrite = new BufferedWriter(new FileWriter("C:/Users/Residente20222/Desktop/Nova pasta (2)/git/Banco_BG2/src/" + conta.getCpf() + "_transacoes.txt", true)) ;
        		
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
        
        linha = "==========";
        buffWrite.append(linha + "\n");        

        buffWrite.close();
    }

}