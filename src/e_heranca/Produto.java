package e_heranca;

public class Produto {
	protected String nome;
	protected double preco;
	protected int over;
	
	public Produto() {
		System.out.println(over);
	}

	public boolean ehCaro() {
		return preco > 100;
	}

	@Override
	public String toString() {
		return "Produto [nome=" + nome + ", preco=" + preco + "]";
	}
}
