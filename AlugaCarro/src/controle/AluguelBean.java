package controle;

import java.sql.SQLException;
import java.sql.Connection;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import dao.aluguelDAO;
import dao.carroDAO;
import dao.clienteDAO;
import modelo.aluguel;
import modelo.carro;
import modelo.cliente;
import dao.fabricaconexao;

@ManagedBean(name = "MBAluguel")
@ViewScoped

public class AluguelBean {
	private aluguel aluguel;
	private ArrayList<aluguel> itens;
	private ArrayList<aluguel> itensFiltrados;
	private ArrayList<cliente> comboCliente;
	private ArrayList<carro> comboCarro;

	public aluguel getAluguel() {
		return aluguel;
	}

	public void setAluguel(aluguel aluguel) {
		this.aluguel = aluguel;
	}

	public ArrayList<aluguel> getItens() {
		return itens;
	}

	public void setItens(ArrayList<aluguel> itens) {
		this.itens = itens;
	}

	public ArrayList<aluguel> getItensFiltrados() {
		return itensFiltrados;
	}

	public void setItensFiltrados(ArrayList<aluguel> itensFiltrados) {
		this.itensFiltrados = itensFiltrados;
	}

	public ArrayList<cliente> getComboCliente() {
		return comboCliente;
	}

	public void setComboCliente(ArrayList<cliente> comboCliente) {
		this.comboCliente = comboCliente;
	}

	public ArrayList<carro> getComboCarro() {
		return comboCarro;
	}

	public void setComboCarro(ArrayList<carro> comboCarro) {
		this.comboCarro = comboCarro;
	}

	@PostConstruct
	public void preparaPesquisa() {

		try {

			Connection conexao = fabricaconexao.conectar();

			aluguelDAO aluguelDAO = new aluguelDAO(conexao);
			itens = aluguelDAO.listaTodos();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void preparaAluguel() {

		try {

			Connection conexao = fabricaconexao.conectar();

			aluguel = new aluguel();
			clienteDAO clienteDAO = new clienteDAO(conexao);
			comboCliente = clienteDAO.listaTodos();

			carroDAO carroDAO = new carroDAO(conexao);
			comboCarro = carroDAO.listaTodos();

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public void novoAluguel() {

		try {

			Connection conexao = fabricaconexao.conectar();

			aluguelDAO aluguelDAO = new aluguelDAO(conexao);
			aluguelDAO.cadAluguel(aluguel);
			itens = aluguelDAO.listaTodos();

		} catch (SQLException e) {
			System.out.println("Erro ao Cadastrar Aluguel");
			e.printStackTrace();
		}

	}

	public void excluir() {

		try {

			Connection conexao = fabricaconexao.conectar();

			aluguelDAO aluguelDAO = new aluguelDAO(conexao);
			aluguelDAO.delAluguel(aluguel);
			itens = aluguelDAO.listaTodos();

		} catch (SQLException e) {
			System.out.println("Erro ao Excluir Aluguel");
			e.printStackTrace();
		}
	}

	public void alterar() {

		try {

			Connection conexao = fabricaconexao.conectar();

			aluguelDAO aluguelDAO = new aluguelDAO(conexao);
			aluguelDAO.atuaAluguel(aluguel);
			itens = aluguelDAO.listaTodos();

		} catch (SQLException e) {
			System.out.println("Erro ao Atualizar Aluguel");
			e.printStackTrace();
		}

	}

}
