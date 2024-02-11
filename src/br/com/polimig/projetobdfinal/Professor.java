package br.com.polimig.projetobdfinal;

public class Professor {

	private int idProfessor;
	private String nomeProfessor;
	private String disciplina;
	
	public Professor(int idProfessor, String nomeProfessor, String disciplina) {
		super();
		this.idProfessor = idProfessor;
		this.nomeProfessor = nomeProfessor;
		this.disciplina = disciplina;
	}

	public Professor(String nomeProfessor, String disciplina) {
		super();
		this.nomeProfessor = nomeProfessor;
		this.disciplina = disciplina;
	}

	public int getIdProfessor() {
		return idProfessor;
	}

	public void setIdProfessor(int idProfessor) {
		this.idProfessor = idProfessor;
	}

	public String getNomeProfessor() {
		return nomeProfessor;
	}

	public void setNomeProfessor(String nomeProfessor) {
		this.nomeProfessor = nomeProfessor;
	}

	public String getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}

	@Override
	public String toString() {
		return "Professor [idProfessor=" + idProfessor + ", nomeProfessor=" + nomeProfessor + ", disciplina="
				+ disciplina + "]";
	}
}



