package b_dasafio_jogador;

import javax.swing.JOptionPane;

public class Jogador {
	private String nome;
	private int camisa;
	private int gols;
	
	public void cadastrar() {
		setNome(JOptionPane.showInputDialog("Nome jogador: "));
		setCamisa(Integer.parseInt(JOptionPane.showInputDialog("Camisa: ")));
		setGols(Integer.parseInt(JOptionPane.showInputDialog("Gols: ")));
	}
	
	public String exibir() {
		return getNome() + " - Camisa: " + getCamisa() + " | " + getGols() + " gols\n";
	}
	
	public String getNome() {
		return nome.toUpperCase();
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getCamisa() {
		return camisa;
	}
	public void setCamisa(int camisa) {
		this.camisa = camisa;
	}
	public int getGols() {
		return gols;
	}
	public void setGols(int gols) {
		this.gols = gols;
	}
}
