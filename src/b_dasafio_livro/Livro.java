package b_dasafio_livro;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;

public class Livro {
	private String titulo;
	private double preco;
	private List<Autor> autores = new ArrayList<>();
	
	public void cadastrar(Map<String, Autor> autoresCadastrados) {
		setTitulo(JOptionPane.showInputDialog("Titulo do livro:"));
		double precoLivro = 0;
		do {
			precoLivro = Double.parseDouble(JOptionPane.showInputDialog("Preço: "));
		} while(precoLivro <= 0);
		setPreco(precoLivro);
		cadastrarAutor(autoresCadastrados);
	}
	
	public void cadastrarAutor(Map<String, Autor> autoresCadastrados) {
		String continua = "";
		do {
			
			String nomeAutor = "";
			do {
				nomeAutor = JOptionPane.showInputDialog("Nome e sobrenome autor: ").trim();	
			} while (!Autor.validarNomeSobrenome(nomeAutor));
			
			Autor autorExistente = autoresCadastrados.get(nomeAutor);

	        if (autorExistente != null) {
	            autores.add(autorExistente);
	        } else {
	        	Autor a = new Autor();
	        	a.setNome(nomeAutor);
	        	a.cadastrar();
	        	autores.add(a);	      
	        	autoresCadastrados.put(a.getNome(), a);
	        }
			
			if(autores.size() < 4) {
				continua = JOptionPane.showInputDialog("Adicionar mais um autor? (S/N)").toUpperCase();				
			} else {
				break;
			}
		} while(continua.equals("S"));
	}
	
	public String exibirSimples() {
		return getTitulo() + " (" + formatarPreco(getPreco()) + ")\n";
	}
	
	public String exibir() {
		String dados = "*** " + getTitulo() + " (" + formatarPreco(getPreco()) + ") ***\n\nAutores:\n";
		for (Autor a : autores) {
			dados += a.exibir();
		} 
		return dados;
	}
	
	private String formatarPreco(double preco) {
        NumberFormat format = NumberFormat.getCurrencyInstance();
        return format.format(preco);
    }
	
	public String getTitulo() {
		return titulo.toLowerCase();
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public List<Autor> getAutores() {
		return autores;
	}
	public void setAutores(List<Autor> autores) {
		this.autores = autores;
	}
	
	
}
