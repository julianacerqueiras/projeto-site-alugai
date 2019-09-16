package controle;

import java.sql.SQLException;
import java.sql.Connection;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.ListDataModel;

import dao.estoqueDAO;
import dao.fabricaconexao;
import modelo.estoque;

@ManagedBean(name = "MBEstoque")
@ViewScoped

public class EstoqueBean {
	private estoque estoque;
	private ListDataModel<estoque> itens;
	private ArrayList<estoque> itensFiltrados;

	public estoque getEstoque() {
		return estoque;
	}

	public void setEstoque(estoque estoque) {
		this.estoque = estoque;
	}

	public ListDataModel<estoque> getItens() {
		return itens;
	}

	public void setItens(ListDataModel<estoque> itens) {
		this.itens = itens;
	}

	public ArrayList<estoque> getItensFiltrados() {
		return itensFiltrados;
	}

	public void setItensFiltrados(ArrayList<estoque> itensFiltrados) {
		this.itensFiltrados = itensFiltrados;
	}

	@PostConstruct
	public void preparaPesquisa() {

		try {

			Connection conexao = fabricaconexao.conectar();

			estoqueDAO estoqueDao = new estoqueDAO(conexao);
			ArrayList<estoque> lista = estoqueDao.listaTodos();
			itens = new ListDataModel<estoque>(lista);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void preparaEstoque() {

		estoque = new estoque();

	}

	public void novoEstoque() {

		try {

			Connection conexao = fabricaconexao.conectar();

			estoqueDAO estoqueDao = new estoqueDAO(conexao);
			estoqueDao.cadEstoque(estoque);
			ArrayList<estoque> lista = estoqueDao.listaTodos();
			itens = new ListDataModel<estoque>(lista);

		} catch (SQLException e) {
			System.out.println("Erro ao Cadastrar Carro");
			e.printStackTrace();
		}

	}

	public void preparaExcluir() {

		estoque = itens.getRowData();

	}

	public void excluir() {

		try {

			Connection conexao = fabricaconexao.conectar();

			estoqueDAO estoqueDao = new estoqueDAO(conexao);
			estoqueDao.delEstoque(estoque);
			ArrayList<estoque> lista = estoqueDao.listaTodos();
			itens = new ListDataModel<estoque>(lista);

		} catch (SQLException e) {
			System.out.println("Erro ao Excluir Carro");
			e.printStackTrace();
		}

	}

	public void alterar() {

		try {

			Connection conexao = fabricaconexao.conectar();

			estoqueDAO estoqueDao = new estoqueDAO(conexao);
			estoqueDao.atuaEstoque(estoque);

			ArrayList<estoque> lista = estoqueDao.listaTodos();
			itens = new ListDataModel<estoque>(lista);

		} catch (SQLException e) {
			System.out.println("Erro ao Cadastrar Carro");
			e.printStackTrace();
		}
	}

}
