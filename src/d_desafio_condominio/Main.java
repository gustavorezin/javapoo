package d_desafio_condominio;

import javax.swing.JOptionPane;

public class Main {
	public static void main(String[] args) {
		// Apenas 1 condominio
		Condominio condominio = new Condominio();
		
		String menu = "1- Cadastrar apartamento\n"
				+ "2- Cadastrar despesa\n"
				+ "3- Valor devido por proprietário\n"
				+ "4- Valor devido do apartamento\n"
				+ "5- Sair";
		int op = 0;
		do {
			op = Integer.parseInt(JOptionPane.showInputDialog(menu));
			switch (op) {
				case 1: 
					condominio.cadastrarApartamento();
					break;
				case 2: 
					condominio.cadastrarDespesa();
					break;
				case 3:
					condominio.valorDevidoPorProprietario();
					break;
				case 4: 
					condominio.extratoDespesaTotalPorApartamento();
					break;
				case 5:
                    JOptionPane.showMessageDialog(null, "Saindo...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opcao invalida!");
			}
		} while (op != 5);
	}

}
