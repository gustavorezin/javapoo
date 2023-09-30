package d_desafio_biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Autor {
	private String nome;
	private ArrayList<Livro> livros;
	
	public Autor(String nome, ArrayList<Livro> livros) {
		this.nome = nome;
		this.livros = livros;
	}
	
	public void adicionaLivro(Livro livro) {
		livros.add(livro);
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
