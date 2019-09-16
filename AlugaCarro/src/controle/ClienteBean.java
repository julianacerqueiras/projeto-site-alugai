package controle;

import java.sql.SQLException;
import java.sql.Connection;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.ListDataModel;

import dao.clienteDAO;
import modelo.cliente;
import dao.fabricaconexao;

@ManagedBean(name = "MBCliente")
@ViewScoped

public class ClienteBean {

	private cliente cliente;
	private ListDataModel<cliente> itens;
	private ArrayList<cliente> itensFiltrados;

	public cliente getCliente() {
		return cliente;
	}

	public void setCliente(cliente cliente) {
		this.cliente = cliente;
	}

	public ListDataModel<cliente> getItens() {
		return itens;
	}

	public void setItens(ListDataModel<cliente> itens) {
		this.itens = itens;
	}

	public ArrayList<cliente> getItensFiltrados() {
		return itensFiltrados;
	}

	public void setItensFiltrados(ArrayList<cliente> itensFiltrados) {
		this.itensFiltrados = itensFiltrados;
	}

	@PostConstruct /* chama o metodo antes de exibir*/
	public void preparaPesquisa() {

		try {

			Connection conexao = fabricaconexao.conectar();

			clienteDAO clienteDAO = new clienteDAO(conexao);
			ArrayList<cliente> lista = clienteDAO.listaTodos();
			itens = new ListDataModel<cliente>(lista);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void preparaCliente() {

		cliente = new cliente();

	}

	public void novoCliente() {

		try {

			Connection conexao = fabricaconexao.conectar();

			clienteDAO clienteDAO = new clienteDAO(conexao);
			clienteDAO.cadCliente(cliente);

			ArrayList<cliente> lista = clienteDAO.listaTodos();
			itens = new ListDataModel<cliente>(lista);

		} catch (SQLException e) {
			System.out.println("Erro ao Cadastrar Cliente");
			e.printStackTrace();
		}

	}

	public void preparaExcluir() {

		cliente = itens.getRowData();

	}

	public void excluir() {

		try {

			Connection conexao = fabricaconexao.conectar();

			clienteDAO clienteDAO = new clienteDAO(conexao);
			clienteDAO.delCliente(cliente);

			ArrayList<cliente> lista = clienteDAO.listaTodos();
			itens = new ListDataModel<cliente>(lista);

		} catch (SQLException e) {
			System.out.println("Erro ao Deletar Cliente");
			e.printStackTrace();
		}

	}

	public void alterar() {

		try {

			Connection conexao = fabricaconexao.conectar();

			clienteDAO clienteDAO = new clienteDAO(conexao);
			clienteDAO.atuaCliente(cliente);

			ArrayList<cliente> lista = clienteDAO.listaTodos();
			itens = new ListDataModel<cliente>(lista);

		} catch (SQLException e) {
			System.out.println("Erro ao Alterar Cliente");
			e.printStackTrace();
		}
	}

}
