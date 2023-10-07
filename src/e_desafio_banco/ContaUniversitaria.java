package e_desafio_banco;

import javax.swing.JOptionPane;

public class ContaUniversitaria extends Conta {

	private final double limite = 2000.0;
	
	public ContaUniversitaria() {
		super();
	}

	@Override
	public void depositar() {
		double valorDeposito = Double.parseDouble(JOptionPane.showInputDialog("Quanto deseja depositar? (R$)"));
		if (saldo + valorDeposito <= limite) {
			saldo += valorDeposito;
		} else {
			JOptionPane.showMessageDialog(null, "Limite ultrapassado!");
		}
	}
	
	@Override
	public String toString() {
		return "Conta Universitaria: num. " + numero + " | ag. " + agencia + " | saldo: R$ " + saldo + " | limite R$: " + limite;
	}
}
