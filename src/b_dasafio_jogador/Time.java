package b_dasafio_jogador;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Time {
	private String nome;
	private List<Jogador> jogadores = new ArrayList<>();
	
	public void cadastrar() {
		setNome(JOptionPane.showInputDialog("Nome do time:"));
		cadastrarJogador();
	}
	
	public void cadastrarJogador() {
		String continua = "";
		do {
			Jogador j = new Jogador();
			j.cadastrar();
			jogadores.add(j);
			continua = JOptionPane.showInputDialog("Adicionar mais um jogador? (S/N)").toUpperCase();
		} while(continua.equals("S"));
	}
	
	public String exibir() {
		String dados = "*** " + getNome() + " ****\n";
		for (Jogador j : jogadores) {
			dados += j.exibir();
		}
		dados += "\nTotal de gols: " + getTotalGols(); 
		return dados;
	}
	
	public Jogador getArtilheiro() {
		Jogador artilheiro = jogadores.get(0);
		for (Jogador j : jogadores) {
			if(j.getGols() > artilheiro.getGols()) {
				artilheiro = j;
			}
		}
		return artilheiro;
	}
	
	public int getTotalGols() {
		int gols = 0;
		for (Jogador j : jogadores) {
			gols += j.getGols();
		}
		return gols;
	}
	
	public String getNome() {
		return nome.toUpperCase();
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public List<Jogador> getJogadores() {
		return jogadores;
	}
	public void setJogadores(List<Jogador> jogadores) {
		this.jogadores = jogadores;
	}
	
	
}
