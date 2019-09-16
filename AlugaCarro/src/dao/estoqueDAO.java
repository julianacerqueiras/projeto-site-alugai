package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.estoque;

public class estoqueDAO {
	
private Connection conexao;
	
	public estoqueDAO(Connection _conexao) {
		this.conexao = _conexao;
		
	}
	
	public void cadEstoque(estoque estoque) throws SQLException {

		String SQL = "INSERT INTO estoque (nome,qtd_estoque) VALUES (?,?)";

		PreparedStatement ps = this.conexao.prepareStatement(SQL);

		ps.setString(1, estoque.getNome());
		ps.setInt(2, estoque.getQtd_estoque());
		
		ps.executeUpdate();

	}

	public void delEstoque(estoque estoque) throws SQLException {

		String SQL = "DELETE FROM estoquecWHERE nome = ? ";

		PreparedStatement ps = this.conexao.prepareStatement(SQL);

		ps.setString(1, estoque.getNome());

		ps.executeUpdate();

	}

	public void atuaEstoque(estoque estoque) throws SQLException {

		String SQL = "UPDATE estoque SET qtd_estoque= ? WHERE nome= ? ";

		PreparedStatement ps = this.conexao.prepareStatement(SQL);

		ps.setInt(1, estoque.getQtd_estoque());
		ps.setString(2, estoque.getNome());

		ps.executeUpdate();

	}
	
	public estoque BuscarPorQTD(int qtd) throws SQLException {
		
		String SQL = "SELECT nome, qtd_estoque FROM aluguel WHERE qtd_estoque = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, qtd);
		
		ResultSet rs = ps.executeQuery();
		
		estoque e = null;
		
		if(rs.next()) {
			e = new estoque();
			
			e.setNome(rs.getString(1));
			e.setQtd_estoque(rs.getInt(2));
		}
		
		return e;
		
	}
	
	public ArrayList<estoque> listaTodos() throws SQLException {

		String SQL = "SELECT * FROM estoque ";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);

		ResultSet resultado = ps.executeQuery();

		ArrayList<estoque> lista = new ArrayList<estoque>();

		while (resultado.next()) {

			estoque estoque = new estoque();
			estoque.setNome(resultado.getString("nome"));
			estoque.setQtd_estoque(resultado.getInt("qtd_estoque"));
		
			
			lista.add(estoque);
		}

		return lista;
	}
	

}
