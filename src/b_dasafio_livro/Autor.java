package b_dasafio_livro;

import javax.swing.JOptionPane;

public class Autor {
	private String nome;
	private int idade;
	private Sexo sexo;
	
	public void cadastrar() {
		
		int idadeAutor = 0;
		do {
			idadeAutor = Integer.parseInt(JOptionPane.showInputDialog("Idade: "));
		} while(idadeAutor <= 0);
		setIdade(idadeAutor);
		
		setSexo(escolherSexo());
	}
	
	private Sexo escolherSexo() {
		String[] opcoes = sexos();
        
        String escolhida = (String) JOptionPane.showInputDialog(null,
                "Sexo do autor:",
                "Escolha o sexo",
                JOptionPane.QUESTION_MESSAGE,
                null,
                opcoes,
                opcoes[0]);
        
        return Sexo.valueOf(escolhida);
    }
	
	public static String[] sexos() {
		String[] opcoes = new String[Sexo.values().length];
        for (int i = 0; i < Sexo.values().length; i++) {
            opcoes[i] = Sexo.values()[i].toString();
        }
        
        return opcoes;
	}
	
	public String exibir() {
		return getNome() + " - Idade: " + getIdade() + " anos | " + getSexo() + "\n";
	}
	
	public static boolean validarNomeSobrenome(String nomeCompleto) {
        String[] partesNome = nomeCompleto.split(" ");
        return partesNome.length == 2;
    }

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}
	
	
}
