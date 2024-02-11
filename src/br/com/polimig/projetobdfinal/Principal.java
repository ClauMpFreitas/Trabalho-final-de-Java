package br.com.polimig.projetobdfinal;

import java.sql.SQLException;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) throws SQLException {

		Scanner sc = new Scanner(System.in);

		int opcao = 0;

		AlunoDAO ad = new AlunoDAO();
		ProfessorDAO pd = new ProfessorDAO();
		AlunoProfessorDAO apd = new AlunoProfessorDAO();

		do {
			System.out.println("OBS: Para inserir um aluno você deve inserir um professor primeiro para associar o ID do professor com o do aluno.");
			System.out.println("Depois, consulte no seu banco de dados qual foi o id criado pelo professor para utilizar na inserção do aluno.");
			System.out.println();
			System.out.println("Digite uma opção:");
			System.out.println();
			System.out.println("1 - AlunoProfessor: Seleção de todos os registros");
			System.out.println("2 - Aluno: Exibição dos registros");
			System.out.println("3 - Aluno: Exibir apenas um registro");
			System.out.println("4 - Aluno: Inserir um registro");
			System.out.println("5 - Aluno: Atualizar um registro");
			System.out.println("6 - Aluno: Deletar um registro");
			System.out.println("7 - Professor: Exibição dos registros");
			System.out.println("8 - Professor: Exibir apenas um registro");
			System.out.println("9 - Professor: Inserir um registro");
			System.out.println("10 - Professor: Atualizar um registro");
			System.out.println("11 - Professor: Deletar um registro");
			System.out.println("12 - Sair");
			System.out.println();
			System.out.print("Qual a opção? ");
			opcao = sc.nextInt();

			switch (opcao) {
			case 1:
				apd.selecionarTodos();
				break;

			case 2:
				ad.selecionar();
				break;

			case 3:
				ad.selecionarUm();
				break;

			case 4:
				ad.inserirAluno();
				break;

			case 5:
				ad.atualizar();
				break;

			case 6:
				ad.delete();
				break;

			case 7:
				pd.selecionar();
				break;

			case 8:
				pd.selecionarUm();
				break;

			case 9:
				pd.inserirProfessor();
				break;

			case 10:
				pd.atualizar();
				break;

			case 11:
				pd.delete();
				break;

			case 12:
				System.out.println("Programa encerrado.");
				break;

			default:
				System.out.println("Op��o inv�lida!!");
				break;
			}
		} while (opcao != 12);

		sc.close();
		System.exit(0); // encerra a execu��o do programa
	}
}


