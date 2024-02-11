package br.com.polimig.projetobdfinal;

public class AlunoProfessor {

	private int idAluno;
	private String nomeAluno;
	private String matricula;
	private String cpf;
	private int idProfessor;
	private String nomeProfessor;
	private String disciplina;
	
	public AlunoProfessor(int idAluno, String nomeAluno, String matricula, String cpf, int idProfessor,
			String nomeProfessor, String disciplina) {
		super();
		this.idAluno = idAluno;
		this.nomeAluno = nomeAluno;
		this.matricula = matricula;
		this.cpf = cpf;
		this.idProfessor = idProfessor;
		this.nomeProfessor = nomeProfessor;
		this.disciplina = disciplina;
	}

	public int getIdAluno() {
		return idAluno;
	}

	public void setIdAluno(int idAluno) {
		this.idAluno = idAluno;
	}

	public String getNomeAluno() {
		return nomeAluno;
	}

	public void setNomeAluno(String nomeAluno) {
		this.nomeAluno = nomeAluno;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
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
		return "AlunoProfessor [idAluno=" + idAluno + ", nomeAluno=" + nomeAluno + ", matricula=" + matricula + ", cpf="
				+ cpf + ", idProfessor=" + idProfessor + ", nomeProfessor=" + nomeProfessor + ", disciplina="
				+ disciplina + "]";
	}
}



