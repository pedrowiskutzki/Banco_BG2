package MenuEnum;

public enum EnumConta {

	CONTACORRENTE("CONTACORRENTE", 1), CONTAPOUPANCA("CONTAPOUPANCA", 2);

	public final String nome;
	public final int valor;

	EnumConta(String nome, int valor) {
		this.nome = nome;
		this.valor = valor;
	}

	public String getNome() {
		return this.nome;
	}

	public int getValor() {
		return this.valor;
	}
}
