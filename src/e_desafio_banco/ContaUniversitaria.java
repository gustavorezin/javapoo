package e_desafio_banco;

public class ContaUniversitaria extends Conta {

	private final double limiteSaldo = 2000.0;

	public ContaUniversitaria() {
		super();
		tipo = "Universitaria";
	}

	@Override
	public void depositar() {
		double valorDeposito = Double.parseDouble(Util.obterEntradaUsuario(
				saldoAtual() + "Limite de saldo: R$ " + limiteSaldo + "\nQuanto deseja depositar? (R$)"));
		if (saldo + valorDeposito <= limiteSaldo) {
			saldo += valorDeposito;
			movimentacoes.add(new Movimentacao("Deposito", valorDeposito, saldo));
		} else {
			Util.exibirMensagem("Limite ultrapassado!");
		}
	}

	@Override
	public String dadosConta() {
		return super.dadosConta() + "Limite saldo: R$ " + limiteSaldo + "\n";
	}
}
