package br.com.polimig.projetobdfinal;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import java.sql.Statement;
import java.sql.Connection;

public class AlunoDAO implements DAO {

	private Scanner sc;

	public void inserirAluno() {
	    Scanner sc = new Scanner(System.in);
	    System.out.print("Qual o nome do aluno a ser inserido? ");
	    String nomeAluno = sc.nextLine();
	    System.out.print("Qual o número da matrícula? ");
	    String matricula = sc.nextLine();
	    System.out.print("Qual o número do CPF? ");
	    String cpf = sc.nextLine();
	    List<Integer> idsProfessores = ProfessorDAO.consultarProfessores();
	    System.out.println();
	    System.out.println("IDs de professores disponíveis para cadastro:");
	    for (Integer id : idsProfessores) {
	        System.out.print(id + " ");
	        System.out.println();
	    }
	    System.out.println();
	    System.out.print("Qual o ID do professor? ");
	    int idProfessor = sc.nextInt();
	    sc.nextLine(); // consumir a quebra de linha deixada pelo próximoInt() anterior
	    String sql = "INSERT INTO aluno VALUES (null, '" + nomeAluno + "', '" + matricula + "', '" + cpf + "', " + idProfessor + ")";
	    try (Connection conn = Conexao.abrirConexao();
	         Statement stmt = conn.createStatement()) {
	        stmt.executeUpdate(sql);
	        System.out.println();
	        System.out.println("Dado inserido com sucesso");
	        System.out.println();
	    } catch (SQLException e) {
	        System.out.println("Erro na inserção de dados: " + e.getMessage());
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
	}

	@Override
	public void delete() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Qual o ID você quer deletar? ");
		int idAluno = sc.nextInt();
		String query = "DELETE FROM aluno WHERE id_aluno = " + idAluno;
		Statement stmt = null;
		try {
			Connection conn = Conexao.abrirConexao();
			stmt = conn.createStatement();
			stmt.executeUpdate("DELETE FROM aluno WHERE id_aluno = '" + idAluno + "'");
			System.out.println();
			System.out.println("Dado excluído com sucesso");
			System.out.println();
		} catch (Exception e) {
			System.out.println("Erro na exclusão de dados: " + e.getMessage());
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
		}

	@Override
	public void selecionar() {
		String query = "SELECT * FROM aluno";
		Statement stmt = null;
		ResultSet rs = null;

		try {
			Connection conn = Conexao.abrirConexao();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			System.out.println();
			System.out.println(String.format("%-5s|%-30s|%-15s|%-15s", "Id", "Nome", "Matricula", "CPF"));
			while (rs.next()) {
				Aluno a = null;
				a = new Aluno(rs.getInt("Id_aluno"), rs.getString("Nome_aluno"), rs.getString("Matricula"), rs.getString("CPF"));
						String.format("%-5s|%-30s|%-15s|%-15s", a.getIdAluno(), a.getNomeAluno(), a.getMatricula(), a.getCpf());
			}
			System.out.println();
		} catch (Exception e) {
			System.out.println("Erro na seleção de dados: " + e.getMessage());
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
		}

	@Override
	public void selecionarUm() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Escolha uma opção");
		System.out.println("1 - Por ID");
		System.out.println("2 - Por nome");
		System.out.println("3 - Por matricula");
		System.out.println("4 - Por CPF");
		System.out.print("Como você quer fazer a seleção? ");
		String query;
		int op = sc.nextInt();
		sc.nextLine();
		switch (op) {
		case 1:
	        System.out.print("Qual o ID você quer selecionar? ");
	        int idAluno = sc.nextInt();
	        sc.nextLine(); // consumir a quebra de linha
	        query = "SELECT * FROM aluno where id_aluno = " + idAluno;
	        break;

		case 2:
		    System.out.print("Qual o nome você quer selecionar? ");
		    String nomeAluno = sc.nextLine();
		    query = "SELECT * FROM aluno where nome_aluno = '" + nomeAluno + "'";
		    break;

	    case 3:
	        System.out.print("Qual a matricula você quer selecionar? ");
	        String matricula = sc.nextLine();
	        query = "SELECT * FROM aluno where matricula = '" + matricula + "'";
	        break;

	    case 4:
	        System.out.print("Qual o CPF você quer selecionar? ");
	        String cpf = sc.nextLine();
	        query = "SELECT * FROM aluno where CPF = '" + cpf + "'";
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
	    System.out.println(String.format("%-5s|%-30s|%-15s|%-15s", "Id", "Nome", "Matricula", "CPF"));
	    while (rs.next()) {
	        Aluno a = new Aluno(rs.getInt("Id_aluno"), rs.getString("Nome_aluno"), rs.getString("Matricula"), rs.getString("CPF"));
	        System.out.println(String.format("%-5s|%-30s|%-15s|%-15s", a.getIdAluno(), a.getNomeAluno(), a.getMatricula(), a.getCpf()));
	    }
	    System.out.println();
	} catch (SQLException e) {
	    e.printStackTrace();
	} finally {
	    try {
	        if (rs != null) {
	            rs.close();
	        }
	        if (stmt != null) {
	            stmt.close();
	        }
	        Conexao.fecharConexao();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	}

	@Override
	public void atualizar() {
	    Scanner sc = new Scanner(System.in);
	    System.out.println("Escolha uma opção");
	    System.out.println("1 - Nome");
	    System.out.println("2 - Matrícula");
	    System.out.println("3 - CPF");
	    System.out.println("Qual dado você deseja alterar? ");
	    int op = sc.nextInt();
	    String query;
	    switch (op) {
	        case 1:
	            System.out.print("Qual o ID você deseja alterar? ");
	            int idAluno = sc.nextInt();
	            sc.nextLine(); // consume the newline character left in the buffer
	            System.out.print("Qual o novo nome? ");
	            String nomeAluno = sc.nextLine();
	            query = "Update aluno set nome_aluno = '" + nomeAluno + "' where id_aluno = " + idAluno;
	            Statement stmt = null;
	            try {
	                Connection conn = Conexao.abrirConexao();
	                stmt = conn.createStatement();
	                stmt.executeUpdate(query);
	                System.out.println();
	                System.out.println("Dado atualizado com sucesso");
	                System.out.println();
	            } catch (Exception e) {
	                System.out.println("Erro na atualização dos dados: " + e.getMessage());
	            } finally {
	                try {
	                    if (stmt != null)
	                        stmt.close();
	                } catch (SQLException e) {
	                    System.out.println("Erro ao fechar o Statement: " + e.getMessage());
	                }
	                Conexao.fecharConexao();
	            }
	            break;

	        case 2:
	            System.out.print("Qual o ID você deseja alterar? ");
	            int idAluno2 = sc.nextInt();
	            sc.nextLine(); // consume the newline character left in the buffer
	            System.out.print("Qual a nova matrícula? ");
	            String matricula = sc.nextLine();
	            query = "Update aluno set matricula = '" + matricula + "' where id_aluno = " + idAluno2;
	            Statement stmt2 = null;
	            try {
	                Connection conn = Conexao.abrirConexao();
	                stmt2 = conn.createStatement();
	                stmt2.executeUpdate(query);
	                System.out.println();
	                System.out.println("Dado atualizado com sucesso");
	                System.out.println();
	            } catch (Exception e) {
	                System.out.println("Erro na atualização dos dados: " + e.getMessage());
	            } finally {
	                try {
	                    if (stmt2 != null)
	                        stmt2.close();
	                } catch (SQLException e) {
	                    System.out.println("Erro ao fechar o Statement: " + e.getMessage());
	                }
	                Conexao.fecharConexao();
	            }
	            break;

	        case 3:
	            System.out.print("Qual o ID você deseja alterar? ");
	            int idAluno3 = sc.nextInt();
	            sc.nextLine(); // consume the newline character left in the buffer
	            System.out.print("Qual o novo CPF? ");
	            String cpf = sc.nextLine();
	            query = "Update aluno set cpf = '" + cpf + "' where id_aluno = " + idAluno3;
	            Statement stmt3 = null;
	            try {
	                Connection conn = Conexao.abrirConexao();
	                stmt3 = conn.createStatement();
	                stmt3.executeUpdate(query);
	                System.out.println();
	                System.out.println("Dado atualizado com sucesso");
	                System.out.println();
	            } catch (Exception e) {
	                System.out.println("Erro na atualização dos dados: " + e.getMessage());
	            } finally {
	                try {
	                    if (stmt3 != null)
	                        stmt3.close();
	                } catch (SQLException e) {
	                    System.out.println("Erro ao fechar o Statement: " + e.getMessage());
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
	public void inserirProfessor() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void selecionarTodos() {
		// TODO Auto-generated method stub
		
	}
}


