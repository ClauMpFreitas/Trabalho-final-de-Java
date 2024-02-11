package br.com.polimig.projetobdfinal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	
	public static String url = "jdbc:mysql://localhost/projetobdfinal";
	public static String usuario = "root";
	public static String senha = "";
	public static Connection conn = null;
	
	public static Connection abrirConexao() {
		try {
			if (conn == null) {
				conn = DriverManager.getConnection(url, usuario, senha);
			}
			return conn;
		}
		catch (SQLException e) {
			System.out.println("Não foi possível fazer a conexão: " +e.getMessage());
			return null;
		}
	}
	public static void fecharConexao() {
		try {
			if (conn != null) {
				conn.close();
			}
		}
		catch (SQLException e){
			System.out.println("Não foi possível fechar a conexão: " +e.getMessage());
		}
	}
}

