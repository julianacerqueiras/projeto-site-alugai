package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class fabricaconexao {

	private static final String USUARIO ="root";
	private static final String SENHA = "bd1234";
	private static final String URL = "jdbc:mysql://localhost:3306/alugacarro";	

	public static Connection conectar ()throws SQLException{
		
		try {
			Class.forName("com.mysql.jdbc.Driver");		
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
			System.out.println("Erro no driver");
		}
		Connection conexao = DriverManager.getConnection(URL, USUARIO, SENHA) ;
		return conexao ;
				
	}
	
}
