package br.com.polimig.projetobdfinal;

public class Aluno {
	
	private int idAluno;
	private String nomeAluno;
	private String matricula;
	private String cpf;
	
	public Aluno(int idAluno, String nomeAluno, String matricula, String cpf) {
		super();
		this.idAluno = idAluno;
		this.nomeAluno = nomeAluno;
		this.matricula = matricula;
		this.cpf = cpf;
	}

	public Aluno(String nomeAluno, String matricula, String cpf) {
		super();
		this.nomeAluno = nomeAluno;
		this.matricula = matricula;
		this.cpf = cpf;
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

	@Override
	public String toString() {
		return "Aluno [idAluno=" + idAluno + ", nomeAluno=" + nomeAluno + ", matricula=" + matricula + ", cpf=" + cpf
				+ "]";
	}
}



