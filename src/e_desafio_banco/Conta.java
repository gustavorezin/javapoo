package e_desafio_banco;

import java.util.HashSet;
import java.util.Set;

import javax.swing.JOptionPane;

public class Conta {
	protected int numero;
	protected int agencia;
	protected String nomeCorrentista;
	protected double saldo;
	
	private static Set<Integer> numerosDeContas = new HashSet<>();
	
	public Conta() {
		do {
            this.numero = Integer.parseInt(JOptionPane.showInputDialog("Número da Conta:"));
            if (numerosDeContas.contains(numero)) {
            	JOptionPane.showMessageDialog(null, "Número de conta já cadastrado!");
            }
        } while (numerosDeContas.contains(numero));
        numerosDeContas.add(numero);
        this.agencia = Integer.parseInt(JOptionPane.showInputDialog("Número da Agência:"));
        this.nomeCorrentista = JOptionPane.showInputDialog("Nome do Correntista:");
        this.saldo = Double.parseDouble(JOptionPane.showInputDialog("Saldo Inicial (R$):"));
    }
	
	public void depositar() {
		double valorDeposito = Double.parseDouble(JOptionPane.showInputDialog("Quanto deseja depositar? (R$)"));
		saldo += valorDeposito;
	}
	
	public void sacar() {
		double valorSaque = Double.parseDouble(JOptionPane.showInputDialog("Quanto deseja sacar? (R$)"));
		if (valorSaque <= saldo) {
			saldo -= valorSaque;
		} else {
			JOptionPane.showMessageDialog(null, "Saldo insuficiente!");
		}
	}
	
	public void transferir() {
		double valorTransferencia = Double.parseDouble(JOptionPane.showInputDialog("Quanto deseja transferir? (R$)"));
		if (valorTransferencia <= saldo) {
			saldo -= valorTransferencia;
		}
	}
	
	@Override
	public String toString() {
		return "Conta Corrente: num. " + numero + " | ag. " + agencia + " | saldo: R$ " + saldo;
	}
}
