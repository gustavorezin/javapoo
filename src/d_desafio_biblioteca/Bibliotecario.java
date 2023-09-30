package d_desafio_biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Bibliotecario {
	private String nome;
	private ArrayList<Livro> livros;
	
	public Bibliotecario(String nome) {
		this.nome = nome;
		this.livros = new ArrayList<Livro>();
	}

	public void cadastrarLivro(String titulo, Autor autor) {
		livros.add(new Livro(titulo, autor, this));
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Livro> getLivros() {
		return livros;
	}

	public void setLivros(ArrayList<Livro> livros) {
		this.livros = livros;
	}
}
