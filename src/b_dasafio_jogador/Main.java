package b_dasafio_jogador;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Main {
	public static void main(String[] args) {
		List<Time> listaTimes = new ArrayList<>();
		String menu = "1- Cadastrar time\n"
				+ "2- Listar jogadores\n"
				+ "3- Artilheiro do campeonato\n"
				+ "4- Time com mais gols\n\n"
				+ "5- Sair";
		int op = 0;
        do {
            op = Integer.parseInt(JOptionPane.showInputDialog(menu));

            switch (op) {
                case 1:
                	cadastrarTime(listaTimes);
                    break;
                case 2:
                	listarJogadores(listaTimes);
                    break;
                case 3:
                	artilheiroCampeonato(listaTimes);
                	break;
                case 4:
                	timeMaisGols(listaTimes);
                	break;
                case 5:
                    JOptionPane.showMessageDialog(null, "Saindo...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida!");
            }
        } while (op != 5);
	}

	private static void cadastrarTime(List<Time> listaTimes) {
		Time time = new Time();
        time.cadastrar();
        listaTimes.add(time);        	
    }
	
	private static void listarJogadores(List<Time> listaTimes) {
		if (listaTimes.size() > 0) {
			String menuTimes = "Escolha um time:\n";
			for (int i = 0; i < listaTimes.size(); i++) {
				menuTimes += i + " - " + listaTimes.get(i).getNome() + "\n";
			}
			int op = Integer.parseInt(JOptionPane.showInputDialog(menuTimes));
			if(op < listaTimes.size()) {
				Time timeSelecionado = listaTimes.get(op);
				String novoJogador = JOptionPane.showInputDialog(timeSelecionado.exibir() + "\n\nAdicionar mais um jogador? (S/N)").toUpperCase();
				if (novoJogador.equals("S")) {
					timeSelecionado.cadastrarJogador();
				}
			} else {
				JOptionPane.showMessageDialog(null, "Time não encontrado");							
			}
		} else {
			JOptionPane.showMessageDialog(null, "Nenhum time cadastrado");			
		}
	}
	
	private static void artilheiroCampeonato(List<Time> listaTimes) {
		Jogador artilheiroCampeonato = null;
	    int gols = 0;

	    for (Time time : listaTimes) {
	        for (Jogador jogador : time.getJogadores()) {
	            if (jogador.getGols() > gols) {
	            	gols = jogador.getGols();
	                artilheiroCampeonato = jogador;
	            }
	        }
	    }
	    
		if (artilheiroCampeonato != null) {
			JOptionPane.showMessageDialog(null, artilheiroCampeonato.exibir());			
		} else {
			JOptionPane.showMessageDialog(null, "Nenhum jogador cadastrado");			 			
		}
	}
	
	private static void timeMaisGols(List<Time> listaTimes) {
		Time timeMaisGols = null;
	    int gols = 0;

	    for (Time time : listaTimes) {
	        int totalGolsTime = time.getTotalGols();
	        if (totalGolsTime > gols) {
	        	gols = totalGolsTime;
	            timeMaisGols = time;
	        }
	    }
	    
	    if (timeMaisGols != null) {
			JOptionPane.showMessageDialog(null, timeMaisGols.exibir());			
		} else {
			JOptionPane.showMessageDialog(null, "Nenhum time cadastrado");			 			
		}
	}
}
