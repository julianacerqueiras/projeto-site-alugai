package modelo;

public class aluguel {
	
	private int codigo;
	private int qtd_carros;
	private String date;
	private carro carro =  new carro();
	private cliente cliente = new cliente();
	

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getQtd_carros() {
		return qtd_carros;
	}

	public void setQtd_carros(int qtd_carros) {
		this.qtd_carros = qtd_carros;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public carro getCarro() {
		return carro;
	}

	public void setCarro(carro carro) {
		this.carro = carro;
	}

	public cliente getCliente() {
		return cliente;
	}

	public void setCliente(cliente cliente) {
		this.cliente = cliente;
	}
	
	@Override
	public String toString() {
		String saida = codigo + " - " + qtd_carros + " - " + date ;
		return saida;
	}

}
