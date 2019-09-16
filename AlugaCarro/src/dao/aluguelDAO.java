package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.aluguel;
import modelo.carro;
import modelo.cliente;

public class aluguelDAO {
	
private Connection conexao;
	
	public aluguelDAO(Connection _conexao) {
		this.conexao = _conexao;
		
	}
	
	public void cadAluguel(aluguel aluguel) throws SQLException {

		
		String SQL = "INSERT INTO aluguel (codigo,qtd_carros,data,carro_placa,cliente_cpf) VALUES (?,?,?,?,?)";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);

		ps.setInt(1, aluguel.getCodigo());
		ps.setInt(2, aluguel.getQtd_carros());
		ps.setString(3, aluguel.getDate());
		ps.setString(4, aluguel.getCarro().getPlaca());
		ps.setString(5, aluguel.getCliente().getCpf());

		ps.executeUpdate();

	}
	
	public void delAluguel(aluguel aluguel) throws SQLException {

		String SQL = "DELETE FROM aluguel WHERE id = ?";
				
		PreparedStatement ps = this.conexao.prepareStatement(SQL);

		ps.setInt(1, aluguel.getCodigo());

		ps.executeUpdate();

	}

	public void atuaAluguel(aluguel aluguel) throws SQLException {

		String SQL = "UPDATE aluguel SET data= ? WHERE codigo= ?";
			
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setString(1, aluguel.getDate());
		ps.setInt(2, aluguel.getCodigo());

		ps.executeUpdate();

	}
	public aluguel BuscarPorID(int codigo) throws SQLException {
		
		String SQL = "SELECT codigo, qtd_carros, date FROM aluguel WHERE codigo = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, codigo);
		
		ResultSet rs = ps.executeQuery();
		
		aluguel a = null;
		
		if(rs.next()) {
			a = new aluguel();
			
			a.setCodigo(rs.getInt(1));
			a.setQtd_carros(rs.getInt(2));
			a.setDate(rs.getString(3));
		}
		
		return a;
	}
	
	public ArrayList<aluguel> listaTodos() throws SQLException {

		String SQL = "SELECT c.placa,a.codigo, a.qtd_carros,a.data,cl.cpf FROM aluguel a INNER JOIN carro c ON c.placa = a.carro_placa INNER JOIN cliente cl ON cl.cpf = a.cliente_cpf"; 
			
	
		PreparedStatement ps = this.conexao.prepareStatement(SQL);

		ResultSet rs = ps.executeQuery();

		ArrayList<aluguel> lista = new ArrayList<aluguel>();

		while (rs.next()) {

				
			cliente cliente = new cliente();
			cliente.setCpf(rs.getString("cl.cpf"));
			
			carro carro = new carro();
			carro.setPlaca(rs.getString("c.placa"));
						
			aluguel aluguel = new aluguel();
			
			aluguel.setCodigo(rs.getInt("a.codigo"));
			aluguel.setDate(rs.getString("a.data"));
			aluguel.setQtd_carros(rs.getInt("a.qtd_carros"));
			
			aluguel.setCarro(carro);
			aluguel.setCliente(cliente);

			lista.add(aluguel);
		}

		return lista;
	}
	
}
