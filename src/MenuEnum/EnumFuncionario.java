package MenuEnum;

public enum EnumFuncionario {

	CLIENTE("cliente", 1), GERENTE("gerente", 2), DIRETOR("diretor", 3), PRESIDENTE("presidente", 4);

	public final String nome;
	public final int valor;

	EnumFuncionario(String nome, int valor) {
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