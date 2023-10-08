package e_desafio_banco;

import java.util.ArrayList;

public class Main {
	static ArrayList<Conta> contas = new ArrayList<Conta>();
	static Conta contaAtual = null;

	public static void main(String[] args) {
		int op = 0;
		do {
			op = Util.exibirMenuPrincipal();
			switch (op) {
			case 1:
				cadastrarConta();
				break;
			case 2:
				acessarConta();
				break;
			case 3:
				excluirConta();
				break;
			case 4:
				listarContas();
				break;
			case 5:
				Util.exibirMensagem("Saindo...");
				break;
			default:
				Util.exibirMensagem("Opcao invalida!");
			}
		} while (op != 5);
	}

	// MENU PRINCIPAL -----------------------------------------------
	public static void cadastrarConta() {
		String menu = "Tipo de conta:\n\n" + "1- Corrente\n" + "2- Especial\n" + "3- Universitaria\n";
		int op = Integer.parseInt(Util.obterEntradaUsuario(menu));

		switch (op) {
		case 1:
			contas.add(new Conta());
			break;
		case 2:
			contas.add(new ContaEspecial());
			break;
		case 3:
			contas.add(new ContaUniversitaria());
			break;
		default:
			Util.exibirMensagem("Opcao invalida!");
		}
	}

	public static void acessarConta() {
		if (contas.size() > 0) {
			int op = Util.exibirMenuContas(contas);
			for (Conta conta : contas) {
				if (conta.numero == op) {
					contaAtual = conta;
				}
			}
			if (contaAtual != null) {
				operacoesConta();
			} else {
				Util.exibirMensagem("Conta não encontrada!");
			}
		} else {
			Util.exibirMensagem("Nenhuma conta cadastrada");
		}
	}

	public static void excluirConta() {
		if (contas.size() > 0) {
			int op = Util.exibirMenuContas(contas);
			contas.removeIf(conta -> conta.numero == op);
		} else {
			Util.exibirMensagem("Nenhuma conta cadastrada");
		}
	}

	public static void listarContas() {
		if (contas.size() > 0) {
			String listaContas = "";
			for (Conta conta : contas) {
				listaContas += conta.dadosConta() + "\n";
			}
			Util.exibirMensagem(listaContas);
		} else {
			Util.exibirMensagem("Nenhuma conta cadastrada");
		}
	}

	// MENU CONTAS --------------------------------------------------
	public static void operacoesConta() {
		String menuInicial = "1- Sacar\n2- Depositar\n3- Transferir\n4- Extrato\n5- Sair da conta\n";
		int op = 0;
		do {
			String menu = contaAtual.dadosConta() + "\n" + menuInicial;
			op = Integer.parseInt(Util.obterEntradaUsuario(menu));

			switch (op) {
			case 1:
				contaAtual.sacar();
				break;
			case 2:
				contaAtual.depositar();
				break;
			case 3:
				contaAtual.transferir();
				break;
			case 4:
				contaAtual.extratoMovimentacoes();
				break;
			case 5:
				contaAtual = null;
				Util.exibirMensagem("Saindo da conta...");
				break;
			default:
				Util.exibirMensagem("Opcao invalida!");
			}
		} while (op != 5);
	}
}
