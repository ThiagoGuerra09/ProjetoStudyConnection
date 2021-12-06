package DAO;

import java.sql.*;
// import java.util.*;
import model.Usuario;

public class StudyDao {
	private Connection conexao;
	
	public StudyDao() {
		conexao = null;
	}
	
	public boolean conectar() {
		String driverName = "org.postgresql.Driver";
		String serverName = "studyconnection.postgres.database.azure.com";
		String mydatabase = "postgres";
		int porta = 5432;
		String url = "jdbc:postgresql://" + serverName + ":" + porta + "/" + mydatabase;
		String username = "Joel@studyconnection";
		String password = "@Thutsch2";
		boolean status = false;
		
		try {
			Class.forName(driverName);
			conexao = DriverManager.getConnection(url, username, password);
			status = (conexao == null);
			System.out.println("Conex�o efetuada com o postgres!");
		} catch (ClassNotFoundException e) {
			System.err.println("Conex�o N�O efetuada com o postgres -- Driver n�o encontrado -- " + e.getMessage());
		} catch (SQLException e) {
			System.err.println("Conex�o N�O efetuada com o postgres -- " + e.getMessage());
		}
		
		return status;	
	}
	
	public boolean close() {
		boolean status = false;
		try {
			conexao.close();
			status = true;
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		
		return status;
	}
	
	public boolean inserirUsuario(Usuario usuario) {
		boolean status = false;
		try {
			Statement st = conexao.createStatement();
			String sql = "INSERT INTO usuario (email, name, lastname, password)"
					+ " VALUES ('" +  usuario.getEmail()+ "', '" + usuario.getName()
					+ "', '" + usuario.getLastname() + "', '" + usuario.getPassword() + "');";
			st.executeUpdate(sql);
			st.close();
			status = true;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		return status;
	}

	public int login(String nome, String pwd) {
		int id = -1;
		try {
			Statement st = conexao.createStatement();
			String sql = "SELECT id FROM usuario WHERE name = '" + nome + "' AND password = '" + pwd + "';";
			ResultSet rs = st.executeQuery(sql);

			if (rs.next()) id = rs.getInt("id");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		return id;
	}
	
	public int getMaxIdTopico() {
			int id = 0;
			
			try {
				Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);;
				ResultSet rs = st.executeQuery("select max(id) as max_id from usuario");
				if (rs.next()) id = rs.getInt("max_id");
				st.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
			
			return id;
		
	}
}
