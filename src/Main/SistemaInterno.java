package Main;

import java.io.IOException;
import java.util.Scanner;
import ArmazenamentoTexto.LeitorTexto;
import Menus.MenuLogin;

public class SistemaInterno {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		LeitorTexto leitor = new LeitorTexto();
		leitor.leituratexto();

		MenuLogin menuLogin = new MenuLogin();
		menuLogin.MenuInicial();
	}
}
