package e_desafio_banco;

public class ContaEspecial extends Conta {
	private double limiteSaque;

	public ContaEspecial() {
		super();
		tipo = "Especial";
		this.limiteSaque = Double.parseDouble(Util.obterEntradaUsuario("Limite (R$):"));
	}

	@Override
	public void sacar() {
		double valorSaque = Double.parseDouble(Util.obterEntradaUsuario(saldoAtual() + "Quanto deseja sacar? (R$)"));
		if (valorSaque <= limiteSaque + saldo) {
			saldo -= valorSaque;
			movimentacoes.add(new Movimentacao("Saque", valorSaque, saldo));
		} else {
			Util.exibirMensagem("Limite ultrapassado!");
		}
	}

	@Override
	public void transferir() {
		double valorTransferencia = Double
				.parseDouble(Util.obterEntradaUsuario(saldoAtual() + "Quanto deseja transferir? (R$)"));
		if (valorTransferencia <= limiteSaque + saldo) {
			saldo -= valorTransferencia;
			movimentacoes.add(new Movimentacao("Transferencia", valorTransferencia, saldo));
		} else {
			Util.exibirMensagem("Limite ultrapassado!");
		}
	}

	@Override
	public String dadosConta() {
		return super.dadosConta() + "Limite saque: R$ " + limiteSaque + "\n";
	}
}
