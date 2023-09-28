package a_desafio_I;

import javax.swing.JOptionPane;

public class Carro {
	private String marca;
	private int anoFabricacao;
	private Cor cor;
	
	public boolean cadastrarCarro() {
		marca = JOptionPane.showInputDialog("Marca do carro: ").toUpperCase();
		anoFabricacao = Integer.parseInt(JOptionPane.showInputDialog("Ano de fabricação: "));
		cor = escolherCor();
		return validarCadastro();
	}
	
	private Cor escolherCor() {
		String[] opcoes = cores();
        
        String escolhida = (String) JOptionPane.showInputDialog(null,
                "Escolha a cor do carro:",
                "Escolha a cor",
                JOptionPane.QUESTION_MESSAGE,
                null,
                opcoes,
                opcoes[0]);
        
        return Cor.valueOf(escolhida);
    }
	
	public static String[] cores() {
		String[] opcoes = new String[Cor.values().length];
        for (int i = 0; i < Cor.values().length; i++) {
            opcoes[i] = Cor.values()[i].toString();
        }
        
        return opcoes;
	}
	
	private boolean validarCadastro() {
	    StringBuilder mensagemErro = new StringBuilder();
	    
	    if (marca.isEmpty()) {
	        mensagemErro.append("Marca é obrigatória!\n");
	    }
	    if (cor == null) {
	        mensagemErro.append("Cor é obrigatória!\n");
	    }
	    if (anoFabricacao < 1954 || anoFabricacao > 2023) {
	        mensagemErro.append("Ano inválido!\n");
	    }
	    
	    if (mensagemErro.length() > 0) {
	        JOptionPane.showMessageDialog(null, mensagemErro.toString());
	        return false;
	    }
	    
	    return true;
	}
	
	public String exibir() {
		return marca + " - " + cor + " - " + anoFabricacao + "\n";
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public int getAnoFabricacao() {
		return anoFabricacao;
	}

	public void setAnoFabricacao(int anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}

	public Cor getCor() {
		return cor;
	}

	public void setCor(Cor cor) {
		this.cor = cor;
	}
	
	
	
}
