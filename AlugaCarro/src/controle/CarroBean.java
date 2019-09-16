package controle;

import java.sql.SQLException;
import java.sql.Connection;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import dao.carroDAO;
import dao.estoqueDAO;
import modelo.carro;
import modelo.estoque;
import dao.fabricaconexao;

@ManagedBean(name = "MBCarro")
@ViewScoped

public class CarroBean {
	private carro carro;
	private ArrayList<carro> itens;
	private ArrayList<carro> itensFiltrados;
	private ArrayList<estoque> comboEstoque;

	
	
	

	public carro getCarro() {
		return carro;
	}

	public void setCarro(carro carro) {
		this.carro = carro;
	}

	public ArrayList<carro> getItens() {
		return itens;
	}

	public void setItens(ArrayList<carro> itens) {
		this.itens = itens;
	}

	public ArrayList<carro> getItensFiltrados() {
		return itensFiltrados;
	}

	public void setItensFiltrados(ArrayList<carro> itensFiltrados) {
		this.itensFiltrados = itensFiltrados;
	}

	public ArrayList<estoque> getComboEstoque() {
		return comboEstoque;
	}

	public void setComboEstoque(ArrayList<estoque> comboEstoque) {
		this.comboEstoque = comboEstoque;
	}

	@PostConstruct
	public void preparaPesquisa() {

		try {
			
			Connection conexao = fabricaconexao.conectar();
			
			carroDAO carrodao = new carroDAO(conexao);
			itens = carrodao.listaTodos();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void preparaCarro() {

		
		try {
			
			Connection conexao = fabricaconexao.conectar();
			
			carro = new carro();			
			estoqueDAO estoquedao = new estoqueDAO(conexao);
			comboEstoque = estoquedao.listaTodos();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

	public void novoCarro() {

		try {
			
			Connection conexao = fabricaconexao.conectar();
			
			carroDAO carrodao = new carroDAO(conexao);
			carrodao.cadCarro(carro);
			itens = carrodao.listaTodos();

		} catch (SQLException e) {
			System.out.println("Erro ao Cadastrar Carro");
			e.printStackTrace();
		}

	}

	public void excluir() {

		try {
			
			Connection conexao = fabricaconexao.conectar();
			
			carroDAO carrodao = new carroDAO(conexao);
			carrodao.delCarro(carro);

			itens = carrodao.listaTodos();

		} catch (SQLException e) {
			System.out.println("Erro ao Deletar Carro");
			e.printStackTrace();
		}

	}

	public void alterar() {

		try {
			
			Connection conexao = fabricaconexao.conectar();
			
			carroDAO carrodao = new carroDAO(conexao);
			carrodao.atuaCarro(carro);

			itens = carrodao.listaTodos();

		} catch (SQLException e) {
			System.out.println("Erro ao Alterar Carro");
			e.printStackTrace();
		}

	}

}
