package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.carro;
import modelo.estoque;

public class carroDAO {
	
private Connection conexao;
	
	public carroDAO(Connection _conexao) {
		this.conexao = _conexao;
		
	}
	
	public void cadCarro(carro carro) throws SQLException {

		String SQL = "INSERT INTO carro (placa,modelo,marca,cor,valor_aluguel,situacao,estoque_nome) VALUES (?,?,?,?,?,?,?)";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);

		ps.setString(1, carro.getPlaca());
		ps.setString(2, carro.getModelo());
		ps.setString(3, carro.getMarca());
		ps.setString(4, carro.getCor());
		ps.setDouble(5, carro.getValor_aluguel());
		ps.setString(6, carro.getSituacao());
		ps.setString(7, carro.getEstoque().getNome());

		ps.executeUpdate();

	}

	public void delCarro(carro carro) throws SQLException {

		String SQL = "DELETE FROM carro WHERE placa= ? ";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);

		ps.setString(1, carro.getPlaca());

		ps.executeUpdate();

	}

	public void atuaCarro(carro carro) throws SQLException {

		String SQL = "UPDATE carro SET cor= ? WHERE placa= ? ";

		PreparedStatement ps = this.conexao.prepareStatement(SQL);

		ps.setString(1, carro.getCor());
		ps.setString(2, carro.getPlaca());

		ps.executeUpdate();

	}

	public carro buscaPorPlaca(carro carro) throws SQLException {

		String SQL = "SELECT * FROM carro WHERE placa = ? ";

		PreparedStatement ps = this.conexao.prepareStatement(SQL);
	
		ps.setString(1, carro.getPlaca());

		ResultSet rs = ps.executeQuery();

		carro retorno = null;

		if (rs.next()) {

			retorno = new carro();
			retorno.setPlaca(rs.getString("placa"));
			retorno.setModelo(rs.getString("modelo"));
			retorno.setMarca(rs.getString("marca"));
			retorno.setCor(rs.getString("cor"));
			retorno.setValor_aluguel(rs.getDouble("valor_aluguel"));
			retorno.setSituacao(rs.getString("situacao"));
		}

		return retorno;
	}

	public ArrayList<carro> listaTodos() throws SQLException {

		String SQL = "SELECT c.placa,c.modelo, c.marca, c.cor, c.valor_aluguel, c.situacao,e.nome FROM carro c INNER JOIN estoque e ON c.estoque_nome = e.nome ";

		PreparedStatement ps = this.conexao.prepareStatement(SQL);

		ResultSet rs = ps.executeQuery();

		ArrayList<carro> lista = new ArrayList<carro>();

		while (rs.next()) {

			estoque estoque = new estoque();
			estoque.setNome(rs.getString("e.nome"));
			

			carro car = new carro();

			car.setPlaca(rs.getString("c.placa"));
			car.setModelo(rs.getString("c.modelo"));
			car.setMarca(rs.getString("c.marca"));
			car.setCor(rs.getString("c.cor"));
			car.setValor_aluguel(rs.getDouble("c.valor_aluguel"));
			car.setSituacao(rs.getString("c.situacao"));
			car.setEstoque(estoque);

			lista.add(car);
		}

		return lista;
	}

}
