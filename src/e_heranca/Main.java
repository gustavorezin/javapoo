package e_heranca;

public class Main {
	public static void main(String[] args) {
		Produto p = new Produto();
//		p.nome = "Celta";
//		p.preco = 17000;
//		System.out.println(p.ehCaro());
		
		Livro l = new Livro();
		l.nome = "Livro";
		l.preco = 50;
		l.autor = "Gustavo";
		l.paginas = 300;
//		System.out.println(l.ehCaro());
//		System.out.println(l.ehGrande());
		System.out.println(l.toString());
	}
}
