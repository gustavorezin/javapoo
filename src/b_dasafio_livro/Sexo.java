package b_dasafio_livro;

public enum Sexo {
	MASCULINO("MASCULINO"), FEMININO("FEMININO");
	
	private String sexo;

	private Sexo(String sexo) {
		this.sexo = sexo;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
}
