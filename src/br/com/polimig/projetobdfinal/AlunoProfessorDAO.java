package br.com.polimig.projetobdfinal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AlunoProfessorDAO implements DAO {

	@Override
	public void inserirAluno() {
		// TODO Auto-generated method stub

	}

	@Override
	public void inserirProfessor() {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub

	}

	@Override
	public void selecionar() {
		// TODO Auto-generated method stub

	}

	@Override
	public void selecionarUm() {
		// TODO Auto-generated method stub

	}

	@Override
	public void atualizar() {
		// TODO Auto-generated method stub

	}

	@Override
	public void selecionarTodos() {
		System.out.println();
		String sql = "SELECT a.id_aluno, a.nome_aluno, a.matricula, a.cpf, p.id_professor, p.nome_professor, p.disciplina "
				+ "FROM aluno a INNER JOIN professor p ON a.id_professor = p.id_professor";

		try (Connection conn = Conexao.abrirConexao();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {
			System.out.println(String.format("%-5s|%-20s|%-15s|%-15s|%-15s|%-20s|%-20s", "ID", "Nome do Aluno",
					"Matrícula", "CPF", "ID do Professor", "Nome do Professor", "Disciplina"));

			while (rs.next()) {
				int idAluno = rs.getInt("id_aluno");
				String nomeAluno = rs.getString("nome_aluno");
				String matricula = rs.getString("matricula");
				String cpf = rs.getString("cpf");
				int idProfessor = rs.getInt("id_professor");
				String nomeProfessor = rs.getString("nome_professor");
				String disciplina = rs.getString("disciplina");
				System.out.println(String.format("%-5s|%-20s|%-15s|%-15s|%-15s|%-20s|%-20s", idAluno, nomeAluno,
						matricula, cpf, idProfessor, nomeProfessor, disciplina));
			}
			System.out.println();

		} catch (SQLException e) {
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
	}


