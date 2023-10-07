package e_desafio_banco;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Main {
	static ArrayList<Conta> contas = new ArrayList<Conta>();
	
	public static void main(String[] args) {
		int op = 0;
		do {
			op = menu();
			switch (op) {
				case 1: 
					cadastrarConta();
					break;
				case 2: 
					sacar();
					break;
				case 3:
					
					break;
				case 4: 
					
					break;
				case 5:
                    JOptionPane.showMessageDialog(null, "Saindo...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opcao invalida!");
			}
		} while (op != 5);
	}
	
	public static int menu() {
		String menu = "1- Cadastrar conta\n"
				+ "2- Sacar\n"
				+ "3- Depositar\n"
				+ "4- Transferir\n"
				+ "5- Sair";
		return Integer.parseInt(JOptionPane.showInputDialog(menu));
	}
	
	public static int menuContas() {
		String menu = "Tipo de conta:\n\n"
				+ "1- Corrente\n"
				+ "2- Especial\n"
				+ "3- Universitaria\n";
		return Integer.parseInt(JOptionPane.showInputDialog(menu));
	}
	
	public static void cadastrarConta() {
		int op = menuContas();
		
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
			break;
		}		
	}
	
	public static void sacar() {
		if(contas.size() > 0) {
			String menu = "Deseja sacar de qual conta: \n\n";
			for (Conta conta : contas) {
				menu += conta.toString() + "\n";
			}
			menu += "\nInformar numero da conta!\n";
			int op = Integer.parseInt(JOptionPane.showInputDialog(menu));
			
			for (Conta conta : contas) {
				if(conta.numero == op) {
					conta.sacar();
				}
			}				
		} else {
			JOptionPane.showMessageDialog(null, "Nenhuma conta cadastrada!");
		}
	}
	
}

