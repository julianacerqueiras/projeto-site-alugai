package modelo;

public class carro {
	
	private String placa;
	private String modelo;
	private String marca;
	private String cor;
	private Double valor_aluguel;
	private String situacao;
	private estoque estoque = new estoque();

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public Double getValor_aluguel() {
		return valor_aluguel;
	}

	public void setValor_aluguel(Double valor_aluguel) {
		this.valor_aluguel = valor_aluguel;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public estoque getEstoque() {
		return estoque;
	}

	public void setEstoque(estoque estoque) {
		this.estoque = estoque;
	}

	@Override
	public String toString() {
		String saida = placa + " - " + modelo + " - " + marca + " - " + cor + " - " + valor_aluguel + " - " + situacao;
		return saida;
	}

}
