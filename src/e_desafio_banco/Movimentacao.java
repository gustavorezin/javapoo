package e_desafio_banco;

public class Movimentacao {
	private String operacao;
	private double valor;
	private double saldo;

	public Movimentacao(String operacao, double valor, double saldo) {
		this.operacao = operacao;
		this.valor = valor;
		this.saldo = saldo;
	}

	@Override
	public String toString() {
		return "Op.: " + operacao + " | Valor: R$ " + valor + " | Saldo: R$ " + saldo;
	}
}
