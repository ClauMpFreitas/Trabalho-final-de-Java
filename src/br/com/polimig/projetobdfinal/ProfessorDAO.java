package br.com.polimig.projetobdfinal;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Connection;

public class ProfessorDAO implements DAO {

	@Override
	public void inserirProfessor() {
	    Scanner sc = new Scanner(System.in);
	    System.out.print("Qual o nome do professor a ser inserido? ");
	    String nomeProfessor = sc.nextLine();
	    System.out.print("Qual a disciplina do professor? ");
	    String disciplina = sc.nextLine();
	    String sql = "INSERT INTO professor VALUES ('" + nomeProfessor + "', '" + disciplina + "', 1)";
	    System.out.println();
	    System.out.println("Dado inserido com sucesso");
	    System.out.println();
	    try (Connection conn = Conexao.abrirConexao();
	         Statement stmt = conn.createStatement()) {
	        stmt.executeUpdate(sql);
	    } catch (SQLException e) {
	        System.out.println("Erro na inserção de dados: " + e.getMessage());
	    } finally {
	        try {
	            Object stmt = null;
	            if (stmt != null)
	                ((ResultSet) stmt).close();
	        } catch (Exception e) {
	            System.out.println("Erro ao fechar o statement ou o resultset: " + e.getMessage());
	        }
	        Conexao.fecharConexao();
	    }
	}

	@Override
	public void delete() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Qual o ID você quer deletar? ");
		int idProfessor = sc.nextInt();
		String query = "DELETE FROM professor WHERE id_professor = " + idProfessor;
		Statement stmt = null;
		try {
			Connection conn = Conexao.abrirConexao();
			stmt = conn.createStatement();
			stmt.executeUpdate("DELETE FROM professor WHERE id_professor = " + idProfessor);
			System.out.println();
			System.out.println("Dado excluído com sucesso");
			System.out.println();
		} catch (Exception e) {
			System.out.println("Erro na exclusão de dados: " + e.getMessage());
		} finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (Exception e) {
				System.out.println("Erro ao fechar o statement: " + e.getMessage());
			}
			Conexao.fecharConexao();
		}
	}

	@Override
	public void selecionar() {
		String query = "SELECT * FROM professor";
		Statement stmt = null;
		ResultSet rs = null;

		try {
			Connection conn = Conexao.abrirConexao();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			System.out.println();
			System.out.println(String.format("%-5s|%-30s|%-15s", "Id", "Nome", "Disciplina"));
			while (rs.next()) {
				Professor p = null;
				p = new Professor(rs.getInt("Id_professor"), rs.getString("Nome_professor"), rs.getString("Disciplina"));
				System.out.println(String.format("%-5s|%-30s|%-15s", p.getIdProfessor(), p.getNomeProfessor(), p.getDisciplina()));
			}
			System.out.println();
		} catch (Exception e) {
			System.out.println("Erro na seleção de dados: " + e.getMessage());
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
			} catch (Exception e) {
				System.out.println("Erro ao fechar o statement ou o resultset: " + e.getMessage());
			}
			Conexao.fecharConexao();
		}
	}

	@Override
	public void selecionarUm() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Escolha uma opção");
		System.out.println("1 - Por ID");
		System.out.println("2 - Por nome");
		System.out.println("3 - Por disciplina");
		System.out.print("Como você quer fazer a seleção? ");
		String query;
		int op = sc.nextInt();
		sc.nextLine(); // consumir a nova linha deixada pelo nextInt()
		switch (op) {
		case 1:
			System.out.print("Qual o ID você quer selecionar? ");
			int idProfessor = sc.nextInt();
			query = "SELECT * FROM professor where id_professor = " + idProfessor;
			break;

		case 2:
			System.out.print("Qual o nome você quer selecionar? ");
			String nomeProfessor = sc.nextLine();
			query = "SELECT * FROM professor where nome_professor = '" + nomeProfessor + "'";
			break;

		case 3:
			System.out.print("Qual a disciplina você quer selecionar? ");
			String disciplina = sc.nextLine();
			query = "SELECT * FROM professor where disciplina = '" + disciplina + "'";
			break;

		default:
			System.out.println("Você selecionou uma opção inválida!!!");
			return;
		}
		Statement stmt = null;
		ResultSet rs = null;

		try {
			Connection conn = Conexao.abrirConexao();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			System.out.println();
			System.out.println(String.format("%-5s|%-30s|%-15s", "Id", "Nome", "Disciplina"));
			while (rs.next()) {
				Professor p = new Professor(rs.getInt("Id_professor"), rs.getString("Nome_professor"), rs.getString("Disciplina"));
				System.out.println(String.format("%-5s|%-30s|%-15s", p.getIdProfessor(), p.getNomeProfessor(), p.getDisciplina()));
			}
			System.out.println();
		} catch (Exception e) {
			System.out.println("Erro na seleção de dados: " + e.getMessage());
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
			} catch (Exception e) {
				System.out.println("Erro ao fechar o statement ou o resultset: " + e.getMessage());
			}
			Conexao.fecharConexao();
		}
	}

	@Override
	public void atualizar() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Escolha uma opção");
		System.out.println("1 - Nome");
		System.out.println("2 - Disciplina");
		System.out.print("Qual dado você deseja alterar? ");
		String query;
		int op = sc.nextInt();
		sc.nextLine(); // consumir a nova linha deixada pelo nextInt()
		switch (op) {
		case 1:
			System.out.print("Qual o ID você deseja alterar? ");
			int idProfessor = sc.nextInt();
			sc.nextLine();
			System.out.print("Qual o novo nome? ");
			String nomeProfessor = sc.nextLine();
			query = "Update professor set nome_professor = '" + nomeProfessor + "' where id_professor = " + idProfessor;
			Statement stmt = null;
			try {
				Connection conn = Conexao.abrirConexao();
				stmt = conn.createStatement();
				stmt.executeUpdate("Update professor set nome_professor = '" + nomeProfessor + "' where id_professor = '" + idProfessor + "'");
				System.out.println();
				System.out.println("Dado atualizado com sucesso");
				System.out.println();
			} catch (Exception e) {
				System.out.println("Erro na atualização dos dados: " + e.getMessage());
			} finally {
				try {
					if (stmt != null)
						stmt.close();
				} catch (Exception e) {
					System.out.println("Erro ao fechar o statement: " + e.getMessage());
				}
				Conexao.fecharConexao();
			}
			break;

		case 2:
			System.out.print("Qual o ID você deseja alterar? ");
			idProfessor = sc.nextInt();
			System.out.print("Qual a nova disciplina? ");
			String disciplina = sc.nextLine();
			query = "Update professor set disciplina = " + disciplina + " where id_professor = " + idProfessor;
			stmt = null;
			try {
				Connection conn = Conexao.abrirConexao();
				stmt = conn.createStatement();
				stmt.executeUpdate("Update professor set disciplina = '" + disciplina + "' where id_professor = '" + idProfessor + "'");
				System.out.println();
				System.out.println("Dado atualizado com sucesso");
				System.out.println();
			} catch (Exception e) {
				System.out.println("Erro na atualização dos dados: " + e.getMessage());
			} finally {
				try {
					if (stmt != null)
						stmt.close();
				} catch (Exception e) {
					System.out.println("Erro ao fechar o statement: " + e.getMessage());
				}
				Conexao.fecharConexao();
			}
			break;

		default:
			System.out.println("Opção digitada inválida!!");
			break;
		}

	}

	@Override
	public void inserirAluno() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void selecionarTodos() {
		// TODO Auto-generated method stub
		
	}

	public static List<Integer> consultarProfessores() {
	    String sql = "SELECT id_professor FROM professor WHERE disponivel = 1";
	    List<Integer> idsProfessores = new ArrayList<>();
	    try (Connection conn = Conexao.abrirConexao();
	         Statement stmt = conn.createStatement();
	         ResultSet rs = stmt.executeQuery(sql)) {
	        while (rs.next()) {
	            int id = rs.getInt("id_professor");
	            idsProfessores.add(id);
	        }
	    } catch (SQLException e) {
	        System.out.println("Erro na consulta de dados: " + e.getMessage());
	    } finally {
	        try {
	            Object conn = null;
	            if (conn != null)
	                ((Connection) conn).close();
	        } catch (SQLException e) {
	            System.out.println("Erro ao fechar a conexão: " + e.getMessage());
	        }
	    }
	    Conexao.fecharConexao();
	    return idsProfessores;
	}
}



