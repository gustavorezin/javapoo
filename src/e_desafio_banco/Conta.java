package e_desafio_banco;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Conta {
	protected int numero;
	protected int agencia;
	protected String nomeCorrentista;
	protected double saldo;
	protected String tipo = "Corrente";
	protected ArrayList<Movimentacao> movimentacoes = new ArrayList<Movimentacao>();

	private static Set<Integer> numerosDeContas = new HashSet<>();

	public Conta() {
		do {
			this.numero = Integer.parseInt(Util.obterEntradaUsuario("Número da Conta:"));
			if (numerosDeContas.contains(numero)) {
				Util.exibirMensagem("Número de conta já cadastrado!");
			}
		} while (numerosDeContas.contains(numero));
		numerosDeContas.add(numero);
		this.agencia = Integer.parseInt(Util.obterEntradaUsuario("Número da Agência:"));
		this.nomeCorrentista = Util.obterEntradaUsuario("Nome do Correntista:");
		this.saldo = Double.parseDouble(Util.obterEntradaUsuario("Saldo Inicial (R$):"));
	}

	public void depositar() {
		double valorDeposito = Double
				.parseDouble(Util.obterEntradaUsuario(saldoAtual() + "Quanto deseja depositar? (R$)"));
		saldo += valorDeposito;
		movimentacoes.add(new Movimentacao("Deposito", valorDeposito, saldo));
	}

	public void sacar() {
		double valorSaque = Double.parseDouble(Util.obterEntradaUsuario(saldoAtual() + "Quanto deseja sacar? (R$)"));
		if (valorSaque <= saldo) {
			saldo -= valorSaque;
			movimentacoes.add(new Movimentacao("Saque", valorSaque, saldo));
		} else {
			Util.exibirMensagem("Saldo insuficiente!");
		}
	}

	public void transferir() {
		double valorTransferencia = Double
				.parseDouble(Util.obterEntradaUsuario(saldoAtual() + "Quanto deseja transferir? (R$)"));
		if (valorTransferencia <= saldo) {
			saldo -= valorTransferencia;
			movimentacoes.add(new Movimentacao("Transferencia", valorTransferencia, saldo));
		} else {
			Util.exibirMensagem("Saldo insuficiente!");
		}
	}

	public void extratoMovimentacoes() {
		if (movimentacoes.size() > 0) {
			String extrato = "";
			for (Movimentacao movimentacao : movimentacoes) {
				extrato += movimentacao.toString()
						+ "\n----------------------------------------------------------------\n";
			}
			Util.exibirMensagem(extrato);
		} else {
			Util.exibirMensagem("Nenhuma movimentacao");
		}
	}

	public String saldoAtual() {
		return "Saldo atual: R$" + saldo + "\n";
	}

	public String dadosConta() {
		String dados = "Conta " + tipo + "\nCorrentista: " + nomeCorrentista + "\nNumero: " + numero + " | Agencia: "
				+ agencia + "\nSaldo: R$ " + saldo + "\n";
		return dados;
	}

	@Override
	public String toString() {
		return "Conta " + tipo + ": Numero: " + numero + " | Agencia: " + agencia;
	}
}
