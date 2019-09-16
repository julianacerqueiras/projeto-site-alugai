package modelo;

public class estoque {

	
	private String nome;
	private int qtd_estoque;
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getQtd_estoque() {
		return qtd_estoque;
	}

	public void setQtd_estoque(int qtd_estoque) {
		this.qtd_estoque = qtd_estoque;
	}

	
	@Override
	public String toString() {
		String saida = nome + " - " + qtd_estoque;
		return saida;
	}
}
