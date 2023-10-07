package e_desafio_banco;

import javax.swing.JOptionPane;

public class ContaEspecial extends Conta {
	private double limite;

	public ContaEspecial() {
		super();
		double valorLimite = 0.0;
		do {
			valorLimite = Double.parseDouble(JOptionPane.showInputDialog("Limite (R$):"));
			if (valorLimite < saldo) {
				JOptionPane.showMessageDialog(null, "Limite deve ser maior que o saldo inicial!");
			}
		} while (valorLimite < saldo);
		this.limite = valorLimite;
	}
	
	@Override
	public void sacar() {
		double valorSaque = Double.parseDouble(JOptionPane.showInputDialog("Quanto deseja sacar? (R$)"));
		if (valorSaque <= limite && valorSaque <= saldo) {
			saldo -= valorSaque;
		} else {
			JOptionPane.showMessageDialog(null, "Saldo insuficiente ou limite ultrapassado!");
		}
	}
	
	@Override
	public String toString() {
		return "Conta Especial: num. " + numero + " | ag. " + agencia + " | saldo: R$ " + saldo + " | limite R$: " + limite;
	}
}
