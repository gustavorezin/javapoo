package d_desafio_biblioteca;

public class Livro {
	private String titulo;
	private Autor autor;
	private Bibliotecario bibliotecario;
	
	public Livro(String titulo, Autor autor, Bibliotecario bibliotecario) {
		this.titulo = titulo;
		this.autor = autor;
		this.bibliotecario = bibliotecario;
	}

	public static String emprestar(String nome) {
		return "Livro emprestado para: " + nome;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public Bibliotecario getBibliotecario() {
		return bibliotecario;
	}

	public void setBibliotecario(Bibliotecario bibliotecario) {
		this.bibliotecario = bibliotecario;
	}
}
