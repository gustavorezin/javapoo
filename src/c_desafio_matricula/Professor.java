package c_desafio_matricula;

public class Professor {
	enum Formacao {
	    GRADUACAO,
	    ESPECIALIZACAO,
	    POS_GRADUACAO
	}
	
	private String nome;
	private Formacao formacao;
	
	public Professor(String nome, Formacao formacao) {
		super();
		this.nome = nome;
		this.formacao = formacao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Formacao getFormacao() {
		return formacao;
	}

	public void setFormacao(Formacao formacao) {
		this.formacao = formacao;
	}
}
