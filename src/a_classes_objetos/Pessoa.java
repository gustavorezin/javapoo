package a_classes_objetos;

import javax.swing.JOptionPane;

public class Pessoa {
	private String nome;
	private double peso;
	private double altura;
	private char sexo;
	
	void cadastra() {
		nome = JOptionPane.showInputDialog("Informe o nome: ");
		peso = Double.parseDouble(JOptionPane.showInputDialog("Peso: "));
		altura = Double.parseDouble(JOptionPane.showInputDialog("Altura: "));
		sexo = JOptionPane.showInputDialog("Sexo(M/F): ").toUpperCase().charAt(0);
	}
	
	double calculaImc() {
		return peso / (altura * altura);
	}
	
	String avaliacaoImc() {
		String avaliacaoImc;
		double imc = calculaImc();
		if (Character.toString(sexo).equals("M")) {
			if (imc < 20.7) {
				avaliacaoImc = "Abaixo do peso";
			} else if(imc < 26.4) {
				avaliacaoImc = "Peso ideal";
			} else if(imc < 27.8) {
				avaliacaoImc = "Pouco acima do peso";
			} else if(imc < 31.1) {
				avaliacaoImc = "Acima do peso";
			} else {
				avaliacaoImc = "Obesidade";
			}
		} else {
			if (imc < 19.1) {
				avaliacaoImc = "Abaixo do peso";
			} else if(imc < 25.8) {
				avaliacaoImc = "Peso ideal";
			} else if(imc < 27.3) {
				avaliacaoImc = "Pouco acima do peso";
			} else if(imc < 32.4) {
				avaliacaoImc = "Acima do peso";
			} else {
				avaliacaoImc = "Obesidade";
			}
		}
		return avaliacaoImc;
	}
	
	String exibirDados() {
		return nome + " - " + calculaImc() + " - " + avaliacaoImc() + "\n"; 
	}
}
