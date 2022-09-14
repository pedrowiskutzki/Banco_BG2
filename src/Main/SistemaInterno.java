package Main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import ArmazenamentoTexto.LeitorTexto;
import Cliente.Cliente;
import Conta.Conta;
import Conta.ContaCorrente;
import Conta.ContaPoupanca;
import Funcionarios.Diretor;
import Funcionarios.Funcionario;
import Funcionarios.Gerente;
import Funcionarios.Presidente;
import Menus.MenuLogin;

public class SistemaInterno {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		LeitorTexto leitor = new LeitorTexto();
		leitor.leituratexto();
		
		MenuLogin menuLogin = new MenuLogin();
		menuLogin.MenuInicial();
		
	}
}
