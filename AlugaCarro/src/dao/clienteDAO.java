package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.cliente;

public class clienteDAO {
	
private Connection conexao;
	
	public clienteDAO(Connection _conexao) {
		this.conexao = _conexao;
		
	}
	
	public void cadCliente(cliente cliente) throws SQLException {

		String SQL = "INSERT INTO cliente (cpf,nome,email) VALUES (?,?,?)";
	
		PreparedStatement ps = this.conexao.prepareStatement(SQL);

		ps.setString(1, cliente.getCpf());
		ps.setString(2, cliente.getNome());
		ps.setString(3, cliente.getEmail());

		ps.executeUpdate();

	}

	public void delCliente(cliente cliente) throws SQLException {

		String SQL = "DELETE FROM cliente WHERE cpf= ? ";

		PreparedStatement ps = this.conexao.prepareStatement(SQL);

		ps.setString(1, cliente.getCpf());

		ps.executeUpdate();

	}

	public void atuaCliente(cliente cliente) throws SQLException {

		String SQL = "UPDATE cliente SET email= ? WHERE cpf= ? ";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);

		ps.setString(1, cliente.getEmail());
		ps.setString(2, cliente.getCpf());
		
		ps.executeUpdate();

	}
	
	public cliente BuscarPorcpf(int cpf) throws SQLException {
		
		String SQL = "SELECT cpf, nome, email FROM cliente WHERE cpf = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, cpf);
		
		ResultSet rs = ps.executeQuery();
		
		cliente c = null;
		
		if(rs.next()) {
			c = new cliente();
			
			c.setCpf(rs.getString(1));
			c.setNome(rs.getString(2));
			c.setEmail(rs.getString(3));
		}
		
		return c;
	}
	
	public ArrayList<cliente> listaTodos() throws SQLException {

		String SQL = "SELECT * FROM cliente ";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);

		ResultSet rs = ps.executeQuery();

		ArrayList<cliente> lista = new ArrayList<cliente>();

		while (rs.next()) {
			
			cliente cliente = new cliente();

			cliente.setCpf(rs.getString("cpf"));
			cliente.setNome(rs.getString("nome"));
			cliente.setEmail(rs.getString("email"));
		
			
			lista.add(cliente);
		}

		return lista;
	}
	
/*
	public static void main(String[] args) {

		cliente cliente = new cliente();
		cliente.setCpf("53269017314");
		cliente.setNome("Tereza");
		cliente.setEmail("tereza@gmail.com");

		clienteDAO clientedao = new clienteDAO();

		
		try {
			clientedao.atuacliente(cliente);
			System.out.println("Cliente  " + cliente.getNome() + " Alterado com Sucesso !!!");
		} catch (SQLException e) {
			System.out.println("Erro ao Atualizar Carro, Verifique os Dados");
			e.printStackTrace();
		}

	}*/

}
