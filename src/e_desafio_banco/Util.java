package e_desafio_banco;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Util {
	public static int exibirMenuPrincipal() {
		String menu = "1- Cadastrar conta\n" + "2- Acessar conta\n" + "3- Excluir conta\n" + "4- Listar contas\n"
				+ "5- Sair";
		return Integer.parseInt(Util.obterEntradaUsuario(menu));
	}

	public static int exibirMenuContas(ArrayList<Conta> contas) {
		String menu = "Qual conta: \n\n";
		for (Conta conta : contas) {
			menu += conta.toString() + "\n";
		}
		menu += "\nInformar numero da conta!\n";
		return Integer.parseInt(Util.obterEntradaUsuario(menu));
	}

	public static void exibirMensagem(String mensagem) {
		JOptionPane.showMessageDialog(null, mensagem);
	}

	public static String obterEntradaUsuario(String textoInput) {
		return JOptionPane.showInputDialog(textoInput);
	}
}
