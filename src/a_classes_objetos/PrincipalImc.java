package a_classes_objetos;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class PrincipalImc {

	public static void main(String[] args) {
		
		List<Pessoa> listaPessoas = new ArrayList<Pessoa>();
		
		String menu = "1- Cadastrar\n2- Listar\n3- Sair";
		int op = 0;
		
		do {
			op = Integer.parseInt(JOptionPane.showInputDialog(menu));
			if (op == 1) {
				Pessoa pessoa = new Pessoa();
				pessoa.cadastra();
				listaPessoas.add(pessoa);
			} else if (op == 2) {
				String resultado = "";
				for (Pessoa pessoa : listaPessoas) {
					resultado += pessoa.exibirDados();
				}
				JOptionPane.showMessageDialog(null, resultado); 
			}
		} while (op != 3);
	}

}
