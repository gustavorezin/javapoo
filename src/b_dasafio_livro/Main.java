package b_dasafio_livro;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;

public class Main {
	public static void main(String[] args) {
		List<Livro> listaLivros = new ArrayList<>();
		Map<String, Autor> autoresCadastrados = new HashMap<>();
		
		String menu = "1- Cadastrar livro\n"
				+ "2- Listar livros\n"
				+ "3- Sair";
		int op = 0;
        do {
            op = Integer.parseInt(JOptionPane.showInputDialog(menu));

            switch (op) {
                case 1:
                	cadastrarLivro(listaLivros, autoresCadastrados);
                    break;
                case 2:
                	listarLivros(listaLivros, autoresCadastrados);
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "Saindo...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opcao invalida!");
            }
        } while (op != 3);
	}

	private static void cadastrarLivro(List<Livro> listaLivros, Map<String, Autor> autoresCadastrados) {
		Livro livro = new Livro();
        livro.cadastrar(autoresCadastrados);
        listaLivros.add(livro);        	
    }
	
	private static void listarLivros(List<Livro> listaLivros, Map<String, Autor> autoresCadastrados) {
		String menu = "1- Todos\n"
				+ "2- Por autor\n"
				+ "3- Por valor\n"
				+ "4- Autores crianca\n"
				+ "5- Por sexo\n\n"
				+ "6- Voltar";
		int op = 0;
        do {
            op = Integer.parseInt(JOptionPane.showInputDialog(menu));

            switch (op) {
                case 1:
                	listarLivrosTodos(listaLivros, autoresCadastrados);
                    break;
                case 2:
                	listarLivrosAutor(listaLivros, autoresCadastrados);
                    break;
                case 3:
                	listarLivrosPorValor(listaLivros);
                	break;
                case 4:
                	listarLivrosAutoresCriancas(listaLivros, autoresCadastrados);
                	break;
                case 5:
                	listarLivrosSexo(listaLivros, autoresCadastrados);
                	break;
                case 6:
                    JOptionPane.showMessageDialog(null, "Voltando...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opcao invalida!");
            }
        } while (op != 6);
	}
	
	private static void listarLivrosTodos(List<Livro> listaLivros,  Map<String, Autor> autoresCadastrados) {
		if (listaLivros.size() > 0) {
			String menuLivros = "Escolha um livro:\n";
			for (int i = 0; i < listaLivros.size(); i++) {
				menuLivros += i + " - " + listaLivros.get(i).getTitulo() + "\n";
			}
			int op = Integer.parseInt(JOptionPane.showInputDialog(menuLivros));
			if(op < listaLivros.size()) {
				Livro livroSelecionado = listaLivros.get(op);
				if(livroSelecionado.getAutores().size() < 4) {
					String novoAutor = JOptionPane.showInputDialog(livroSelecionado.exibir() + "\nAdicionar mais um autor? (S/N)").toUpperCase();
					if (novoAutor.equals("S")) {
						livroSelecionado.cadastrarAutor(autoresCadastrados);
					}					
				} else {
					JOptionPane.showMessageDialog(null, livroSelecionado.exibir());
				}
			} else {
				JOptionPane.showMessageDialog(null, "Livro nao encontrado");							
			}
		} else {
			JOptionPane.showMessageDialog(null, "Nenhum livro cadastrado");			
		}
	}
	
	private static void listarLivrosAutor(List<Livro> listaLivros, Map<String, Autor> autoresCadastrados) {
	    if (listaLivros.size() > 0) {
	    	if (!autoresCadastrados.isEmpty()) {
	            String menuAutores = "Escolha um autor:\n";
	            int index = 0;

	            for (Autor autor : autoresCadastrados.values()) {
	                menuAutores += index + " - " + autor.getNome() + "\n";
	                index++;
	            }

	            int op = Integer.parseInt(JOptionPane.showInputDialog(menuAutores));
	            
	            if (op >= 0 && op < autoresCadastrados.size()) {
	                Autor autorSelecionado = new ArrayList<>(autoresCadastrados.values()).get(op);
	                List<Livro> livrosDoAutor = new ArrayList<>();

	                for (Livro livro : listaLivros) {
	                    for (Autor autorLivro : livro.getAutores()) {
	                        if (autorLivro.equals(autorSelecionado)) {
	                            livrosDoAutor.add(livro);
	                            break;  // Não é necessário continuar verificando os outros autores do livro
	                        }
	                    }
	                }

	                if (!livrosDoAutor.isEmpty()) {
	                    String listaLivrosAutor = "Livros do autor " + autorSelecionado.getNome() + ":\n ----------------- \n";
	                    for (Livro livro : livrosDoAutor) {
	                        listaLivrosAutor += livro.exibirSimples();
	                    }
	                    JOptionPane.showMessageDialog(null, listaLivrosAutor);
	                } else {
	                    JOptionPane.showMessageDialog(null, "Nenhum livro encontrado para o autor selecionado");
	                }
	            } else {
	                JOptionPane.showMessageDialog(null, "Autor nao encontrado");
	            }
	        } else {
	            JOptionPane.showMessageDialog(null, "Nenhum autor cadastrado");
	        }
	    } else {
	        JOptionPane.showMessageDialog(null, "Nenhum livro cadastrado");
	    }
	}
	
	private static void listarLivrosPorValor(List<Livro> listaLivros) {
	    double valorMinimo = Double.parseDouble(JOptionPane.showInputDialog("Valor mínimo: "));
	    double valorMaximo = Double.parseDouble(JOptionPane.showInputDialog("Valor máximo: "));
	    
	    StringBuilder livrosEncontrados = new StringBuilder();
	    
	    for (Livro livro : listaLivros) {
	        if (livro.getPreco() >= valorMinimo && livro.getPreco() <= valorMaximo) {
	            livrosEncontrados.append(livro.exibirSimples()).append("\n");
	        }
	    }
	    
	    if (livrosEncontrados.length() > 0) {
	        JOptionPane.showMessageDialog(null, livrosEncontrados.toString());
	    } else {
	        JOptionPane.showMessageDialog(null, "Nenhum livro encontrado dentro da faixa de valor.");
	    }
	}
	
	private static void listarLivrosAutoresCriancas(List<Livro> listaLivros, Map<String, Autor> autoresCadastrados) {
	    List<Livro> livrosComAutoresCriancas = new ArrayList<>();
	    
	    for (Livro livro : listaLivros) {
	        for (Autor autorLivro : livro.getAutores()) {
	            Autor autorCompleto = autoresCadastrados.get(autorLivro.getNome());
	            if (autorCompleto != null && autorCompleto.getIdade() <= 12) {
	                livrosComAutoresCriancas.add(livro);
	                break;
	            }
	        }
	    }
	    
	    if (!livrosComAutoresCriancas.isEmpty()) {
	        StringBuilder listaLivrosCriancas = new StringBuilder("Livros com autores crianças:\n ----------------- \n");
	        for (Livro livro : livrosComAutoresCriancas) {
	            listaLivrosCriancas.append(livro.exibirSimples());
	        }
	        JOptionPane.showMessageDialog(null, listaLivrosCriancas.toString());
	    } else {
	        JOptionPane.showMessageDialog(null, "Nenhum livro encontrado com autores crianças.");
	    }
	}
	
	private static void listarLivrosSexo(List<Livro> listaLivros, Map<String, Autor> autoresCadastrados) {
	    String[] opcoesSexo = Autor.sexos();
	    String escolhaSexo = (String) JOptionPane.showInputDialog(
	        null,
	        "Escolha o sexo dos autores:",
	        "Selecionar Sexo",
	        JOptionPane.QUESTION_MESSAGE,
	        null,
	        opcoesSexo,
	        opcoesSexo[0]
	    );
	    
	    Sexo sexoSelecionado = escolhaSexo.equals("MASCULINO") ? Sexo.MASCULINO : Sexo.FEMININO;
	    
	    List<Livro> livrosPorSexo = new ArrayList<>();
	    
	    for (Livro livro : listaLivros) {
	        boolean todosAutoresDoSexo = true;
	        for (Autor autorLivro : livro.getAutores()) {
	            Autor autorCompleto = autoresCadastrados.get(autorLivro.getNome());
	            if (autorCompleto != null && autorCompleto.getSexo() != sexoSelecionado) {
	                todosAutoresDoSexo = false;
	                break;
	            }
	        }
	        if (todosAutoresDoSexo) {
	            livrosPorSexo.add(livro);
	        }
	    }
	    
	    if (!livrosPorSexo.isEmpty()) {
	        StringBuilder listaLivrosPorSexo = new StringBuilder("Livros escritos por autores do sexo " + sexoSelecionado + ":\n ----------------- \n\n");
	        for (Livro livro : livrosPorSexo) {
	            listaLivrosPorSexo.append(livro.exibirSimples());
	        }
	        JOptionPane.showMessageDialog(null, listaLivrosPorSexo.toString());
	    } else {
	        JOptionPane.showMessageDialog(null, "Nenhum livro encontrado com apenas autores desse sexo.");
	    }
	}
}
