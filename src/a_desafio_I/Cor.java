package a_desafio_I;

public enum Cor {
	VERMELHO("VERMELHO"), PRETO("PRETO"), BRANCO("BRANCO");
	
	private String cor;

	private Cor(String cor) {
		this.cor = cor;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}
}
